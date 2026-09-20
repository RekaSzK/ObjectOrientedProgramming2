package com.nhlstenden.appstore.data;

public class App
{
    private static final int MIN_AGE_FOR_VIOLENCE = 16;
    private static final int MIN_AGE_FOR_NUDITY = 18;

    private String name;
    private double price;
    private boolean containsViolence;
    private boolean containsNudity;

    public App(String name, double price, boolean containsViolence, boolean containsNudity)
    {
        this.setName(name);
        this.setPrice(price);
        this.setContainsViolence(containsViolence);
        this.setContainsNudity(containsNudity);
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }

        this.name = name;
    }

    public double getPrice()
    {
        return this.price;
    }

    public void setPrice(double price)
    {
        if (price < 0)
        {
            throw new IllegalArgumentException("Price cannot be negative.");
        }

        this.price = price;
    }

    public boolean getContainsViolence()
    {
        return this.containsViolence;
    }

    public void setContainsViolence(boolean containsViolence)
    {
        this.containsViolence = containsViolence;
    }

    public boolean getContainsNudity()
    {
        return this.containsNudity;
    }

    public void setContainsNudity(boolean containsNudity)
    {
        this.containsNudity = containsNudity;
    }

    public boolean canBeUsedBy(int age)
    {
        if ((this.getContainsNudity() && age < MIN_AGE_FOR_NUDITY) || (this.getContainsViolence() && age < MIN_AGE_FOR_VIOLENCE))
        {
            return false;
        }

        return true;
    }
}