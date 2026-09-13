package com.nhlstenden.uservalidation.validation;

import com.nhlstenden.uservalidation.user.User;

public interface Validator
{
    //Typing out 'public' is not needed since every method inside an interface is public!!

    public boolean validate(User user);
}
