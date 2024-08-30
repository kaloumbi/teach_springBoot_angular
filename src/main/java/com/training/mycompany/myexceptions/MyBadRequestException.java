package com.training.mycompany.myexceptions;

public class MyBadRequestException extends RuntimeException{

    public MyBadRequestException(String message) {
        super(message);
    }
}
