package com.alexanderbonds.spring.producer.services.interfaces;

import com.alexanderbonds.spring.stream.dto.OrderDto;

public interface OrderService {
    void process(OrderDto order);
}
