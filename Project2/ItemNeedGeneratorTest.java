
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ItemNeedGeneratorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ItemNeedGeneratorTest
{
    /**
     * Default constructor for test class ItemNeedGeneratorTest
     */
    public ItemNeedGeneratorTest()
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
    public void GenTest1()
    {
        ItemNeedGenerator itemgen = new ItemNeedGenerator();

        assertNotNull(itemgen.generateBakedNeed());
        assertNotNull(itemgen.generateMeatNeed());
        assertNotNull(itemgen.generateDairyNeed());
        assertNotNull(itemgen.generateFruitNeed());
        assertNotNull(itemgen.generateVegNeed());
        assertNotNull(itemgen.generateBevNeed());
    }
}
