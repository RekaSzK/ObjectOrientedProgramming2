public class Greenhouse extends Garden
{
    public void runWeather()
    {
        //Declared here because if I called them directly each time in the for-loop I'd get different values each time.
        int lux = WeatherGenerator.getRandomLux();
        int mm = WeatherGenerator.getRandomMm();

        for (Vegetable currentVegetable : this.getVegetables())
        {
            currentVegetable.grow(lux, mm, 1);
        }
    }
}
