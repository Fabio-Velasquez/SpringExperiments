package org.example.demomaximizetpscap.ApiProcessor;


import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import lombok.Data;
import org.example.demomaximizetpscap.ApiClient.ApiClient;
import org.springframework.stereotype.Service;
import io.github.resilience4j.ratelimiter.RateLimiter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Data
@Service
public class ApiProcessor<T> {
    private ThreadPoolExecutor executorService;
    private RateLimiter rateLimiter;


    public ApiProcessor(ThreadPoolExecutor executorService, RateLimiter rateLimiter) {
        this.executorService =  executorService;
        this.rateLimiter = rateLimiter;
    }

    public List<T> process(List<String> ids, ApiClient<T> client) {
        List<T> results = new CopyOnWriteArrayList<>();
        for(String id : ids) {
            rateLimiter.acquirePermission();
            executorService.submit(() -> {
                try {
                    T result = client.call(id);
                    if(result != null) {
                        results.add(result);
                    }
                } catch (Exception e) {
                    System.err.println("Exception occurred while processing id: " + id + ", exception: " +e.getMessage());
                }
            });

        }
            shutdownAndAwaitTermination();
            return results;
    }

    private void shutdownAndAwaitTermination() {
        executorService.shutdown();
        try {
            executorService.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
