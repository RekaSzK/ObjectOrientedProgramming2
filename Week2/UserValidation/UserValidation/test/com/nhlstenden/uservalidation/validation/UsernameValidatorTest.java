package com.nhlstenden.uservalidation.validation;

import com.nhlstenden.uservalidation.storage.UserStorage;
import com.nhlstenden.uservalidation.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UsernameValidatorTest
{
    private UserStorage userStorage;
    private UsernameValidator usernameValidator;

    @BeforeEach
    void setUp()
    {
        this.userStorage = new UserStorage();
        this.usernameValidator = new UsernameValidator(this.userStorage);
    }

    @Test
    void setStorage_nullStorage_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.usernameValidator.setStorage(null);
        });
    }

    @Test
    void setStorage_validStorage_expectStorageSet()
    {
        UserStorage newStorage = new UserStorage();

        this.usernameValidator.setStorage(newStorage);

        assertEquals(newStorage, this.usernameValidator.getStorage());
    }

    @Test
    void validate_usernameNotInStorage_expectTrue()
    {
        User user = new User("qwertz", LocalDate.of(2007, 2, 25), "myEmail@test.com", "myUsername");

        assertTrue(this.usernameValidator.validate(user));
    }

    @Test
    void validate_usernameAlreadyInStorage_expectFalse()
    {
        User existingUser = new User("qwertz", LocalDate.of(2000, 1, 1), "test@test.com", "myUsername");
        this.userStorage.addUser(existingUser);

        User newUser = new User("asdfg", LocalDate.of(2007, 2, 25), "myEmail@test.com", "myUsername");

        assertFalse(this.usernameValidator.validate(newUser));
    }

    @Test
    void validate_differentUsernameInStorage_expectTrue()
    {
        User existingUser = new User("qwertz", LocalDate.of(2000, 1, 1), "test@test.com", "myUsername");
        this.userStorage.addUser(existingUser);

        User newUser = new User("asdfg", LocalDate.of(2007, 2, 25), "myEmail@test.com", "notMyUsername");

        assertTrue(this.usernameValidator.validate(newUser));
    }

}