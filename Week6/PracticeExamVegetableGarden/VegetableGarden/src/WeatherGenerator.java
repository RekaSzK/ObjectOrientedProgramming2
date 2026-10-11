import java.util.Random;

public class WeatherGenerator
{
    private WeatherGenerator()
    {
    }

    //To include the upper bounds, I have added 1 to the numbers.

    public static int getRandomLux()
    {
        Random random = new Random();

        return random.nextInt(1000, 101593);
    }

    public static int getRandomMm()
    {
        Random random = new Random();

        return random.nextInt(0, 49);
    }
}
