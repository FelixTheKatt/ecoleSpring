package com.example.ecole.excpetion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotInsertedException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public NotInsertedException(String message) {
        super(message);
    }

}
