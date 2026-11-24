package com.practice.consumer1;

public record SnsEnvelope(
        String Type,
        String MessageId,
        String TopicArn,
        String Message
) {
}