package com.epam.jmp.cloud.service.impl;

public class SubscriptionNotFoundException extends RuntimeException {

    public SubscriptionNotFoundException() {
        this("Subscription not found");
    }

    public SubscriptionNotFoundException(String message) {
        super(message);
    }

    public SubscriptionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
