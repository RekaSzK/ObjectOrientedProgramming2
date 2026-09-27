package com.nhlstenden.flightbooking;

public class Luggage
{
    private double weight;
    private LuggageType type;

    public Luggage(double weight, LuggageType type)
    {
        this.setWeight(weight);
        this.setType(type);
    }

    public double getWeight()
    {
        return this.weight;
    }

    public void setWeight(double weight)
    {
        if (weight <= 0)
        {
            throw new IllegalArgumentException("Weight must be positive.");
        }

        this.weight = weight;
    }

    public LuggageType getType()
    {
        return this.type;
    }

    public void setType(LuggageType type)
    {
        if (type == null)
        {
            throw new IllegalArgumentException("Luggage type cannot be null.");
        }
        this.type = type;
    }
}
