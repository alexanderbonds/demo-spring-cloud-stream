package com.alexanderbonds.spring.producer.config;

import com.alexanderbonds.spring.producer.services.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class ProductProducerConfig {
    private final ProductService productService;

    @Bean
    public Consumer<String> product() {
        return productName -> {
            log.info("Got a Product name from Spring Stream: {}", productName);
            productService.process(productName);
        };
    }
}
