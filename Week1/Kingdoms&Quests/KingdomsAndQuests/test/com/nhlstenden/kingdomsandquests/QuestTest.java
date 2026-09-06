package com.nhlstenden.kingdomsandquests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class QuestTest
{
    private Character opponent;
    private Quest quest;

    @BeforeEach
    void setUp()
    {
        this.opponent = new Warrior("WarriorName", 0, 1, 10, 5);
        this.quest = new Quest("QuestTitle", 50, 5, this.opponent);
    }

    @Test
    void setTitle_nullTitle_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.quest.setTitle(null);
        });
    }

    @Test
    void setTitle_blankTitle_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.quest.setTitle("");
        });
    }

    @Test
    void setTitle_validTitle_expectTitle()
    {
        this.quest.setTitle("NewTitle");

        assertEquals("NewTitle", this.quest.getTitle());
    }

    @Test
    void setXpReward_negativeXpReward_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.quest.setXpReward(-1);
        });
    }

    @Test
    void setXpReward_validXpReward_expectXpReward()
    {
        this.quest.setXpReward(75);

        assertEquals(75, this.quest.getXpReward());
    }

    @Test
    void setDifficultyLevel_zeroDifficultyLevel_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.quest.setDifficultyLevel(0);
        });
    }

    @Test
    void setDifficultyLevel_negativeDifficultyLevel_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.quest.setDifficultyLevel(-2);
        });
    }

    @Test
    void setDifficultyLevel_validDifficultyLevel_expectDifficultyLevel()
    {
        this.quest.setDifficultyLevel(4);

        assertEquals(4, this.quest.getDifficultyLevel());
    }

    @Test
    void setOpponent_nullOpponent_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.quest.setOpponent(null);
        });
    }

    @Test
    void setOpponent_validOpponent_expectOpponent()
    {
        Character opponent2 = new Mage("MageName", 0, 1, 5, 10);

        this.quest.setOpponent(opponent2);

        assertEquals(opponent2, this.quest.getOpponent());
    }

    @Test
    void getRequiredXp_validDifficultyLevel_expectDifficultyTimesTen()
    {
        this.quest.setDifficultyLevel(4);

        assertEquals(40, this.quest.getRequiredXp());
    }

    @Test
    void isPlayable_exactlyEnoughXp_expectTrue()
    {
        assertTrue(this.quest.isPlayable(50)); //difficultyLevel 5 * 10 = 50 required xp
    }

    @Test
    void isPlayable_notEnoughXp_expectFalse()
    {
        assertFalse(this.quest.isPlayable(49));
    }

    @Test
    void isPlayable_moreThanEnoughXp_expectTrue()
    {
        assertTrue(this.quest.isPlayable(999));
    }

    @Test
    void grantRewards_nullPlayer_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.quest.grantRewards(null);
        });
    }

    @Test
    void grantRewards_validPlayer_expectXpIncreased()
    {
        Character character = new Warrior("HeroName", 0, 1, 10, 5);
        Player player = new Player(character, new ArrayList<>());

        this.quest.grantRewards(player);

        assertEquals(50, character.getXp());
    }
}

