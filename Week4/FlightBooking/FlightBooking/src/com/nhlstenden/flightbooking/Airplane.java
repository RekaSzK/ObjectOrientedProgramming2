package com.nhlstenden.flightbooking;

public abstract class Airplane
{
    private String code;
    private double currentFuelLevel;
    private boolean holdsLuggage;

    public Airplane(String code, double currentFuelLevel, boolean holdsLuggage)
    {
        this.setCode(code);
        this.setCurrentFuelLevel(currentFuelLevel);
        this.setHoldsLuggage(holdsLuggage);
    }

    public String getCode()
    {
        return this.code;
    }

    public void setCode(String code)
    {
        if (code == null || code.isBlank())
        {
            throw new IllegalArgumentException("Code cannot be null or blank.");
        }

        this.code = code;
    }

    public double getCurrentFuelLevel()
    {
        return this.currentFuelLevel;
    }

    public void setCurrentFuelLevel(double currentFuelLevel)
    {
        if (currentFuelLevel < 0)
        {
            throw new IllegalArgumentException("Current fuel level cannot be negative.");
        }

        this.currentFuelLevel = currentFuelLevel;
    }

    public boolean isHoldsLuggage()
    {
        return this.holdsLuggage;
    }

    public void setHoldsLuggage(boolean holdsLuggage)
    {
        this.holdsLuggage = holdsLuggage;
    }

    public abstract double getFuelUsage(int distance, double luggageWeight);

    public abstract void reserveSeat() throws NoAvailableSeatException;

    public abstract String getInfo();
}
