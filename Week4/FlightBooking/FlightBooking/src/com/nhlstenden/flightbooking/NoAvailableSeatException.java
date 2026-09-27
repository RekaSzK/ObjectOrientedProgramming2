package com.nhlstenden.flightbooking;

public class NoAvailableSeatException extends Exception
{
    public NoAvailableSeatException(String message)
    {
        super(message);
    }
}