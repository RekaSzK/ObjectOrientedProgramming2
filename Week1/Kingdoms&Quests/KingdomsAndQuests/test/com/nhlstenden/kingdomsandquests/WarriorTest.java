package com.nhlstenden.kingdomsandquests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest
{
    private Warrior warrior;

    @BeforeEach
    void setUp()
    {
        this.warrior = new Warrior("WarriorName", 0, 1, 10, 5);
    }

    @Test
    void newWarrior_expectAttackBoostActiveFalse()
    {
        assertFalse(this.warrior.isAttackBoostActive());
    }

    @Test
    void attack_afterUseSpecialAbility_expectAttackBoostActiveFalse()
    {
        this.warrior.useSpecialAbility();

        this.warrior.attack();

        assertFalse(this.warrior.isAttackBoostActive());
    }

    @Test
    void attack_afterUseSpecialAbility_expectAttackPowerUnchanged() //to ensure the boost is temporary
    {
        this.warrior.useSpecialAbility();

        this.warrior.attack();

        assertEquals(10, this.warrior.getAttackPower());
    }

    @Test
    void attack_withoutSpecialAbility_expectAttackBoostActiveStaysFalse()
    {
        this.warrior.attack();

        assertFalse(this.warrior.isAttackBoostActive());
    }

    @Test
    void useSpecialAbility_expectAttackBoostActiveTrue()
    {
        this.warrior.useSpecialAbility();

        assertTrue(this.warrior.isAttackBoostActive());
    }
}