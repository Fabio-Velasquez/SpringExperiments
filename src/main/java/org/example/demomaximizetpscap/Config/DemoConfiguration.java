package org.example.demomaximizetpscap.Config;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class DemoConfiguration {

    private final int RATE_LIMITER_LIMIT_PERIOD = 20;
    private final int RATE_LIMITER_REFRESH_PERIOD = 1;
    public DemoConfiguration() {

    }
    @Bean
    @Primary
    public RestTemplate getNarutoRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    @Primary
    public ThreadPoolExecutor getThreadPoolExecutor() {
        return (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
    }
    @Bean
    @Primary
    public RateLimiter getRateLimiter() {
        return RateLimiter.of("apiLimiter", RateLimiterConfig.custom()
                .limitForPeriod(RATE_LIMITER_LIMIT_PERIOD)
                .limitRefreshPeriod(Duration.ofSeconds(RATE_LIMITER_REFRESH_PERIOD))
                .timeoutDuration(Duration.ZERO)
                .build());
    }


}
