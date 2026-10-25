package com.nhlstenden.smartbbq.food.vegetables;

public class Corn extends Vegetable
{
    private static final double BROWNING_FACTOR = 0.08;
    private static final double MOISTURE_FACTOR = 0.05;

    public Corn()
    {
        super(MOISTURE_FACTOR, BROWNING_FACTOR);
    }

    @Override
    public String toString()
    {
        return "Corn";
    }
}
