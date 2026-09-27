package com.nhlstenden.flightbooking;

import java.util.List;

public class Person
{
    private String name;

    public Person(String name)
    {
        this.setName(name);
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

    public void reserveTicket(FlightManager flightManager, AirportCode depAirport, AirportCode arrAirport, Luggage carryOnBaggage, List<Luggage> checkedLuggage) throws NoFlightAvailableException, NoAvailableSeatException, InvalidLuggageException
    {
        List<Flight> availableFlights = flightManager.findAvailableFlights(depAirport, arrAirport);

        if (availableFlights.isEmpty())
        {
            throw new NoFlightAvailableException("No available flight from " + depAirport + " to " + arrAirport + ".");
        }

        Flight flight = availableFlights.getFirst();

        if (carryOnBaggage != null && carryOnBaggage.getType() != LuggageType.CARRY_ON)
        {
            throw new InvalidLuggageException("Carry-on baggage must be of type CARRY_ON.");
        }

        if (checkedLuggage != null)
        {
            for (Luggage currentLuggage : checkedLuggage)
            {
                if (currentLuggage.getType() != LuggageType.HOLD)
                {
                    throw new InvalidLuggageException("Checked luggage must be of type HOLD.");
                }

                if (!flight.getAirplane().isHoldsLuggage())
                {
                    throw new InvalidLuggageException("This airplane has no space for hold luggage.");
                }
            }
        }

        flight.getAirplane().reserveSeat();

        if (carryOnBaggage != null)
        {
            flight.addLuggage(carryOnBaggage);
        }

        if (checkedLuggage != null)
        {
            for (Luggage currentLuggage : checkedLuggage)
            {
                flight.addLuggage(currentLuggage);
            }
        }
    }
}