package com.nhlstenden.flightbooking;

public class NoFlightAvailableException extends Exception
{
    public NoFlightAvailableException(String message)
    {
        super(message);
    }
}