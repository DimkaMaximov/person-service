package liga.medical.personservice.core;

import liga.medical.personservice.core.model.ContactEntity;
import liga.medical.personservice.core.model.LogEntity;
import liga.medical.personservice.core.repository.LogEntityRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Aspect
@Component
public class LoggingAdvice {

    @Autowired
    LogEntityRepository repository;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within (liga.medical.personservice.core.controller.*)")
    public void controllersPc() {
    }

    @Pointcut("execution(* org.springframework.security.core.userdetails.UserDetailsService.loadUserByUsername(String))")
    public void userDetailsServicePc() {
    }

    @Around("controllersPc()")
    public Object controllersLogging(ProceedingJoinPoint pjp) {

        LocalDateTime eventTime = LocalDateTime.now();
        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();
        ContactEntity contact = (ContactEntity) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        LogEntity logEntity = LogEntity.builder()
                .eventTime(eventTime)
                .methodName(methodName)
                .className(className)
                .email(contact.getEmail())
                .build();

        repository.insert(logEntity);
        Long eventId = repository.findLogId(eventTime);
        log.info("Log#{} {} Вызван метод: {}:{}() с аккаунта: {}", eventId, eventTime, className, methodName, logEntity.getEmail());

        Object object = null;
        try {
            object = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return object;
    }

    @Around("userDetailsServicePc()")
    public Object authenticationLogging(ProceedingJoinPoint pjp) {

        Object[] array = pjp.getArgs();
        String email = array[0].toString();
        LocalDateTime eventTime = LocalDateTime.now();

        LogEntity logEntity = LogEntity.builder()
                .eventTime(eventTime)
                .email(email)
                .build();

        repository.insert(logEntity);
        Long eventId = repository.findLogId(eventTime);

        Object object = null;
        try {
            object = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        if (object != null) {
            log.info("Log#{} {} Аутентификация с email: {} завершена успешно", eventId, eventTime, logEntity.getEmail());
        } else log.info("Log#{} {} Ошибка аутентификации. Аккаунт с email: {} не зарегистрирован", eventId, eventTime, logEntity.getEmail());

        return object;
    }
}