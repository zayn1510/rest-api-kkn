package com.api.kkn.app.logging;

import com.api.kkn.app.events.LogPublisher;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private final LogPublisher logPublisher; // Inject logPublisher

    public LoggingAspect(LogPublisher logPublisher) {
        this.logPublisher = logPublisher;
    }

    @Before("execution(* com.api.kkn.app.controllers.PeriodeKknController.*(..))")
    public void logBeforeControllerMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logPublisher.publishLogEvent(methodName + " via API");
    }
}
