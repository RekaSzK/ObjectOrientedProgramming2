package com.nhlstenden.flightbooking;

import java.util.ArrayList;
import java.util.List;

public class Flight24Uploader
{
    private List<String> flightData;
    private List<String> airplaneData;

    public Flight24Uploader()
    {
        this.setFlightData(new ArrayList<>());
        this.setAirplaneData(new ArrayList<>());
    }

    public List<String> getFlightData()
    {
        return this.flightData;
    }

    public void setFlightData(List<String> flightData)
    {
        this.flightData = flightData;
    }

    public List<String> getAirplaneData()
    {
        return this.airplaneData;
    }

    public void setAirplaneData(List<String> airplaneData)
    {
        this.airplaneData = airplaneData;
    }

    public void uploadFlight(Flight flight)
    {
        if (flight == null)
        {
            throw new IllegalArgumentException("Flight cannot be null.");
        }

        this.getFlightData().add(flight.getInfo());
    }

    public void uploadAirplane(Airplane airplane)
    {
        if (airplane == null)
        {
            throw new IllegalArgumentException("Airplane cannot be null.");
        }

        this.getAirplaneData().add(airplane.getInfo());
    }

    public void upload()
    {
        for (String info : this.getFlightData())
        {
            System.out.println(info);
        }

        for (String info : this.getAirplaneData())
        {
            System.out.println(info);
        }
    }
}