package com.fundoo.notes.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.fundoo.notes.controller..*(..))")
    public void logBeforeControllerMethod(JoinPoint joinPoint) {
        logger.info("Controller method started: {}", joinPoint.getSignature().toShortString());
    }

    @AfterReturning(
            pointcut = "execution(* com.fundoo.notes.controller..*(..))",
            returning = "result"
    )
    public void logAfterControllerMethod(JoinPoint joinPoint, Object result) {
        logger.info("Controller method completed: {}", joinPoint.getSignature().toShortString());
    }

    @Around("execution(* com.fundoo.notes.service..*(..))")
    public Object logServiceExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long endTime = System.currentTimeMillis();

        logger.info(
                "Service method {} executed in {} ms",
                proceedingJoinPoint.getSignature().toShortString(),
                endTime - startTime
        );

        return result;
    }

    @AfterThrowing(
            pointcut = "execution(* com.fundoo.notes.controller..*(..)) || execution(* com.fundoo.notes.service..*(..))",
            throwing = "exception"
    )
    public void logException(JoinPoint joinPoint, Throwable exception) {
        logger.error(
                "Exception in method {}: {}",
                joinPoint.getSignature().toShortString(),
                exception.getMessage()
        );
    }
}