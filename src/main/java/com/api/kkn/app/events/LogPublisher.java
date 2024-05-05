package com.api.kkn.app.events;


import com.api.kkn.app.entity.Log;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class LogPublisher {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishLogEvent(String message) {
        Log log =new Log();
        HttpServletRequest request=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.setMessage("Test");
        log.setHost(request.getHeader("host"));
        log.setUserAgent(request.getHeader("User-Agent"));
        log.setMessage(message);
        LogEvent logEvent = new LogEvent(this, log);
        applicationEventPublisher.publishEvent(logEvent);
    }
}
