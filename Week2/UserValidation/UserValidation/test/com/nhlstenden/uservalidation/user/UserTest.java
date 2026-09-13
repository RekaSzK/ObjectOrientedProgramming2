package com.nhlstenden.uservalidation.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest
{
    private User user;

    @BeforeEach
    void setUp()
    {
        this.user = new User("qwertz", LocalDate.of(2007, 2, 25), "myemail@test.com", "myUsername");
    }

    @Test
    void setPassword_nullPassword_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.user.setPassword(null);
        });
    }

    @Test
    void setPassword_blankPassword_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.user.setPassword("");
        });
    }

    @Test
    void setPassword_validPassword_expectPasswordSet()
    {
        this.user.setPassword("newPassword");

        assertEquals("newPassword", this.user.getPassword());
    }

    @Test
    void setDob_nullDob_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.user.setDob(null);
        });
    }

    @Test
    void setDob_futureDob_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.user.setDob(LocalDate.now().plusDays(1));
        });
    }

    @Test
    void setDob_validDob_expectDobSet()
    {
        this.user.setDob(LocalDate.of(2006,5,25));

        assertEquals(LocalDate.of(2006,5,25), this.user.getDob());
    }

    @Test
    void setEmail_nullEmail_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.user.setEmail(null);
        });
    }

    @Test
    void setEmail_blankEmail_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.user.setEmail("");
        });
    }

    @Test
    void setEmail_validEmail_expectEmailSet()
    {
        this.user.setEmail("newEmail@gmail.com");

        assertEquals("newEmail@gmail.com", this.user.getEmail());
    }

    @Test
    void setUsername_nullUsername_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.user.setUsername(null);
        });
    }

    @Test
    void setUsername_blankUsername_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.user.setUsername("");
        });
    }

    @Test
    void setUsername_validUsername_expectUsernameSet()
    {
        this.user.setUsername("newUsername");

        assertEquals("newUsername", this.user.getUsername());
    }

    @Test
    void getAge_dob25YearsAgo_expectAge25()
    {
        this.user.setDob(LocalDate.now().minusYears(25));

        assertEquals(25, this.user.getAge());
    }
}