package com.nhlstenden.uservalidation.validation;

import com.nhlstenden.uservalidation.user.User;

public class AgeValidator implements Validator
{
    private int minAge;

    public AgeValidator(int minAge)
    {
        this.setMinAge(minAge);
    }

    public int getMinAge()
    {
        return this.minAge;
    }

    public void setMinAge(int minAge)
    {
        if (minAge < 0)
        {
            throw new IllegalArgumentException("Minimum age cannot be negative.");
        }

        this.minAge = minAge;
    }

    @Override
    public boolean validate(User user)
    {
        return user.getAge() >= this.getMinAge();
    }
}
