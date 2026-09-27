package com.nhlstenden.flightbooking;

public class InvalidLuggageException extends Exception
{
    public InvalidLuggageException(String message)
    {
        super(message);
    }
}