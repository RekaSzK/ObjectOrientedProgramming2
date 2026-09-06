package com.nhlstenden.kingdomsandquests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpecialQuestTest
{
    private Character opponent;
    private List<Item> items;
    private SpecialQuest specialQuest;

    @BeforeEach
    void setUp()
    {
        this.opponent = new Warrior("WarriorName", 0, 1, 10, 5);
        this.items = new ArrayList<>();
        this.items.add(new Item("ItemTitle"));
        this.specialQuest = new SpecialQuest("SpecialQuestTitle", 50, 5, this.opponent, this.items);
    }

    @Test
    void setItems_nullItems_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.specialQuest.setItems(null);
        });
    }

    @Test
    void setItems_emptyItems_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.specialQuest.setItems(new ArrayList<>());
        });
    }

    @Test
    void setItems_validItems_expectItems()
    {
        List<Item> newItems = new ArrayList<>();
        newItems.add(new Item("NewItemTitle"));

        this.specialQuest.setItems(newItems);

        assertEquals(1, this.specialQuest.getItems().size());
    }

    @Test
    void grantRewards_nullPlayer_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.specialQuest.grantRewards(null);
        });
    }

    @Test
    void grantRewards_validPlayer_expectXpIncreasedAndItemsAdded()
    {
        Character character = new Warrior("HeroName", 0, 1, 10, 5);
        Player player = new Player(character, new ArrayList<>());

        this.specialQuest.grantRewards(player);

        assertEquals(50, character.getXp());
        assertEquals(1, player.getInventory().size());
        assertEquals("ItemTitle", player.getInventory().getFirst().getTitle());
    }
}
 
