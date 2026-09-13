package com.nhlstenden.uservalidation.storage;

import com.nhlstenden.uservalidation.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserStorage
{
    private List<User> users;

    public UserStorage()
    {
        this.setUsers(new ArrayList<>());
    }

    public List<User> getUsers()
    {
        return this.users;
    }

    public void setUsers(List<User> users)
    {
        if (users == null)
        {
            throw new IllegalArgumentException("Users cannot be null.");
        }

        this.users = users;
    }

    public void addUser(User user)
    {
        if (user == null)
        {
            throw new IllegalArgumentException("User cannot be null.");
        }

        this.getUsers().add(user);
    }

    public void removeUser(User user)
    {
        if (user == null)
        {
            throw new IllegalArgumentException("User cannot be null.");
        }

        this.getUsers().remove(user);
    }

    public boolean containsUsername(String username)
    {
        if (username == null || username.isBlank())
        {
            throw new IllegalArgumentException("Username cannot be null or blank.");
        }

        for (User currentUser : this.getUsers())
        {
            if (currentUser.getUsername().equals(username))
            {
                return true;
            }
        }

        return false;
    }
}
