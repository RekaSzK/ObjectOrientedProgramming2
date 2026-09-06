package com.nhlstenden.kingdomsandquests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest
{
    private Character character;
    private List<Quest> availableQuests;
    private Player player;

    @BeforeEach
    void setUp()
    {
        this.character = new Warrior("WarriorName", 0, 1, 10, 5);
        this.availableQuests = new ArrayList<>();
        this.player = new Player(this.character, this.availableQuests);
    }

    @Test
    void setCharacter_nullCharacter_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.player.setCharacter(null);
        });
    }

    @Test
    void setCharacter_validCharacter_expectCharacter()
    {
        Character character2 = new Mage("MageName", 0, 1, 5, 10);

        this.player.setCharacter(character2);

        assertEquals(character2, this.player.getCharacter());
    }

    @Test
    void setAvailableQuests_nullAvailableQuests_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.player.setAvailableQuests(null);
        });
    }

    @Test
    void setAvailableQuests_noQuests_expectQuestsSize0()
    {
        this.player.setAvailableQuests(new ArrayList<>());

        assertEquals(0, this.player.getAvailableQuests().size());
    }

    @Test
    void setAvailableQuests_twoQuests_expectQuestsSize2()
    {
        Quest quest1 = new Quest("Quest1", 50, 3, this.character);
        Quest quest2 = new Quest("Quest2", 30, 2, this.character);
        List<Quest> quests = new ArrayList<>();

        quests.add(quest1);
        quests.add(quest2);
        this.player.setAvailableQuests(quests);

        assertEquals(2, this.player.getAvailableQuests().size());
    }

    @Test
    void setInventory_nullInventory_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.player.setInventory(null);
        });
    }

    @Test
    void setInventory_noItems_expectInventorySize0()
    {
        this.player.setInventory(new ArrayList<>());

        assertEquals(0, this.player.getInventory().size());
    }

    @Test
    void setInventory_twoItems_expectInventorySize2()
    {
        Item item1 = new Item("Item1");
        Item item2 = new Item("Item2");
        List<Item> items = new ArrayList<>();

        items.add(item1);
        items.add(item2);
        this.player.setInventory(items);

        assertEquals(2, this.player.getInventory().size());
    }

    @Test
    void playQuest_nullQuest_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.player.playQuest(null);
        });
    }

    @Test
    void playQuest_notEnoughXp_expectXpUnchanged()
    {
        Quest hardQuest = new Quest("HardQuest", 50, 10, this.character);

        this.player.playQuest(hardQuest);

        assertEquals(0, this.character.getXp());
    }

    @Test
    void playQuest_enoughXp_expectXpIncreased()
    {
        this.character.addXp(50);
        Quest easyQuest = new Quest("EasyQuest", 25, 2, this.character);

        this.player.playQuest(easyQuest);

        assertEquals(75, this.character.getXp());
    }

    @Test
    void playQuest_specialQuest_expectItemsAddedToInventory()
    {
        Item item4 = new Item("RewardItem");
        this.character.addXp(50);
        List<Item> rewardItems = new ArrayList<>();

        rewardItems.add(item4);

        SpecialQuest specialQuest = new SpecialQuest("SpecialQuest", 25, 2, this.character, rewardItems);

        this.player.playQuest(specialQuest);

        assertEquals(1, this.player.getInventory().size());
    }

    @Test
    void addItems_nullItems_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.player.addItems(null);
        });
    }

    @Test
    void addItems_validItems_expectInventorySize1()
    {
        Item item3 = new Item("Item3");
        List<Item> newItems = new ArrayList<>();

        newItems.add(item3);

        this.player.addItems(newItems);

        assertEquals(1, this.player.getInventory().size());
    }
}
 
