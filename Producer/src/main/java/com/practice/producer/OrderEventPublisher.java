package com.practice.producer;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import tools.jackson.databind.ObjectMapper;

@Service
public class OrderEventPublisher {

    private final SnsClient snsClient;
    private final ObjectMapper objectMapper;

    @Value("${aws.sns.topic-arn}")
    private String topicArn;

    public OrderEventPublisher(
            SnsClient snsClient,
            ObjectMapper objectMapper) {

        this.snsClient = snsClient;
        this.objectMapper = objectMapper;
    }

    public void publishOrder(OrderEvent event) {

        try {
            String message = objectMapper.writeValueAsString(event);

            PublishRequest request = PublishRequest.builder()
                    .topicArn(topicArn)
                    .message(message)
                    .build();

            snsClient.publish(request);

            System.out.println("Order event published to SNS!");

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to publish order event", e);
        }
    }
}