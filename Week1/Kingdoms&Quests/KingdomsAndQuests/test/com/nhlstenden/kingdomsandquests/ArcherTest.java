package com.nhlstenden.kingdomsandquests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArcherTest
{
    private Archer archer;

    @BeforeEach
    void setUp()
    {
        this.archer = new Archer("ArcherName", 0, 1, 8, 4);
    }

    @Test
    void newArcher_expectNextAttackDoubledFalse()
    {
        assertFalse(this.archer.isNextAttackDoubled());
    }

    @Test
    void attack_afterUseSpecialAbility_expectNextAttackDoubledFalse()
    {
        this.archer.useSpecialAbility();

        this.archer.attack();

        assertFalse(this.archer.isNextAttackDoubled());
    }

    @Test
    void attack_afterUseSpecialAbility_expectAttackPowerUnchanged() //to ensure the boost is temporary
    {
        this.archer.useSpecialAbility();

        this.archer.attack();

        assertEquals(8, this.archer.getAttackPower());
    }

    @Test
    void attack_withoutSpecialAbility_expectNextAttackDoubledStaysFalse()
    {
        this.archer.attack();

        assertFalse(this.archer.isNextAttackDoubled());
    }

    @Test
    void useSpecialAbility_expectNextAttackDoubledTrue()
    {
        this.archer.useSpecialAbility();

        assertTrue(this.archer.isNextAttackDoubled());
    }
}
 
