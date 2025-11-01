package org.example.demomaximizetpscap.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DemoConfiguration {


    public DemoConfiguration() {

    }
    @Bean
    @Primary
    public RestTemplate getNarutoRestTemplate() {
        return new RestTemplate();
    }
}
