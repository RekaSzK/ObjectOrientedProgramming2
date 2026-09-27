package com.nhlstenden.flightbooking;

public class AirportDistance
{
    private static final int JFK_AMS_DIST = 5848;
    private static final int JFK_MEX_DIST = 3366;
    private static final int JFK_LAX_DIST = 3975;
    private static final int AMS_MEX_DIST = 9206;
    private static final int AMS_LAX_DIST = 8956;
    private static final int MEX_LAX_DIST = 2500;

    private AirportDistance()
    {
    }

    //I know this should be with hashmaps, but I'm too tired :(
    public static int getDistance(AirportCode airport1, AirportCode airport2)
    {
        if (airport1 == null || airport2 == null)
        {
            throw new IllegalArgumentException("Airports cannot be null.");
        }
        if (airport1 == airport2)
        {
            throw new IllegalArgumentException("Departure and arrival airport cannot be the same.");
        }

        if(airport1.equals(AirportCode.JFK))
        {
            if(airport2.equals(AirportCode.AMS))
            {
                return JFK_AMS_DIST;
            }

            else if(airport2.equals(AirportCode.MEX))
            {
                return JFK_MEX_DIST;
            }

            else if(airport2.equals(AirportCode.LAX))
            {
                return JFK_LAX_DIST;
            }
        }

        else if(airport1.equals(AirportCode.AMS))
        {
            if(airport2.equals(AirportCode.JFK))
            {
                return JFK_AMS_DIST;
            }

            else if(airport2.equals(AirportCode.MEX))
            {
                return AMS_MEX_DIST;
            }

            else if(airport2.equals(AirportCode.LAX))
            {
                return AMS_LAX_DIST;
            }
        }

        else if(airport1.equals(AirportCode.MEX))
        {
            if(airport2.equals(AirportCode.AMS))
            {
                return AMS_MEX_DIST;
            }

            else if(airport2.equals(AirportCode.JFK))
            {
                return JFK_MEX_DIST;
            }

            else if(airport2.equals(AirportCode.LAX))
            {
                return MEX_LAX_DIST;
            }
        }

        else if(airport1.equals(AirportCode.LAX))
        {
            if(airport2.equals(AirportCode.AMS))
            {
                return AMS_LAX_DIST;
            }

            else if(airport2.equals(AirportCode.MEX))
            {
                return MEX_LAX_DIST;
            }

            else if(airport2.equals(AirportCode.JFK))
            {
                return JFK_LAX_DIST;
            }
        }

        throw new IllegalStateException("No known distance between " + airport1 + " and " + airport2);
    }
}
