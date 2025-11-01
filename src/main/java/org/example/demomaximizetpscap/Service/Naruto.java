package org.example.demomaximizetpscap.Service;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.example.demomaximizetpscap.model.CharacterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Service
public class Naruto {
    private final RestTemplate restTemplate;
    @Value("https://dattebayo-api.onrender.com")
    private String narutoUrl;
    public Naruto(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @RateLimiter(name = "getCharacterById")
    @Retryable(maxAttempts = 3, backoff = @Backoff(delay = 5000))
    public CharacterEntity getCharacterById(String id) {
        return restTemplate.getForObject(narutoUrl + "/characters/" + id, CharacterEntity.class);
    }



}
