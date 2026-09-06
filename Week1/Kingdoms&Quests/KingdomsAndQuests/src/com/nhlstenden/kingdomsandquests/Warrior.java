package com.nhlstenden.kingdomsandquests;

public class Warrior extends Character
{
    private static final double ATTACK_MULTIPLIER = 1.5;

    private boolean attackBoostActive;

    public Warrior(String name, int xp, int level, int attackPower, int defensePower)
    {
        super(name, xp, level, attackPower, defensePower);

        this.setAttackBoostActive(false);
    }

    public boolean isAttackBoostActive()
    {
        return this.attackBoostActive;
    }

    public void setAttackBoostActive(boolean attackBoostActive)
    {
        this.attackBoostActive = attackBoostActive;
    }

    @Override
    public void attack()
    {
        double damage = this.getAttackPower();

        if(this.isAttackBoostActive())
        {
            damage *= ATTACK_MULTIPLIER;
            this.setAttackBoostActive(false);
        }

        System.out.println(this.getName() + " dealt " + damage + " damage.");
    }

    @Override
    public void defend()
    {
        System.out.println("Warrior is defending!");
    }

    @Override
    public void useSpecialAbility()
    {
        this.setAttackBoostActive(true);
    }
}
