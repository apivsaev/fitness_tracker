package com.epam.fitnesstracker.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Handler of REST controller exceptions.
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @Value("${default.controller.error.message}")
    private String defaultErrorMessage;

    @ExceptionHandler(Throwable.class)
    public ResponseEntity handleException(Throwable e) {
        String message = e.getMessage() != null ? e.getMessage() : defaultErrorMessage;

        HttpStatus status;
        ResponseStatus responseStatusAnnotation = AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class);
        if (responseStatusAnnotation != null) {
            status = responseStatusAnnotation.value();
        } else {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return ResponseEntity.status(status).body(message);
    }
}
