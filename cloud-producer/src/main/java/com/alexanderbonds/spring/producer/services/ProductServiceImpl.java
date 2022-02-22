package com.alexanderbonds.spring.producer.services;

import com.alexanderbonds.spring.producer.model.Product;
import com.alexanderbonds.spring.producer.services.interfaces.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public void process(String productName) {
        log.info("Created a product from Spring Stream: {}", new Product(productName));
    }
}
