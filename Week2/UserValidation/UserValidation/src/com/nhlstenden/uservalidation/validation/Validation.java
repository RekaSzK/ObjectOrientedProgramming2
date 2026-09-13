package com.nhlstenden.uservalidation.validation;

import com.nhlstenden.uservalidation.user.User;

import java.util.List;

public class Validation
{
    private List<Validator> validators;

    public Validation(List<Validator> validators)
    {
        this.setValidators(validators);
    }

    public List<Validator> getValidators()
    {
        return this.validators;
    }

    public void setValidators(List<Validator> validators)
    {
        if (validators == null)
        {
            throw new IllegalArgumentException("Validators cannot be null.");
        }

        this.validators = validators;
    }

    public void addValidator(Validator validator)
    {
        if (validator == null)
        {
            throw new IllegalArgumentException("Validator cannot be null.");
        }

        this.getValidators().add(validator);
    }

    public void removeValidator(Validator validator)
    {
        if (validator == null)
        {
            throw new IllegalArgumentException("Validator cannot be null.");
        }

        this.getValidators().remove(validator);
    }

    public boolean validateUser(User user)
    {
        if (user == null)
        {
            throw new IllegalArgumentException("User cannot be null.");
        }

        for (Validator currentValidator : this.getValidators())
        {
            if (!currentValidator.validate(user))
            {
                return false;
            }
        }

        return true;
    }
}
