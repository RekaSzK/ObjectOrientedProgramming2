package com.nhlstenden.uservalidation.validation;

import com.nhlstenden.uservalidation.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest
{
    private EmailValidator emailValidator;

    @BeforeEach
    void setUp()
    {
        this.emailValidator = new EmailValidator();
    }

    @Test
    void validate_emailWithoutAtAndWithoutPeriod_expectFalse()
    {
        User user = new User("qwertz", LocalDate.of(2007, 2, 25), "myEmailtestcom", "myUsername");

        assertFalse(this.emailValidator.validate(user));
    }

    @Test
    void validate_emailWithoutAtAndWithPeriod_expectFalse()
    {
        User user = new User("qwertz", LocalDate.of(2007, 2, 25), "myEmailtest.com", "myUsername");

        assertFalse(this.emailValidator.validate(user));
    }

    @Test
    void validate_emailWithAtAndWithoutPeriod_expectFalse()
    {
        User user = new User("qwertz", LocalDate.of(2007, 2, 25), "myEmail@testcom", "myUsername");

        assertFalse(this.emailValidator.validate(user));
    }

    @Test
    void validate_emailWithAtAndPeriod_expectTrue()
    {
        User user = new User("qwertz", LocalDate.of(2007, 2, 25), "myEmail@test.com", "myUsername");

        assertTrue(this.emailValidator.validate(user));
    }
}