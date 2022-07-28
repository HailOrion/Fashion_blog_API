package com.fashionblog.demo.exceptions;

public class ResourceAlreadyExistsException extends RuntimeException{

    public ResourceAlreadyExistsException(final String message) {
        super(message);
    }

}
