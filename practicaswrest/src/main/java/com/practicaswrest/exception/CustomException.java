package com.practicaswrest.exception;



public class CustomException extends Exception{

    public static final long serialVersionUID = 700L;

    public CustomException(String message) {
        super(message);
    }
}
