package com.nhlstenden.uservalidation.validation;

import com.nhlstenden.uservalidation.user.User;

public class PasswordValidator implements Validator
{
    private boolean allowSpaces;
    private boolean mandatorySpecialChars;
    private boolean mandatoryNumbers;
    private boolean mandatoryLowercase;
    private boolean mandatoryUppercase;

    public PasswordValidator(boolean allowSpaces, boolean mandatorySpecialChars, boolean mandatoryNumbers, boolean mandatoryLowercase, boolean mandatoryUppercase)
    {
        this.setAllowSpaces(allowSpaces);
        this.setMandatorySpecialChars(mandatorySpecialChars);
        this.setMandatoryNumbers(mandatoryNumbers);
        this.setMandatoryLowercase(mandatoryLowercase);
        this.setMandatoryUppercase(mandatoryUppercase);
    }

    public boolean isAllowSpaces()
    {
        return this.allowSpaces;
    }

    public void setAllowSpaces(boolean allowSpaces)
    {
        this.allowSpaces = allowSpaces;
    }

    public boolean isMandatorySpecialChars()
    {
        return this.mandatorySpecialChars;
    }

    public void setMandatorySpecialChars(boolean mandatorySpecialChars)
    {
        this.mandatorySpecialChars = mandatorySpecialChars;
    }

    public boolean isMandatoryNumbers()
    {
        return this.mandatoryNumbers;
    }

    public void setMandatoryNumbers(boolean mandatoryNumbers)
    {
        this.mandatoryNumbers = mandatoryNumbers;
    }

    public boolean isMandatoryLowercase()
    {
        return this.mandatoryLowercase;
    }

    public void setMandatoryLowercase(boolean mandatoryLowercase)
    {
        this.mandatoryLowercase = mandatoryLowercase;
    }

    public boolean isMandatoryUppercase()
    {
        return this.mandatoryUppercase;
    }

    public void setMandatoryUppercase(boolean mandatoryUppercase)
    {
        this.mandatoryUppercase = mandatoryUppercase;
    }

    private boolean containsSpecialChar(String password)
    {
        for (char currentChar : password.toCharArray())
        {
            if (!Character.isLetterOrDigit(currentChar) && currentChar != ' ') //Checks if currentChar is NOT a letter NOR a digit NOR a space (singular quotes for char datatype)
            {
                return true;
            }
        }

        return false;
    }

    private boolean containsNumber(String password)
    {
        for (char currentChar : password.toCharArray())
        {
            if (Character.isDigit(currentChar))
            {
                return true;
            }
        }
        return false;
    }

    private boolean containsUppercase(String password)
    {
        for (char currentChar : password.toCharArray())
        {
            if (Character.isUpperCase(currentChar))
            {
                return true;
            }
        }
        return false;
    }

    private boolean containsLowercase(String password)
    {
        for (char currentChar : password.toCharArray())
        {
            if (Character.isLowerCase(currentChar))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean validate(User user)
    {
        String password = user.getPassword();

        if ((!isAllowSpaces() && password.contains(" ")) ||
                (isMandatorySpecialChars() && !containsSpecialChar(password)) ||
                (isMandatoryNumbers() && !containsNumber(password)) ||
                (isMandatoryUppercase() && !containsUppercase(password)) ||
                (isMandatoryLowercase() && !containsLowercase(password)))
        {
            return false;
        }

        return true;
    }
}