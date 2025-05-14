package com.quixindo.api_ai.infra.exceptions;

public class InvalidUserException extends RuntimeException{
    public InvalidUserException(String message){
        super(message);
    }
}
