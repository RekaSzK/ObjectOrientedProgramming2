public abstract class Vegetable
{
    private double sizeInCm;
    private double cmPerLux;
    private double cmPerMillimeter;
    private int ripeLength;
    private Color color;
    private Status status;

    public Vegetable(double cmPerLux, double cmPerMillimeter, int ripeLength, Color color)
    {
        this.setCmPerLux(cmPerLux);
        this.setCmPerMillimeter(cmPerMillimeter);
        this.setRipeLength(ripeLength);
        this.setColor(color);
        this.setSizeInCm(0);
        this.setStatus(Status.GROWING);
    }

    public double getSizeInCm()
    {
        return this.sizeInCm;
    }

    public void setSizeInCm(double sizeInCm)
    {
        if (sizeInCm < 0)
        {
            throw new IllegalArgumentException("Size in cm cannot be negative.");
        }

        this.sizeInCm = sizeInCm;
    }

    public double getCmPerLux()
    {
        return this.cmPerLux;
    }

    public void setCmPerLux(double cmPerLux)
    {
        if (cmPerLux < 0)
        {
            throw new IllegalArgumentException("Cm per lux cannot be negative.");
        }

        this.cmPerLux = cmPerLux;
    }

    public double getCmPerMillimeter()
    {
        return this.cmPerMillimeter;
    }

    public void setCmPerMillimeter(double cmPerMillimeter)
    {
        if (cmPerMillimeter < 0)
        {
            throw new IllegalArgumentException("Cm per millimeter cannot be negative.");
        }

        this.cmPerMillimeter = cmPerMillimeter;
    }

    public int getRipeLength()
    {
        return this.ripeLength;
    }

    public void setRipeLength(int ripeLength)
    {
        if (ripeLength <= 0)
        {
            throw new IllegalArgumentException("Ripe length must be positive.");
        }

        this.ripeLength = ripeLength;
    }

    public Color getColor()
    {
        return this.color;
    }

    public void setColor(Color color)
    {
        if (color == null)
        {
            throw new IllegalArgumentException("Color cannot be null.");
        }

        this.color = color;
    }

    public Status getStatus()
    {
        return this.status;
    }

    public void setStatus(Status status)
    {
        if (status == null)
        {
            throw new IllegalArgumentException("Status cannot be null.");
        }

        this.status = status;
    }

    public abstract void grow(int lux, int mm, int amountOfDays);
}
