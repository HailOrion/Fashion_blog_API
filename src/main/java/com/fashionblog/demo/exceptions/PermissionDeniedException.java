package com.fashionblog.demo.exceptions;

public class PermissionDeniedException extends RuntimeException {

    public PermissionDeniedException(final String message) {
        super(message);
    }

}
