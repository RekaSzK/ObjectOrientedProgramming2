package com.nhlstenden.smartbbq.food;

public abstract class Food
{
    private static final double MIN_BROWNING_PERCENTAGE = 0; //This is shared by vegetables and meat alike
    protected static final double TEMPERATURE_INCREMENT_FOR_GRILL = 0.5;

    private double currentBrownPercentage;
    private double browningFactor;
    private double currentTemperature;

    public Food(double browningFactor)
    {
        this.setBrowningFactor(browningFactor);
    }

    public double getCurrentBrownPercentage()
    {
        return this.currentBrownPercentage;
    }

    public void setCurrentBrownPercentage(double currentBrownPercentage)
    {
        if (currentBrownPercentage < MIN_BROWNING_PERCENTAGE)
        {
            throw new IllegalArgumentException("Current browning percentage cannot be less than minimum browning percentage.");
        }

        this.currentBrownPercentage = currentBrownPercentage;
    }

    public double getBrowningFactor()
    {
        return this.browningFactor;
    }

    public void setBrowningFactor(double browningFactor)
    {
        this.browningFactor = browningFactor;
    }

    public double getCurrentTemperature()
    {
        return this.currentTemperature;
    }

    public void setCurrentTemperature(double currentTemperature)
    {
        this.currentTemperature = currentTemperature;
    }

    public abstract void grill(double temperature);
}
