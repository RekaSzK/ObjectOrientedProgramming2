package com.nhlstenden.smartbbq.food.meat;

public class Sausage extends Meat
{
    private static final MeatType MEAT_TYPE = MeatType.PIG;
    private static final double COOKING_FACTOR = 80;
    private static final double BROWNING_FACTOR = 0.05;

    public Sausage()
    {
        super(MEAT_TYPE, COOKING_FACTOR, BROWNING_FACTOR);
    }

    @Override
    public String toString()
    {
        return "Sausage";
    }
}