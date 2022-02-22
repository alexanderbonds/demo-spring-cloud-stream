package my.alexanderbonds.spring.stream.web.controllers;

import com.alexanderbonds.spring.stream.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
public class ProduceController {
    private final StreamBridge streamBridge;

    @Value("${app.demo.products.exchange}")
    private String productExchange;

    @Value("${app.demo.orders.exchange}")
    private String orderExchange;

    @GetMapping
    public void requestNewProduct(@RequestParam(name = "name") String productName) {
        log.info("Got new request for Product {}", productName);
        streamBridge.send(productExchange, productName);
    }

    @PostMapping("/order")
    public void placeOrder(@RequestBody OrderDto order) {
        log.info("Got new request for Order {}", order);
        streamBridge.send(orderExchange, order);
    }
}
