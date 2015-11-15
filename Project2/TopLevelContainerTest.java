
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TopLevelContainerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TopLevelContainerTest
{
    private TopLevelContainer topLevel1;

    /**
     * Default constructor for test class TopLevelContainerTest
     */
    public TopLevelContainerTest()
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
        topLevel1 = new TopLevelContainer();
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
    public void AddGetTest1()
    {
        assertEquals(false, topLevel1.add(null));
        assertEquals(null, topLevel1.get(new City("SomeCity")));
    }

    @Test
    public void AddGetTest2()
    {
        Customer customer1 = new Customer(56789, new City("SomeCity1"), true, false, true, false, true, false);
        topLevel1.add(customer1);
        assertNotNull(topLevel1.get(new City("SomeCity1")));
        assertNull(topLevel1.get(new City("SomeCity2")));
        Customer customer2 = new Customer(98765, new City("SomeCity2"), false, true, false, true, false, true);
        topLevel1.add(customer2);
        assertNotNull(topLevel1.get(new City("SomeCity1")));
        assertNotNull(topLevel1.get(new City("SomeCity2")));
    }

    @Test
    public void SizeTest()
    {
        assertEquals(0, topLevel1.size());
        Customer customer1 = new Customer(56789, new City("SomeCity1"), true, false, true, false, true, false);
        topLevel1.add(customer1);
        assertEquals(1, topLevel1.size());
        Customer customer2 = new Customer(98765, new City("SomeCity2"), false, true, false, true, false, true);
        topLevel1.add(customer2);
        assertEquals(2, topLevel1.size());
    }
}
