import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsparagusTest
{
    private Asparagus asparagus;

    @BeforeEach
    void setUp()
    {
        //Default size = 0
        this.asparagus = new Asparagus();
    }

    @Test
    void grow_15MmFor11Days_expectAsparagusGrows()
    {
        this.asparagus.grow(1000,15,11);

        assertEquals(1.1055, this.asparagus.getSizeInCm());
    }

    @Test
    void grow_15MmFor10Days_expectAsparagusGrows()
    {
        this.asparagus.grow(1000,15,10);

        assertEquals(1.005, this.asparagus.getSizeInCm());
    }

    @Test
    void grow_15MmFor9Days_expectAsparagusGrows()
    {
        this.asparagus.grow(1000,15,9);

        assertEquals(0.9045, this.asparagus.getSizeInCm());

    }

    @Test
    void grow_14MmFor11Days_expectAsparagusGrows()
    {
        this.asparagus.grow(1000, 14, 11);

        assertEquals(1.0516, this.asparagus.getSizeInCm(), 0.00001);
    }

    @Test
    void grow_14MmFor10Days_expectAsparagusGrows()
    {
        this.asparagus.grow(1000,14,10);

        assertEquals(0.956, this.asparagus.getSizeInCm());
    }

    @Test
    void grow_14MmFor9Days_expectAsparagusGrows()
    {
        this.asparagus.grow(1000, 14, 9);

        assertEquals(0.8604, this.asparagus.getSizeInCm(), 0.00001);
    }

    @Test
    void grow_13MmFor11Days_expectStatusDestroyed()
    {
        this.asparagus.grow(1000,13,11);

        assertEquals(Status.DESTROYED, this.asparagus.getStatus());
    }

    @Test
    void grow_13MmFor10Days_expectStatusDestroyed()
    {
        this.asparagus.grow(1000,13,10);

        assertEquals(Status.DESTROYED, this.asparagus.getStatus());
    }

    @Test
    void grow_13MmFor9Days_expectAsparagusGrows()
    {
        this.asparagus.grow(1000, 13, 9);

        assertEquals(0.8163, this.asparagus.getSizeInCm(), 0.00001);
    }
}