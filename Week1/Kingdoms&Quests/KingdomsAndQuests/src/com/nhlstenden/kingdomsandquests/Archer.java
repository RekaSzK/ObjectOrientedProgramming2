package com.nhlstenden.kingdomsandquests;

public class Archer extends Character
{
    private static final double ATTACK_DOUBLED = 2;

    private boolean nextAttackDoubled;

    public Archer(String name, int xp, int level, int attackPower, int defensePower)
    {
        super(name, xp, level, attackPower, defensePower);

        this.setNextAttackDoubled(false);
    }

    public boolean isNextAttackDoubled()
    {
        return this.nextAttackDoubled;
    }

    public void setNextAttackDoubled(boolean nextAttackDoubled)
    {
        this.nextAttackDoubled = nextAttackDoubled;
    }

    @Override
    public void attack()
    {
        double damage = this.getAttackPower();

        if(this.isNextAttackDoubled())
        {
            damage *= ATTACK_DOUBLED;
            this.setNextAttackDoubled(false);
        }

        System.out.println(this.getName() + " dealt " + damage + " damage.");
    }

    @Override
    public void defend()
    {
        System.out.println("Archer is defending!");
    }

    @Override
    public void useSpecialAbility()
    {
        this.setNextAttackDoubled(true);
    }
}
