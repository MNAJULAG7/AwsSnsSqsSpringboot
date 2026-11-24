package com.practice.producer;


public record OrderEvent(
        Long orderId,
        String customerName,
        String product,
        int quantity
) {
}