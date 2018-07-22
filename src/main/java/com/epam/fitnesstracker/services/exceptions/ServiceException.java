package com.epam.fitnesstracker.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ServiceException extends Exception {

    public static final String DATA_BASE_ERROR = "Data base error";
    public static final String INTERNAL_SERVER_ERROR = "Internal server error";

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable throwable) {
        super(throwable);
    }

    public ServiceException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
