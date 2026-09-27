package com.nhlstenden.flightbooking;

public class PrivateAirplane extends Airplane
{
    public static final double SEAT_MULTIPLIER = 1.31;
    public static final double SEATS_TAKEN_MULTIPLIER = 1.87;
    public static final double LUGGAGE_WEIGHT_MULTIPLIER = 0.4;

    private int numOfSeats;
    private int numOfSeatsTaken;

    public PrivateAirplane(String code, double currentFuelLevel, boolean holdsLuggage, int numOfSeats)
    {
        super(code, currentFuelLevel, holdsLuggage);
        this.setNumOfSeats(numOfSeats);
        this.setNumOfSeatsTaken(0);
    }

    public int getNumOfSeats()
    {
        return this.numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats)
    {
        if (numOfSeats <= 0)
        {
            throw new IllegalArgumentException("Number of seats must be positive.");
        }

        this.numOfSeats = numOfSeats;
    }

    public int getNumOfSeatsTaken()
    {
        return this.numOfSeatsTaken;
    }

    public void setNumOfSeatsTaken(int numOfSeatsTaken)
    {
        if (numOfSeatsTaken < 0)
        {
            throw new IllegalArgumentException("Number of seats taken cannot be negative.");
        }

        this.numOfSeatsTaken = numOfSeatsTaken;
    }

    @Override
    public double getFuelUsage(int distance, double luggageWeight)
    {
        return (this.getNumOfSeats() * SEAT_MULTIPLIER * distance + (this.getNumOfSeatsTaken() * SEATS_TAKEN_MULTIPLIER) + (luggageWeight * LUGGAGE_WEIGHT_MULTIPLIER));
    }

    @Override
    public void reserveSeat() throws NoAvailableSeatException
    {
        if (this.getNumOfSeatsTaken() >= this.getNumOfSeats())
        {
            throw new NoAvailableSeatException("No available seats on this private airplane.");
        }

        this.setNumOfSeatsTaken(this.getNumOfSeatsTaken() + 1);
    }

    @Override
    public String getInfo()
    {
        int numEmptySeats = this.getNumOfSeats() - this.getNumOfSeatsTaken();

        return ("P: " + this.getCode() + ". " + this.getCurrentFuelLevel() + " liter fuel. " + numEmptySeats + " empty seats.");
    }
}
