package org.example.demomaximizetpscap.Service;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.example.demomaximizetpscap.ApiClient.ApiClient;
import org.example.demomaximizetpscap.model.CharacterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Service
public class Naruto implements ApiClient<CharacterEntity> {
    private final RestTemplate restTemplate;

    @Value("https://dattebayo-api.onrender.com")
    private String narutoUrl;

    public Naruto(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RateLimiter(name = "getCharacterById")
    @Override
    public CharacterEntity call(String id) {
        return restTemplate.getForObject(narutoUrl + "/characters/" + id, CharacterEntity.class);
    }








}
