package com.nhlstenden.kingdomsandquests;

import java.util.ArrayList;
import java.util.List;

public class Player
{
    private Character character;
    private List<Quest> availableQuests;
    private List<Item> inventory;

    public Player(Character character, List<Quest> availableQuests)
    {
        this.setCharacter(character);
        this.setAvailableQuests(availableQuests);
        this.setInventory(new ArrayList<>());
    }

    public Character getCharacter()
    {
        return this.character;
    }

    public void setCharacter(Character character)
    {
        if (character == null)
        {
            throw new IllegalArgumentException("Character cannot be null.");
        }

        this.character = character;
    }

    public List<Quest> getAvailableQuests()
    {
        return this.availableQuests;
    }

    public void setAvailableQuests(List<Quest> availableQuests)
    {
        if (availableQuests == null)
        {
            throw new IllegalArgumentException("Available quests cannot be null.");
        }

        this.availableQuests = availableQuests;
    }

    public List<Item> getInventory()
    {
        return this.inventory;
    }

    public void setInventory(List<Item> inventory)
    {
        if (inventory == null)
        {
            throw new IllegalArgumentException("Inventory cannot be null.");
        }

        this.inventory = inventory;
    }

    public void playQuest(Quest quest)
    {
        if (quest == null)
        {
            throw new IllegalArgumentException("Quest cannot be null.");
        }

        if (!quest.isPlayable(this.getCharacter().getXp()))
        {
            System.out.println(this.getCharacter().getName() + " doesn't have enough XP for this quest.");
            return;
        }

        this.getCharacter().attack();
        this.getCharacter().defend();
        this.getCharacter().useSpecialAbility();

        quest.grantRewards(this);
        System.out.println(getCharacter().getName() + " completed " + quest.getTitle() + ".");
    }

    public void addItems(List<Item> newItems)
    {
        if (newItems == null)
        {
            throw new IllegalArgumentException("New items cannot be null.");
        }

        this.getInventory().addAll(newItems); //addAll adds all items from newItems to inventory (addAll is a built-in method for lists)
    }
}
