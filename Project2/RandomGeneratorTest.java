
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RandomGeneratorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RandomGeneratorTest
{
    private RandomGenerator randomGen;

    /**
     * Default constructor for test class RandomGeneratorTest
     */
    public RandomGeneratorTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        randomGen = new RandomGenerator(50 , 100);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void RangeTest()
    {
        int test;
        for(int i = 0; i<1000; i++){
            test = randomGen.generate();
            assertTrue(test>=50);
            assertTrue(test<=100);
        }
    }
}

