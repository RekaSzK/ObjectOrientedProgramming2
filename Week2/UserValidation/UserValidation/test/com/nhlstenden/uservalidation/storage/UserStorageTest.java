package com.nhlstenden.uservalidation.storage;

import com.nhlstenden.uservalidation.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserStorageTest
{
    private UserStorage storage;
    private User user;

    @BeforeEach
    void setUp()
    {
        this.storage = new UserStorage();
        this.user = new User("qwertz", LocalDate.of(2007, 2, 25), "myEmail@test.com", "myUsername");
    }

    @Test
    void setUsers_nullUsers_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.storage.setUsers(null);
        });
    }

    @Test
    void setUsers_emptyUsers_expectZeroUsersSet()
    {
        this.storage.setUsers(new ArrayList<>());

        assertEquals(0, this.storage.getUsers().size());
    }

    @Test
    void setUsers_oneUser_expectOneUserSet()
    {
        List<User> users = new ArrayList<>();
        users.add(this.user);

        this.storage.setUsers(users);

        assertEquals(1, this.storage.getUsers().size());
    }

    @Test
    void addUser_nullUser_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.storage.addUser(null);
        });
    }

    @Test
    void addUser_validUser_expectUserAdded()
    {
        this.storage.addUser(this.user);

        assertEquals(1, this.storage.getUsers().size());
    }

    @Test
    void removeUser_nullUser_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.storage.removeUser(null);
        });
    }

    @Test
    void removeUser_validUser_expectUserRemoved()
    {
        List<User> users = new ArrayList<>();
        users.add(this.user);

        this.storage.setUsers(users);

        this.storage.removeUser(this.user);

        assertEquals(0, this.storage.getUsers().size());
    }

    @Test
    void containsUsername_nullUsername_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.storage.containsUsername(null);
        });
    }

    @Test
    void containsUsername_blankUsername_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.storage.containsUsername("");
        });
    }

    @Test
    void containsUsername_existingUsername_expectTrue()
    {
        this.storage.addUser(this.user);

        assertTrue(this.storage.containsUsername("myUsername"));
    }

    @Test
    void containsUsername_nonExistingUsername_expectFalse()
    {
        this.storage.addUser(this.user);

        assertFalse(this.storage.containsUsername("NOTmyUsername"));
    }
}