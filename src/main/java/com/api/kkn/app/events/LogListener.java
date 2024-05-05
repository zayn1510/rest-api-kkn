package com.api.kkn.app.events;

import com.api.kkn.app.entity.Log;
import com.api.kkn.app.repository.LogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class LogListener {
    @Autowired
    private LogsRepository logsRepository;
    @EventListener
    public void handleLogEvent(LogEvent logEvent) {
        Log log = logEvent.getData();
        // Simpan log ke database
        logsRepository.save(log);
    }

}
