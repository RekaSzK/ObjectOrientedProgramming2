package com.nhlstenden.kingdomsandquests;

public class Mage extends Character
{
    private static final double DEFENSE_MULTIPLIER = 1.5;

    private boolean defenseBoostActive;

    public Mage(String name, int xp, int level, int attackPower, int defensePower)
    {
        super(name, xp, level, attackPower, defensePower);

        this.setDefenseBoostActive(false);
    }

    public boolean isDefenseBoostActive()
    {
        return this.defenseBoostActive;
    }

    public void setDefenseBoostActive(boolean defenseBoostActive)
    {
        this.defenseBoostActive = defenseBoostActive;
    }

    @Override
    public void attack()
    {
        System.out.println("Mage is attacking!");
    }

    @Override
    public void defend()
    {
        double defense = this.getDefensePower();

        if(this.isDefenseBoostActive())
        {
            defense *= DEFENSE_MULTIPLIER;
            this.setDefenseBoostActive(false);
        }

        System.out.println(this.getName() + " defended " + defense + ".");
    }

    @Override
    public void useSpecialAbility()
    {
        this.setDefenseBoostActive(true);
    }
}
