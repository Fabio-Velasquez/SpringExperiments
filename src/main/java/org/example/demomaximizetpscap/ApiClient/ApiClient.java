package org.example.demomaximizetpscap.ApiClient;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

public interface ApiClient<T> {


    T call(String id);
}
