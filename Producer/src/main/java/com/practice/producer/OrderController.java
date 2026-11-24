package com.practice.producer;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderEventPublisher publisher;

    public OrderController(OrderEventPublisher publisher) {
        this.publisher = publisher;
    }

    @PostMapping("/post")
    public String createOrder(@RequestBody OrderEvent event) {

        // Publish order event to SNS
        publisher.publishOrder(event);

        return "Order created and event published!";
    }
}

