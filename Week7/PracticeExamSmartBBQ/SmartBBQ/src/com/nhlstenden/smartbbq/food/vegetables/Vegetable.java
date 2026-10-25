package com.nhlstenden.smartbbq.food.vegetables;

import com.nhlstenden.smartbbq.food.Food;

public abstract class Vegetable extends Food
{
    private static final double MOISTURE_LOWER_BOUND = 0;
    private static final double MOISTURE_UPPER_BOUND = 100;

    private double moistPercentage;
    private double moistFactor;

    public Vegetable(double moistFactor, double browningFactor)
    {
        super(browningFactor);
        this.setMoistFactor(moistFactor);
        this.setMoistPercentage(MOISTURE_UPPER_BOUND);
    }

    public double getMoistPercentage()
    {
        return this.moistPercentage;
    }

    public void setMoistPercentage(double moistPercentage)
    {
        if (moistPercentage < MOISTURE_LOWER_BOUND || moistPercentage > MOISTURE_UPPER_BOUND)
        {
            throw new IllegalArgumentException("Moisture percentage cannot be outside the bounds.");
        }

        this.moistPercentage = moistPercentage;
    }

    public double getMoistFactor()
    {
        return this.moistFactor;
    }

    public void setMoistFactor(double moistFactor)
    {
        this.moistFactor = moistFactor;
    }

    public void decreaseMoisturePercentage(double difference)
    {
        this.setMoistPercentage(Math.max(MOISTURE_LOWER_BOUND, this.getMoistPercentage() - difference));
    }

    @Override
    public void grill(double temperature)
    {
        this.setCurrentBrownPercentage(this.getCurrentBrownPercentage() + this.getBrowningFactor() * temperature);
        this.decreaseMoisturePercentage(this.getMoistFactor() * temperature);
        this.setCurrentTemperature(this.getCurrentTemperature() + TEMPERATURE_INCREMENT_FOR_GRILL);
    }
}
