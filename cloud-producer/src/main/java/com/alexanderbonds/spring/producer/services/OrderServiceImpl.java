package com.alexanderbonds.spring.producer.services;

import com.alexanderbonds.spring.producer.model.Product;
import com.alexanderbonds.spring.producer.services.interfaces.OrderService;
import com.alexanderbonds.spring.stream.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public void process(OrderDto order) {
        IntStream.range(1, order.getProductAmount() + 1)
                .forEach(
                        index -> log.info(
                                "New Product created for order {}: {}",
                                order.getId(),
                                new Product(order.getProductName() + "_" + index)
                        )
                );
    }
}
