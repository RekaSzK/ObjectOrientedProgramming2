package com.nhlstenden.flightbooking;

import java.util.ArrayList;
import java.util.List;

public class FlightManager
{
    private List<Flight> flights;

    public FlightManager()
    {
        this.setFlights(new ArrayList<>());
    }

    public List<Flight> getFlights()
    {
        return this.flights;
    }

    public void setFlights(List<Flight> flights)
    {
        this.flights = flights;
    }

    public void addFlight(Flight flight)
    {
        if (flight == null)
        {
            throw new IllegalArgumentException("Flight cannot be null.");
        }

        this.getFlights().add(flight);
    }

    public List<Flight> findAvailableFlights(AirportCode depAirport, AirportCode arrAirport)
    {
        List<Flight> result = new ArrayList<>();

        for (Flight currentFlight : this.getFlights())
        {
            if (currentFlight.getDepAirport() == depAirport && currentFlight.getArrAirport() == arrAirport)
            {
                if (currentFlight.getStatus() != FlightStatus.DEPARTED && currentFlight.getStatus() != FlightStatus.LANDED)
                {
                    result.add(currentFlight);
                }
            }
        }

        return result;
    }
}