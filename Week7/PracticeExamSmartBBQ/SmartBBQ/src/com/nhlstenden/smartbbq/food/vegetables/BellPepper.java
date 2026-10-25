package com.nhlstenden.smartbbq.food.vegetables;

public class BellPepper extends Vegetable
{
    private static final double BROWNING_FACTOR = 0.03;
    private static final double MOISTURE_FACTOR = 0.1;

    public BellPepper()
    {
        super(MOISTURE_FACTOR, BROWNING_FACTOR);
    }

    @Override
    public String toString()
    {
        return "Bell Pepper";
    }
}
