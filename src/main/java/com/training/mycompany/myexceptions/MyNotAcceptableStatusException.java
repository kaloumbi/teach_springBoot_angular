package com.training.mycompany.myexceptions;

public class MyNotAcceptableStatusException extends RuntimeException{

    public MyNotAcceptableStatusException(String message) {
        super(message);
    }
}
