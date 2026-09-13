package com.nhlstenden.uservalidation.validation;

import com.nhlstenden.uservalidation.storage.UserStorage;
import com.nhlstenden.uservalidation.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest
{
    private Validation validation;
    private User user;

    @BeforeEach
    void setUp()
    {
        this.validation = new Validation(new ArrayList<>());
        this.user = new User("qwertz", LocalDate.of(2007,2,25), "myEmail@test.com", "myUsername");
    }

    @Test
    void setValidators_nullValidators_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.validation.setValidators(null);
        });
    }

    @Test
    void setValidators_emptyValidators_expectZeroValidatorsSet()
    {
        this.validation.setValidators(new ArrayList<>());

        assertEquals(0, this.validation.getValidators().size());
    }

    @Test
    void setValidators_oneValidator_expectOneValidatorSet()
    {
        Validator validator = new EmailValidator();
        List<Validator> validators = new ArrayList<>();

        validators.add(validator);

        this.validation.setValidators(validators);

        assertEquals(1, this.validation.getValidators().size());
    }

    @Test
    void addValidator_nullValidator_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.validation.addValidator(null);
        });
    }

    @Test
    void addValidator_validValidator_expectValidatorAdded()
    {
        Validator validator = new EmailValidator();

        this.validation.addValidator(validator);

        assertEquals(1, this.validation.getValidators().size());
    }

    @Test
    void removeValidator_nullValidator_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.validation.removeValidator(null);
        });
    }

    @Test
    void removeValidator_validValidator_expectValidatorRemoved()
    {
        Validator validator = new EmailValidator();
        List<Validator> validators = new ArrayList<>();

        validators.add(validator);

        this.validation.setValidators(validators);

        this.validation.removeValidator(validator);

        assertEquals(0, this.validation.getValidators().size());
    }

    @Test
    void validateUser_nullUser_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.validation.validateUser(null);
        });
    }

    @Test
    void validateUser_noValidatorsConfigured_expectTrue()
    {
        assertTrue(this.validation.validateUser(this.user));
    }

    @Test
    void validateUser_allValidatorsPass_expectTrue()
    {
        UserStorage userStorage = new UserStorage();

        this.validation.addValidator(new AgeValidator(18));
        this.validation.addValidator(new EmailValidator());
        this.validation.addValidator(new PasswordValidator(false, false, false, false, false));
        this.validation.addValidator(new UsernameValidator(userStorage));

        assertTrue(this.validation.validateUser(this.user));
    }

    @Test
    void validateUser_oneValidatorFails_expectFalse()
    {
        UserStorage userStorage = new UserStorage();

        this.validation.addValidator(new AgeValidator(21));
        this.validation.addValidator(new EmailValidator());
        this.validation.addValidator(new PasswordValidator(false, false, false, false, false));
        this.validation.addValidator(new UsernameValidator(userStorage));

        assertFalse(this.validation.validateUser(this.user));
    }

    @Test
    void validateUser_allValidatorsFail_expectFalse()
    {
        User invalidUser = new User("qwertz", LocalDate.of(2007, 2, 25), "notanemail", "myUsername");
        UserStorage userStorage = new UserStorage();
        userStorage.addUser(invalidUser);

        this.validation.addValidator(new AgeValidator(21));
        this.validation.addValidator(new EmailValidator());
        this.validation.addValidator(new PasswordValidator(true, true, true, true, true));
        this.validation.addValidator(new UsernameValidator(userStorage));

        assertFalse(this.validation.validateUser(invalidUser));
    }
}