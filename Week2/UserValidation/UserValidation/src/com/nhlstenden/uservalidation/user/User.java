package com.nhlstenden.uservalidation.user;

import java.time.LocalDate;
import java.time.Period;

public class User
{
    private String password;
    private LocalDate dob;
    private String email;
    private String username;

    public User(String password, LocalDate dob, String email, String username)
    {
        this.setPassword(password);
        this.setDob(dob);
        this.setEmail(email);
        this.setUsername(username);
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        if (password == null || password.isBlank())
        {
            throw new IllegalArgumentException("Password cannot be null or blank.");
        }

        this.password = password;
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

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        if (email == null || email.isBlank())
        {
            throw new IllegalArgumentException("Email cannot be null or blank.");
        }

        this.email = email;
    }

    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username)
    {
        if (username == null || username.isBlank())
        {
            throw new IllegalArgumentException("Username cannot be null or blank.");
        }

        this.username = username;
    }

    public int getAge()
    {
        return Period.between(getDob(), LocalDate.now()).getYears();
    }
}