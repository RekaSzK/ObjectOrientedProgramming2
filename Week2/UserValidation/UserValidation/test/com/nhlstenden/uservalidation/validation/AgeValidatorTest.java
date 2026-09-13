package com.nhlstenden.uservalidation.validation;

import com.nhlstenden.uservalidation.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AgeValidatorTest
{
    private AgeValidator ageValidator;

    @BeforeEach
    void setUp()
    {
        this.ageValidator = new AgeValidator(18);
    }

    @Test
    void setMinAge_negativeMinAge_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            this.ageValidator.setMinAge(-1);
        });
    }

    @Test
    void setMinAge_zeroMinAge_expectZeroMinAgeSet()
    {
        this.ageValidator.setMinAge(0);

        assertEquals(0, this.ageValidator.getMinAge());
    }

    @Test
    void setMinAge_21MinAge_expectMinAgeSet()
    {
        this.ageValidator.setMinAge(21);

        assertEquals(21, this.ageValidator.getMinAge());
    }

    @Test
    void validate_userYoungerThanMinAge_expectFalse()
    {
        User youngUser = new User("qwertz", LocalDate.now().minusYears(17), "myEmail@test.com", "myUsername");

        assertFalse(this.ageValidator.validate(youngUser));
    }

    @Test
    void validate_userExactlyMinAge_expectTrue()
    {
        User exactAgeUser = new User("qwertz", LocalDate.now().minusYears(18), "myEmail@test.com", "myUsername");

        assertTrue(this.ageValidator.validate(exactAgeUser));
    }

    @Test
    void validate_userOlderThanMinAge_expectTrue()
    {
        User oldUser = new User("qwertz", LocalDate.now().minusYears(19), "myEmail@test.com", "myUsername");

        assertTrue(this.ageValidator.validate(oldUser));
    }
}