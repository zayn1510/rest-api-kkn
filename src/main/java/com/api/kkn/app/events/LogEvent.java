package com.api.kkn.app.events;

import com.api.kkn.app.entity.Log;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;

@Getter
public class LogEvent extends ApplicationEvent {

    private Log data;
    public LogEvent(Object source,Log log) {
        super(source);
        this.data=log;
    }
}
