public class Asparagus extends Vegetable
{
    private static final double CM_PER_LUX = 0.000027;
    private static final double CM_PER_MILLIMETER = 0.0049;
    private static final Color COLOR = Color.BLUE;
    private static final int RIPE_LENGTH = 20;

    public Asparagus()
    {
        super(CM_PER_LUX, CM_PER_MILLIMETER, RIPE_LENGTH, COLOR);
    }

    @Override
    public void grow(int lux, int mm, int amountOfDays)
    {
        if (mm < 14 && amountOfDays >= 10)
        {
            this.setStatus(Status.DESTROYED);

            return;
        }

        double growth = amountOfDays * (lux * CM_PER_LUX + mm * CM_PER_MILLIMETER);

        this.setSizeInCm(this.getSizeInCm() + growth);
    }
}
