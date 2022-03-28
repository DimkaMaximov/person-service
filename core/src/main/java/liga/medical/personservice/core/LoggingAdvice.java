package liga.medical.personservice.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public void controller() {
    }

    @Around("controller()")
    public Object controllerLogging(ProceedingJoinPoint pjp) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

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
        Object[] array = pjp.getArgs();

        repository.insert(logEntity);
        Long eventId = repository.findLogId(eventTime);
        log.info("Log#{} {} Вызван метод: {}:{}() с аргументами{}", eventId, eventTime, className, methodName, objectMapper.writeValueAsString(array));

        Object object = null;
        try {
            object = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        log.info("Log#{} {} {}:{}() Response: {}",  eventId, eventTime, className, methodName, objectMapper.writeValueAsString(object));

        return object;
    }
}