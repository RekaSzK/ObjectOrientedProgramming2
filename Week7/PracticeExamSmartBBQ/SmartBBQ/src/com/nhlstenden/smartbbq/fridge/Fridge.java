package com.nhlstenden.smartbbq.fridge;

import com.nhlstenden.smartbbq.food.Food;

import java.util.HashSet;

public class Fridge
{
    private static final int DEFAULT_TEMPERATURE = 8;

    private static Fridge fridge;

    private HashSet<Food> foodInFridge;
    private int temperature;

    private Fridge()
    {
        this.setFoodInFridge(new HashSet<>());
        this.setTemperature(DEFAULT_TEMPERATURE);
    }

    public static Fridge getInstance()
    {
        if (getFridge() == null)
        {
            setFridge(new Fridge());
        }

        return getFridge();
    }

    public static Fridge getFridge()
    {
        return fridge;
    }

    public static void setFridge(Fridge fridge)
    {
        Fridge.fridge = fridge;
    }

    public HashSet<Food> getFoodInFridge()
    {
        return this.foodInFridge;
    }

    public void setFoodInFridge(HashSet<Food> foodInFridge)
    {
        this.foodInFridge = foodInFridge;
    }

    public void addFood(Food food)
    {
        this.foodInFridge.add(food);
    }

    public int getTemperature()
    {
        return this.temperature;
    }

    public void setTemperature(int temperature)
    {
        this.temperature = temperature;
    }
}