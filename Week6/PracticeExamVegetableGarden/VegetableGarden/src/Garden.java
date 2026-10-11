import java.util.HashSet;

public class Garden
{
    private HashSet<Vegetable> vegetables;

    public Garden()
    {
        this.vegetables = new HashSet<>(); //Note to myself: this is to avoid NullPointerException!
    }

    public HashSet<Vegetable> getVegetables()
    {
        return this.vegetables;
    }

    public void addVegetable(Vegetable vegetable)
    {
        if (vegetable == null)
        {
            throw new IllegalArgumentException("Vegetable cannot be null.");
        }

        if (this.getVegetables().size() >= 27)
        {
            throw new TooManyVegetablesException("The garden can only accommodate 27 vegetables.");
        }

        this.getVegetables().add(vegetable);
    }

    public void removeVegetable(Vegetable vegetable)
    {
        if (vegetable == null)
        {
            throw new IllegalArgumentException("Vegetable cannot be null.");
        }

        else if (!this.getVegetables().contains(vegetable))
        {
            throw new IllegalArgumentException("Vegetable not in hashset.");
        }

        this.getVegetables().remove(vegetable);
    }

    public HashSet<Vegetable> getReadyForHarvest()
    {
        HashSet<Vegetable> readyForHarvest = new HashSet<>();

        for (Vegetable currentVegetable : this.getVegetables())
        {
            if (currentVegetable.getStatus().equals(Status.READY_TO_HARVEST))
            {
                readyForHarvest.add(currentVegetable);
            }
        }

        return readyForHarvest;
    }

    public void setVegetables(HashSet<Vegetable> vegetables)
    {
        this.vegetables = vegetables;
    }
}