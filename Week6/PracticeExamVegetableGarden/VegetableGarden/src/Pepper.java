public class Pepper extends Vegetable
{
    private static final double CM_PER_LUX = 0.000044;
    private static final double CM_PER_MILLIMETER = 0.0013;
    private static final Color COLOR = Color.PINK;
    private static final int RIPE_LENGTH = 7;

    public Pepper()
    {
        super(CM_PER_LUX, CM_PER_MILLIMETER, RIPE_LENGTH, COLOR);
    }

    @Override
    public void grow(int lux, int mm, int amountOfDays)
    {
        if (amountOfDays > 4 && mm > 31)
        {
            this.setStatus(Status.DESTROYED);

            return;
        }

        else if (mm < 25 && amountOfDays >= 10)
        {
            return;
        }

        double growth = amountOfDays * (lux * CM_PER_LUX + mm * CM_PER_MILLIMETER);

        this.setSizeInCm(this.getSizeInCm() + growth);
    }
}
