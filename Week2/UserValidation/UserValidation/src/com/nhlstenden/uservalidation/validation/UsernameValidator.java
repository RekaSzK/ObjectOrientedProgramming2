package com.nhlstenden.uservalidation.validation;

import com.nhlstenden.uservalidation.storage.UserStorage;
import com.nhlstenden.uservalidation.user.User;

public class UsernameValidator implements Validator
{
    private UserStorage storage;

    public UsernameValidator(UserStorage storage)
    {
        this.setStorage(storage);
    }

    public UserStorage getStorage()
    {
        return this.storage;
    }

    public void setStorage(UserStorage storage)
    {
        if (storage == null)
        {
            throw new IllegalArgumentException("Storage cannot be null.");
        }

        this.storage = storage;
    }

    @Override
    public boolean validate(User user)
    {
        return !this.getStorage().containsUsername(user.getUsername());
    }
}
