package com.fashionblog.demo.controller;

import com.fashionblog.demo.dto.ErrorResponseDto;
import com.fashionblog.demo.exceptions.PermissionDeniedException;
import com.fashionblog.demo.exceptions.ResourceAlreadyExistsException;
import com.fashionblog.demo.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@ControllerAdvice
public class GlobalErrorHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(final ResourceNotFoundException ex) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage(ex.getMessage());

        return ResponseEntity.of(Optional.of(errorResponseDto));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceAlreadyExistsException(final ResourceAlreadyExistsException ex) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage(ex.getMessage());

        return ResponseEntity.of(Optional.of(errorResponseDto));
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(PermissionDeniedException.class)
    public ResponseEntity<ErrorResponseDto> handlePermissionDeniedException(final PermissionDeniedException ex) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage(ex.getMessage());

        return ResponseEntity.of(Optional.of(errorResponseDto));
    }
}
