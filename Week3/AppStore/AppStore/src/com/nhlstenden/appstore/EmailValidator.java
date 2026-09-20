package com.nhlstenden.appstore;

public class EmailValidator
{
    public EmailValidator()
    {
    }

    public static boolean isValid(String email)
    {
        if (email == null)
        {
            return false;
        }

        //In an actual validator, I would use RegEx (such as ^[\w.+-]+@[\w-]+\.[a-zA-Z]{2,}$) but for simplicity I check for the @ symbol and a period.
        return email.contains("@") && email.contains(".");
    }
}
