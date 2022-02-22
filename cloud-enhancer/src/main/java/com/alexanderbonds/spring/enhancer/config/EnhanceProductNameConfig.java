package com.alexanderbonds.spring.enhancer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Slf4j
@Configuration
public class EnhanceProductNameConfig {
    @Bean
    public Function<String, String> enhance() {
        return productName -> {
            log.info("Got Product name from Spring Stream: {}", productName);
            String enhanced = "Enhanced " + productName;
            log.info("Pushed enhanced Product name to Spring Stream: {}", enhanced);
            return enhanced;
        };
    }
}
