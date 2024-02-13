package com.example.geektrust.domain;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String name) {
        super(String.format("User %s not found", name));
    }
}
