package liga.medical.personservice.core;

import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
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

//    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    LogEntityRepository repository;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within (liga.medical.personservice.core.controller.*)")
    public void controllerPc() {
    }

    @Pointcut("execution(* org.springframework.security.core.userdetails.UserDetailsService.loadUserByUsername(String))")
    public void userDetailsServicePc(){
    }

//    @AfterThrowing(value = "userDetailsServicePc()", throwing = "ex")
//    public void authorisationException(Throwable ex) {
//        log.info("Ошибка авторизации");
//    }

    @Around("controllerPc()")
    public Object controllerLogging(ProceedingJoinPoint pjp) throws JsonProcessingException {

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
    public Object authorisationLogging(ProceedingJoinPoint pjp) {
        Object[] array = pjp.getArgs();
        String email = array[0].toString();
        LocalDateTime eventTime = LocalDateTime.now();

        LogEntity logEntity = LogEntity.builder()
                .eventTime(eventTime)
                .email(email)
                .build();

        repository.insert(logEntity);
        Long eventId = repository.findLogId(eventTime);
        log.info("Log#{} {} Попытка авторизации с email: {}", eventId, eventTime, logEntity.getEmail());

        Object object = null;
        try {
            object = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        log.info("Log#{} {} Авторизация завершена с email: {}", eventId, eventTime, logEntity.getEmail());

        return object;
    }
}