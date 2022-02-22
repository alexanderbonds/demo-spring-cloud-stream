package com.alexanderbonds.spring.producer.config;

import com.alexanderbonds.spring.producer.services.interfaces.OrderService;
import com.alexanderbonds.spring.stream.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class OrderConsumerConfig {
    private final OrderService orderService;

    @Bean
    public Consumer<OrderDto> order() {
        return order -> {
            log.info("Got an order from Spring Stream: {}", order);
            orderService.process(order);
        };
    }
}
