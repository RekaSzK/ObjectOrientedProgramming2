package com.nhlstenden.flightbooking;

public class CommercialAirplane extends Airplane
{
    public static final double ECON_SEATS_MULTIPLIER = 1.75;
    public static final double BUS_SEATS_MULTIPLIER = 1.98;
    public static final double ECON_SEATS_TAKEN_MULTIPLIER = 2.02;
    public static final double BUS_SEATS_TAKEN_MULTIPLIER = 2.87;
    public static final double LUGGAGE_WEIGHT_MULTIPLIER = 0.3;

    private int numOfEconSeats;
    private int numOfBusSeats;
    private int numOfEconSeatsTaken;
    private int numOfBusSeatsTaken;

    public CommercialAirplane(String code, double currentFuelLevel, boolean holdsLuggage, int numOfEconSeats, int numOfBusSeats)
    {
        super(code, currentFuelLevel, holdsLuggage);
        this.setNumOfEconSeats(numOfEconSeats);
        this.setNumOfBusSeats(numOfBusSeats);
        this.setNumOfEconSeatsTaken(0);
        this.setNumOfBusSeatsTaken(0);
    }

    public int getNumOfEconSeats()
    {
        return this.numOfEconSeats;
    }

    public void setNumOfEconSeats(int numOfEconSeats)
    {
        if (numOfEconSeats < 0)
        {
            throw new IllegalArgumentException("Number of economy seats cannot be negative.");
        }

        this.numOfEconSeats = numOfEconSeats;
    }

    public int getNumOfBusSeats()
    {
        return this.numOfBusSeats;
    }

    public void setNumOfBusSeats(int numOfBusSeats)
    {
        if (numOfBusSeats < 0)
        {
            throw new IllegalArgumentException("Number of business seats cannot be negative.");
        }

        this.numOfBusSeats = numOfBusSeats;
    }

    public int getNumOfEconSeatsTaken()
    {
        return this.numOfEconSeatsTaken;
    }

    public int getNumOfBusSeatsTaken()
    {
        return this.numOfBusSeatsTaken;
    }

    @Override
    public double getFuelUsage(int distance, double luggageWeight)
    {
        return (this.getNumOfEconSeats() * ECON_SEATS_MULTIPLIER + this.getNumOfBusSeats() * BUS_SEATS_MULTIPLIER) * distance
                + (this.getNumOfEconSeatsTaken() * ECON_SEATS_TAKEN_MULTIPLIER)
                + (this.getNumOfBusSeatsTaken() * BUS_SEATS_TAKEN_MULTIPLIER)
                + (luggageWeight * LUGGAGE_WEIGHT_MULTIPLIER);
    }

    @Override
    public void reserveSeat() throws NoAvailableSeatException
    {
        if (this.getNumOfEconSeatsTaken() < this.getNumOfEconSeats())
        {
            this.setNumOfEconSeatsTaken(this.getNumOfEconSeatsTaken() + 1);
        }
        else if (this.getNumOfBusSeatsTaken() < this.getNumOfBusSeats())
        {
            this.setNumOfBusSeatsTaken(this.getNumOfBusSeatsTaken() + 1);
        }
        else
        {
            throw new NoAvailableSeatException("No available seats on this commercial airplane.");
        }
    }

    public int getTotalSeats()
    {
        return this.getNumOfEconSeats() + this.getNumOfBusSeats();
    }

    public int getTotalSeatsTaken()
    {
        return this.getNumOfEconSeatsTaken() + this.getNumOfBusSeatsTaken();
    }

    @Override
    public String getInfo()
    {
        int numEmptySeats = this.getTotalSeats() - this.getTotalSeatsTaken();

        return ("P: " + this.getCode() + ". " + this.getCurrentFuelLevel() + " liter fuel. " + numEmptySeats + " empty seats.");
    }

    public void setNumOfEconSeatsTaken(int numOfEconSeatsTaken)
    {
        this.numOfEconSeatsTaken = numOfEconSeatsTaken;
    }

    public void setNumOfBusSeatsTaken(int numOfBusSeatsTaken)
    {
        this.numOfBusSeatsTaken = numOfBusSeatsTaken;
    }
}
