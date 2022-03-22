package com.cubeapp.cubeapp.core;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Any message here ...")
public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super();
    }

//    public NotFoundException(String message) {
//        super(message);
//    }
//
//    public NotFoundException(String message, Throwable cause) {
//        super(message, cause);
//    }
}