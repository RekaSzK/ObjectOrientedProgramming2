package com.nhlstenden.flightbooking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Flight
{
    private Airplane airplane;
    private AirportCode depAirport;
    private AirportCode arrAirport;
    private LocalDateTime depDateTime;
    private List<Luggage> luggages;
    private FlightStatus status;

    public Flight(Airplane airplane, AirportCode depAirport, AirportCode arrAirport, LocalDateTime depDateTime)
    {
        this.setAirplane(airplane);
        this.setDepAirport(depAirport);
        this.setArrAirport(arrAirport);
        this.setDepDateTime(depDateTime);
        this.setLuggages(new ArrayList<>());
        this.setStatus(FlightStatus.AWAITING_DEPARTURE);
    }

    public Airplane getAirplane()
    {
        return this.airplane;
    }

    public void setAirplane(Airplane airplane)
    {
        if (airplane == null)
        {
            throw new IllegalArgumentException("Airplane cannot be null.");
        }

        this.airplane = airplane;
    }

    public AirportCode getDepAirport()
    {
        return this.depAirport;
    }

    public void setDepAirport(AirportCode depAirport)
    {
        if (depAirport == null)
        {
            throw new IllegalArgumentException("Departure airport cannot be null.");
        }

        this.depAirport = depAirport;
    }

    public AirportCode getArrAirport()
    {
        return this.arrAirport;
    }

    public void setArrAirport(AirportCode arrAirport)
    {
        if (arrAirport == null)
        {
            throw new IllegalArgumentException("Arrival airport cannot be null.");
        }

        this.arrAirport = arrAirport;
    }

    public LocalDateTime getDepDateTime()
    {
        return this.depDateTime;
    }

    public void setDepDateTime(LocalDateTime depDateTime)
    {
        if (depDateTime == null)
        {
            throw new IllegalArgumentException("Departure date and time cannot be null.");
        }

        this.depDateTime = depDateTime;
    }

    public List<Luggage> getLuggages()
    {
        return this.luggages;
    }

    public void setLuggages(List<Luggage> luggages)
    {
        if (luggages == null)
        {
            throw new IllegalArgumentException("Luggages cannot be null.");
        }

        this.luggages = luggages;
    }

    public void addLuggage(Luggage luggage) throws InvalidLuggageException
    {
        if (luggage == null)
        {
            throw new IllegalArgumentException("Luggage cannot be null.");
        }

        if (luggage.getType() == LuggageType.HOLD && !this.airplane.isHoldsLuggage())
        {
            throw new InvalidLuggageException("This airplane has no space for hold luggage.");
        }

        this.luggages.add(luggage);
    }

    public FlightStatus getStatus()
    {
        return this.status;
    }

    public void setStatus(FlightStatus status)
    {
        if (status == null)
        {
            throw new IllegalArgumentException("Status cannot be null.");
        }

        this.status = status;
    }

    public double getTotalLuggageWeight()
    {
        double totalLuggageWeight = 0;

        for (Luggage currentLuggage : this.getLuggages())
        {
            totalLuggageWeight += currentLuggage.getWeight();
        }
        return totalLuggageWeight;
    }

    public double getFuelUsage()
    {
        int distance = AirportDistance.getDistance(getDepAirport(), getArrAirport());
        double luggageWeight = getTotalLuggageWeight();

        return getAirplane().getFuelUsage(distance, luggageWeight);
    }

    public void depart() throws InsufficientFuelException
    {
        if (this.getStatus() == FlightStatus.DEPARTED || this.getStatus() == FlightStatus.LANDED)
        {
            throw new IllegalStateException("Flight has already departed.");
        }

        double fuelNeeded = this.getFuelUsage();

        if (this.getAirplane().getCurrentFuelLevel() < fuelNeeded)
        {
            throw new InsufficientFuelException("Not enough fuel: needs " + fuelNeeded + " but only has " + this.getAirplane().getCurrentFuelLevel());
        }

        this.getAirplane().setCurrentFuelLevel(this.getAirplane().getCurrentFuelLevel() - fuelNeeded);
        this.setStatus(FlightStatus.DEPARTED);
    }

    public String getInfo()
    {
        //This is to easily display the date and time of departure :p
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return ("F: " + this.getDepAirport() + " -> " + this.getArrAirport() + ". Departure " + this.getDepDateTime().format(formatter) + ".");
    }
}
