public class Kale extends Vegetable
{
    private static final double CM_PER_LUX = 0.0057;
    private static final double CM_PER_MILLIMETER = 0.032;
    private static final Color COLOR = Color.YELLOW;
    private static final int RIPE_LENGTH = 16;

    public Kale()
    {
        super(CM_PER_LUX, CM_PER_MILLIMETER, RIPE_LENGTH, COLOR);
    }

    @Override
    public void grow(int lux, int mm, int amountOfDays)
    {
        if (mm > 40 && amountOfDays >= 6)
        {
            return;
        }

        double growth = amountOfDays * (lux * CM_PER_LUX + mm * CM_PER_MILLIMETER);

        this.setSizeInCm(this.getSizeInCm() + growth);
    }
}
