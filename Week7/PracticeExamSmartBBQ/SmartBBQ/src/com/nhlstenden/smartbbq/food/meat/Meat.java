package com.nhlstenden.smartbbq.food.meat;

import com.nhlstenden.smartbbq.food.Food;

public abstract class Meat extends Food
{
    private static final double MIN_COOKED_PERCENTAGE = 0;
    private static final double TEMPERATURE_DIVIDER = 100;

    private double currentCookedPercentage;
    private double cookingFactor;
    private MeatType meatType;

    public Meat(MeatType type, double cookingFactor, double browningFactor)
    {
        super(browningFactor);
        this.setMeatType(type);
        this.setCookingFactor(cookingFactor);
        this.setCurrentCookedPercentage(MIN_COOKED_PERCENTAGE);
    }

    public double getCurrentCookedPercentage()
    {
        return this.currentCookedPercentage;
    }

    public void setCurrentCookedPercentage(double currentCookedPercentage)
    {
        if (currentCookedPercentage < MIN_COOKED_PERCENTAGE)
        {
            throw new IllegalArgumentException("Current cooked percentage cannot be less than minimum cooked percentage.");
        }

        this.currentCookedPercentage = currentCookedPercentage;
    }

    public double getCookingFactor()
    {
        return this.cookingFactor;
    }

    public void setCookingFactor(double cookingFactor)
    {
        this.cookingFactor = cookingFactor;
    }

    public MeatType getMeatType()
    {
        return this.meatType;
    }

    public void setMeatType(MeatType meatType)
    {
        if (meatType == null)
        {
            throw new IllegalArgumentException("Meat type cannot be null.");
        }

        this.meatType = meatType;
    }

    @Override
    public void grill(double temperature)
    {
        this.setCurrentCookedPercentage(this.getCurrentCookedPercentage() + ((1 / (this.getCookingFactor() * Math.PI)) * temperature));
        this.setCurrentBrownPercentage(this.getCurrentBrownPercentage() + (this.getBrowningFactor() * (temperature / TEMPERATURE_DIVIDER)));
        this.setCurrentTemperature(this.getCurrentTemperature() + TEMPERATURE_INCREMENT_FOR_GRILL);
    }
}
