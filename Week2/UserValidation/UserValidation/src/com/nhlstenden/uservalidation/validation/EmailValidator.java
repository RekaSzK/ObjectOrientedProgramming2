package com.nhlstenden.uservalidation.validation;

import com.nhlstenden.uservalidation.user.User;

public class EmailValidator implements Validator
{
    public EmailValidator()
    {
    }

    @Override
    public boolean validate(User user)
    {
        //In an actual validator, I would use RegEx (such as ^[\w.+-]+@[\w-]+\.[a-zA-Z]{2,}$) but for simplicity I check for the @ symbol and a period.
        return user.getEmail().contains("@") && user.getEmail().contains(".");
    }
}
