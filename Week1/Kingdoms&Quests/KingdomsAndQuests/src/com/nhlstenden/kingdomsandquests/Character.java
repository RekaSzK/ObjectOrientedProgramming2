package com.nhlstenden.kingdomsandquests;

public abstract class Character
{
    private static final int LEVEL_INCREMENT_XP = 200;

    private String name;
    private int xp;
    private int level;
    private double attackPower;
    private double defensePower;

    public Character(String name, int xp, int level, double attackPower, double defensePower)
    {
        this.setName(name);
        this.setXp(xp);
        this.setLevel(level);
        this.setAttackPower(attackPower);
        this.setDefensePower(defensePower);
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        this.name = name;
    }

    public int getXp()
    {
        return this.xp;
    }

    public void setXp(int xp)
    {
        if (xp < 0)
        {
            throw new IllegalArgumentException("XP cannot be negative.");
        }

        this.xp = xp;
    }

    public int getLevel()
    {
        return this.level;
    }

    public void setLevel(int level)
    {
        if (level < 0)
        {
            throw new IllegalArgumentException("Level cannot be negative.");
        }

        this.level = level;
    }

    public double getAttackPower()
    {
        return this.attackPower;
    }

    public void setAttackPower(double attackPower)
    {
        if (attackPower < 0)
        {
            throw new IllegalArgumentException("Attack power cannot be negative.");
        }

        this.attackPower = attackPower;
    }

    public double getDefensePower()
    {
        return this.defensePower;
    }

    public void setDefensePower(double defensePower)
    {
        if (defensePower < 0)
        {
            throw new IllegalArgumentException("Defense power cannot be negative.");
        }

        this.defensePower = defensePower;
    }

    public void addXp(int xpToBeAdded)
    {
        if (xpToBeAdded < 0)
        {
            throw new IllegalArgumentException("XP to be added cannot be negative.");
        }

        this.setXp(this.getXp() + xpToBeAdded);
        levelUp();
    }

    public void levelUp()
    {
        while (this.getXp() >= LEVEL_INCREMENT_XP) //while, so if we have 700 points, we keep checking until we have less than LEVEL_INCREMENT_XP
        {
            this.setLevel(this.getLevel() + 1);
            this.setXp(this.getXp() - LEVEL_INCREMENT_XP);
        }
    }

    public abstract void attack();
    public abstract void defend();
    public abstract void useSpecialAbility();
}
