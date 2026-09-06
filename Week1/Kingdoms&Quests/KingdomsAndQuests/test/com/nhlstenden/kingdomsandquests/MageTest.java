package com.nhlstenden.kingdomsandquests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MageTest
{
    private Mage mage;

    @BeforeEach
    void setUp()
    {
        this.mage = new Mage("MageName", 0, 1, 5, 10);
    }

    @Test
    void newMage_expectDefenseBoostActiveFalse()
    {
        assertFalse(this.mage.isDefenseBoostActive());
    }

    @Test
    void defend_afterUseSpecialAbility_expectDefenseBoostActiveFalse()
    {
        this.mage.useSpecialAbility();

        this.mage.defend();

        assertFalse(this.mage.isDefenseBoostActive());
    }

    @Test
    void defend_afterUseSpecialAbility_expectDefensePowerUnchanged() //to ensure the boost is temporary
    {
        this.mage.useSpecialAbility();

        this.mage.defend();

        assertEquals(10, this.mage.getDefensePower());
    }

    @Test
    void defend_withoutSpecialAbility_expectDefenseBoostActiveStaysFalse()
    {
        this.mage.defend();

        assertFalse(this.mage.isDefenseBoostActive());
    }

    @Test
    void useSpecialAbility_expectDefenseBoostActiveTrue()
    {
        this.mage.useSpecialAbility();

        assertTrue(this.mage.isDefenseBoostActive());
    }
}
 
