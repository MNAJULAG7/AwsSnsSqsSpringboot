package com.practice.consumer1;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class InventoryConsumer {

    private final ObjectMapper objectMapper;

    public InventoryConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @SqsListener("SnsSpringboot")
    public void receiveMessage(String message) {

        try {
            SnsEnvelope envelope = objectMapper.readValue(
                    message,
                    SnsEnvelope.class
            );

            OrderEvent event = objectMapper.readValue(envelope.Message(),OrderEvent.class);
            System.out.println("event extracted");

            System.out.println("Received Order: " + event.orderId());
            System.out.println("Product: " + event.product());
            System.out.println("Quantity: " + event.quantity());

            updateInventory(event);

        } catch (Exception e) {
            throw new RuntimeException("Failed to process order", e);
        }
    }

    private void updateInventory(OrderEvent event) {

        System.out.println(
                "Updating inventory for " + event.product()
        );

        System.out.println(
                "Reducing stock by " + event.quantity()
        );

        System.out.println("Inventory updated successfully!");
    }
}