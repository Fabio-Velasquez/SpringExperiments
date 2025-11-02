package org.example.demomaximizetpscap.Monitor;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Data
@Component
public class ThreadMonitor {
    private final ThreadPoolExecutor threadPoolExecutor;

    public ThreadMonitor(ThreadPoolExecutor threadPoolExecutor) {
        this.threadPoolExecutor = threadPoolExecutor;
    }

    public void start() {
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            System.out.println("[Monitor] Active: " + threadPoolExecutor.getActiveCount()
                    + " | Completed: " + threadPoolExecutor.getCompletedTaskCount()
                    + " | Queue: " + threadPoolExecutor.getQueue().size());
        }, 0, 1, TimeUnit.SECONDS);
    }
}