package com.nhlstenden.uservalidation.validation;

import com.nhlstenden.uservalidation.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest
{
    private User user;

    @BeforeEach
    void setUp()
    {
        this.user = new User("qwertz", LocalDate.of(2007,2,25), "myEmail@test.com", "myUsername");
    }

    @Test
    void validate_spacesNotAllowedPasswordHasNoSpaces_expectTrue()
    {
        PasswordValidator passwordValidator = new PasswordValidator(false, false, false, false, false);
        this.user.setPassword("password");

        assertTrue(passwordValidator.validate(this.user));
    }

    @Test
    void validate_spacesNotAllowedPasswordHasSpace_expectFalse()
    {
        PasswordValidator passwordValidator = new PasswordValidator(false, false, false, false, false);
        this.user.setPassword("pass word");

        assertFalse(passwordValidator.validate(this.user));
    }

    @Test
    void validate_spacesAllowedPasswordHasSpace_expectTrue()
    {
        PasswordValidator passwordValidator = new PasswordValidator(true, false, false, false, false);
        this.user.setPassword("pass word");

        assertTrue(passwordValidator.validate(this.user));
    }

    @Test
    void validate_spacesAllowedPasswordHasNoSpaces_expectTrue()
    {
        PasswordValidator passwordValidator = new PasswordValidator(true, false, false, false, false);
        this.user.setPassword("password");

        assertTrue(passwordValidator.validate(this.user));
    }

    @Test
    void validate_specialCharsNotMandatoryPasswordHasNoSpecialChars_expectTrue()
    {
        PasswordValidator passwordValidator = new PasswordValidator(false, false, false, false, false);
        this.user.setPassword("password");

        assertTrue(passwordValidator.validate(this.user));
    }

    @Test
    void validate_specialCharsNotMandatoryPasswordHasSpecialChar_expectTrue()
    {
        PasswordValidator passwordValidator = new PasswordValidator(false, false, false, false, false);
        this.user.setPassword("password!");

        assertTrue(passwordValidator.validate(this.user));
    }

    @Test
    void validate_specialCharsMandatoryPasswordHasNoSpecialChars_expectFalse()
    {
        PasswordValidator passwordValidator = new PasswordValidator(false, true, false, false, false);
        this.user.setPassword("password");

        assertFalse(passwordValidator.validate(this.user));
    }

    @Test
    void validate_specialCharsMandatoryPasswordHasSpecialChar_expectTrue()
    {
        PasswordValidator passwordValidator = new PasswordValidator(false, true, false, false, false);
        this.user.setPassword("password!");

        assertTrue(passwordValidator.validate(this.user));
    }

    @Test
    void validate_numbersNotMandatoryPasswordHasNoNumbers_expectTrue()
    {
        PasswordValidator passwordValidator = new PasswordValidator(false, false, false, false, false);
        this.user.setPassword("password");

        assertTrue(passwordValidator.validate(this.user));
    }

    @Test
    void validate_numbersNotMandatoryPasswordHasNumber_expectTrue()
    {
        PasswordValidator passwordValidator = new PasswordValidator(false, false, false, false, false);
        this.user.setPassword("password1");

        assertTrue(passwordValidator.validate(this.user));
    }

    @Test
    void validate_numbersMandatoryPasswordHasNoNumbers_expectFalse()
    {
        PasswordValidator passwordValidator = new PasswordValidator(false, false, true, false, false);
        this.user.setPassword("password");

        assertFalse(passwordValidator.validate(this.user));
    }

    @Test
    void validate_numbersMandatoryPasswordHasNumber_expectTrue()
    {
        PasswordValidator passwordValidator = new PasswordValidator(false, false, true, false, false);
        this.user.setPassword("password1");

        assertTrue(passwordValidator.validate(this.user));
    }

    @Test
    void validate_lowercaseNotMandatoryPasswordHasNoLowercase_expectTrue()
    {
        PasswordValidator passwordValidator = new PasswordValidator(false, false, false, false, false);
        this.user.setPassword("PASSWORD");

        assertTrue(passwordValidator.validate(this.user));
    }

    @Test
    void validate_lowercaseNotMandatoryPasswordHasLowercase_expectTrue()
    {
        PasswordValidator passwordValidator = new PasswordValidator(false, false, false, false, false);
        this.user.setPassword("pASSWORD");

        assertTrue(passwordValidator.validate(this.user));
    }

    @Test
    void validate_lowercaseMandatoryPasswordHasNoLowercase_expectFalse()
    {
        PasswordValidator passwordValidator = new PasswordValidator(false, false, false, true, false);
        this.user.setPassword("PASSWORD");

        assertFalse(passwordValidator.validate(this.user));
    }

    @Test
    void validate_lowercaseMandatoryPasswordHasLowercase_expectTrue()
    {
        PasswordValidator passwordValidator = new PasswordValidator(false, false, false, true, false);
        this.user.setPassword("pASSWORD");

        assertTrue(passwordValidator.validate(this.user));
    }

    @Test
    void validate_uppercaseNotMandatoryPasswordHasNoUppercase_expectTrue()
    {
        PasswordValidator passwordValidator = new PasswordValidator(false, false, false, false, false);
        this.user.setPassword("password");

        assertTrue(passwordValidator.validate(this.user));
    }

    @Test
    void validate_uppercaseNotMandatoryPasswordHasUppercase_expectTrue()
    {
        PasswordValidator passwordValidator = new PasswordValidator(false, false, false, false, false);
        this.user.setPassword("Password");

        assertTrue(passwordValidator.validate(this.user));
    }

    @Test
    void validate_uppercaseMandatoryPasswordHasNoUppercase_expectFalse()
    {
        PasswordValidator passwordValidator = new PasswordValidator(false, false, false, false, true);
        this.user.setPassword("password");

        assertFalse(passwordValidator.validate(this.user));
    }

    @Test
    void validate_uppercaseMandatoryPasswordHasUppercase_expectTrue()
    {
        PasswordValidator passwordValidator = new PasswordValidator(false, false, false, false, true);
        this.user.setPassword("Password");

        assertTrue(passwordValidator.validate(this.user));
    }

    @Test
    void validate_allRulesDisabled_expectTrue()
    {
        PasswordValidator validator = new PasswordValidator(false, false, false, false, false);
        this.user.setPassword("password");

        assertTrue(validator.validate(user));
    }

    @Test
    void validate_allRulesEnabledAndPasswordSatisfiesAll_expectTrue()
    {
        PasswordValidator validator = new PasswordValidator(true, true, true, true, true);
        this.user.setPassword("Pass word1!");

        assertTrue(validator.validate(user));
    }

    @Test
    void validate_allRulesEnabledAndPasswordMissingOne_expectFalse()
    {
        PasswordValidator validator = new PasswordValidator(true, true, true, true, true);
        this.user.setPassword("Pass word1");

        assertFalse(validator.validate(user));
    }
}