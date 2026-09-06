package com.nhlstenden.kingdomsandquests;

import java.util.List;

public class SpecialQuest extends Quest
{
    private List<Item> items;

    public SpecialQuest(String title, int xpReward, int difficultyLevel, Character opponent, List<Item> items)
    {
        super(title, xpReward, difficultyLevel, opponent);
        this.setItems(items);
    }

    public List<Item> getItems()
    {
        return this.items;
    }

    public void setItems(List<Item> items)
    {
        if (items == null || items.isEmpty()) //it wouldn't be a special quest if no items being awarded was possible
        {
            throw new IllegalArgumentException("Items cannot be empty.");
        }

        this.items = items;
    }

    @Override //this replaces/rewrites a method from the parent class (in this case: Quest.java)
    public void grantRewards(Player player)
    {
        super.grantRewards(player); //IMPORTANT - this runs the original version first (the one in Quest.java) before changing it

        player.addItems(this.getItems()); //NEW BEHAVIOUR
    }
}
