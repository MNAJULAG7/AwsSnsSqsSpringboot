package com.practice.consumer1;


public record OrderEvent(
        Long orderId,
        String customerName,
        String product,
        int quantity
) {
}