package com.springboot.hotel.services.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException() {
        super("Resource Not Found On Server..!");
    }
}
