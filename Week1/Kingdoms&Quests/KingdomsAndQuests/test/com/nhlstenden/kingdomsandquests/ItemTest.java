package com.nhlstenden.kingdomsandquests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest
{
    private Item item;

    @BeforeEach
    void setUp()
    {
        this.item = new Item("ItemTitle");
    }

    @Test
    void setTitle_nullTitle_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.item.setTitle(null);
        });
    }

    @Test
    void setTitle_blankTitle_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.item.setTitle("");
        });
    }

    @Test
    void setTitle_validTitle_expectTitle()
    {
        this.item.setTitle("NewTitle");

        assertEquals("NewTitle", this.item.getTitle());
    }
}
 
