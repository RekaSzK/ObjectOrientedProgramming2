import java.util.HashSet;

public class Marketable
{
    private static final double ASPARAGUS_PRICE_PER_CM_IN_EUROS = 0.12;
    private static final double PEPPER_PRICE_PER_CM_IN_EUROS = 0.15;
    private HashSet<Vegetable> marketableVegetables;

    public Marketable(HashSet<Vegetable> marketableVegetables)
    {
        this.setMarketableVegetables(marketableVegetables);
    }

    public HashSet<Vegetable> getMarketableVegetables()
    {
        return this.marketableVegetables;
    }

    public void addMarketableVegetable(Vegetable vegetable)
    {
        if (vegetable == null)
        {
            throw new IllegalArgumentException("Vegetable cannot be null.");
        }

        this.getMarketableVegetables().add(vegetable);
    }

    public void removeMarketableVegetable(Vegetable vegetable)
    {
        if (vegetable == null)
        {
            throw new IllegalArgumentException("Vegetable cannot be null.");
        }

        else if (!this.getMarketableVegetables().contains(vegetable))
        {
            throw new IllegalArgumentException("Vegetable not in hashset.");
        }

        this.getMarketableVegetables().remove(vegetable);
    }

    public boolean isMarketable(Vegetable vegetable)
    {
        if (vegetable == null)
        {
            throw new IllegalArgumentException("Vegetable cannot be null.");
        }

        if (vegetable instanceof Asparagus)
        {
            return vegetable.getSizeInCm() <= 29;
        }

        else if (vegetable instanceof Pepper)
        {
            return vegetable.getSizeInCm() >= 15 && vegetable.getSizeInCm() <= 21;
        }

        return false;
    }

    public double getPrice(Vegetable vegetable)
    {
        if (vegetable == null)
        {
            throw new IllegalArgumentException("Vegetable cannot be null.");
        }

        if (vegetable instanceof Asparagus)
        {
            return ASPARAGUS_PRICE_PER_CM_IN_EUROS;
        }

        else if (vegetable instanceof Pepper)
        {
            return PEPPER_PRICE_PER_CM_IN_EUROS;
        }

        return 0;
    }

    public double getTotalProfits()
    {
        double totalProfits = 0;

        for (Vegetable currentVegetable : this.getMarketableVegetables())
        {
            totalProfits += getPrice(currentVegetable);
        }

        return totalProfits;
    }

    public void setMarketableVegetables(HashSet<Vegetable> marketableVegetables)
    {
        this.marketableVegetables = marketableVegetables;
    }
}
