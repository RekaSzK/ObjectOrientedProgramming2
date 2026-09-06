package com.nhlstenden.kingdomsandquests;

public class Quest
{
    private static final int XP_MULTIPLIER = 10;

    private String title;
    private int xpReward;
    private int difficultyLevel;
    private Character opponent;

    public Quest(String title, int xpReward, int difficultyLevel, Character opponent)
    {
        this.setTitle(title);
        this.setXpReward(xpReward);
        this.setDifficultyLevel(difficultyLevel);
        this.setOpponent(opponent);
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        if (title == null || title.isBlank())
        {
            throw new IllegalArgumentException("Title cannot be empty.");
        }

        this.title = title;
    }

    public int getXpReward()
    {
        return this.xpReward;
    }

    public void setXpReward(int xpReward)
    {
        if (xpReward < 0)
        {
            throw new IllegalArgumentException("XP reward cannot be negative.");
        }

        this.xpReward = xpReward;
    }

    public int getDifficultyLevel()
    {
        return this.difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel)
    {
        if (difficultyLevel <= 0) //if it were zero, required XP would also be zero, and thus it would make no sense
        {
            throw new IllegalArgumentException("Difficulty level must be positive.");
        }

        this.difficultyLevel = difficultyLevel;
    }

    public Character getOpponent()
    {
        return this.opponent;
    }

    public void setOpponent(Character opponent)
    {
        if (opponent == null)
        {
            throw new IllegalArgumentException("Opponent cannot be null.");
        }

        this.opponent = opponent;
    }

    public int getRequiredXp()
    {
        return this.getDifficultyLevel() * XP_MULTIPLIER;
    }

    public boolean isPlayable(int currentXp)
    {
        return currentXp >= this.getRequiredXp();
    }

    public void grantRewards(Player player)
    {
        if (player == null)
        {
            throw new IllegalArgumentException("Player cannot be null.");
        }

        player.getCharacter().addXp(this.getXpReward());
    }
}
