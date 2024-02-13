package com.example.geektrust.command;

public class InvalidCommandException extends Exception{
    public InvalidCommandException(String inputCommand) {
        super("Invalid command:" + inputCommand);
    }
}
