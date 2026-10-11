import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GardenTest
{
    private Garden garden;

    @BeforeEach
    void setUp()
    {
        this.garden = new Garden();
    }

    @Test
    void addVegetable_nullVegetable_expectIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () -> {
            this.garden.addVegetable(null);
        });
    }

    @Test
    void addVegetable_validVegetableGardenNotFull_expectVegetableAdded()
    {
        Asparagus asparagus = new Asparagus();

        this.garden.addVegetable(asparagus);

        assertEquals(1, this.garden.getVegetables().size());
    }

    @Test
    void addVegetable_reachMaximumCapacity_expect27Vegetables()
    {
        for (int i = 0; i < 27; i++) //Note to myself: Reminder - this is from i = 0 to i = 26.
        {
            this.garden.addVegetable(new Asparagus());
        }

        assertEquals(27, this.garden.getVegetables().size());
    }

    @Test
    void addVegetable_reachMaximumCapacityPlusOne_expectTooManyVegetablesException()
    {
        for (int i = 0; i < 27; i++)
        {
            this.garden.addVegetable(new Asparagus());
        }

        assertThrows(TooManyVegetablesException.class, () ->
        {
            this.garden.addVegetable(new Asparagus());
        });

        assertEquals(27, this.garden.getVegetables().size());
    }
}