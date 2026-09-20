package com.nhlstenden.appstore.data;

import com.nhlstenden.appstore.EmailValidator;

import java.time.LocalDate;
import java.time.Period;

public class User
{
    private String name;
    private String email;
    private LocalDate dob;

    public User(String name, String email, LocalDate dob)
    {
        this.setName(name);
        this.setEmail(email);
        this.setDob(dob);
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }

        this.name = name;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        if (!EmailValidator.isValid(email)) //no need to instantiate EmailValidator because isValid() is static
        {
            this.email = null;

            return;
        }

        this.email = email;
    }

    public LocalDate getDob()
    {
        return this.dob;
    }

    public void setDob(LocalDate dob)
    {
        if (dob == null || dob.isAfter(LocalDate.now()))
        {
            throw new IllegalArgumentException("Date of birth cannot be null or in the future.");
        }

        this.dob = dob;
    }

    public int getAge()
    {
        return Period.between(this.getDob(), LocalDate.now()).getYears();
    }
}