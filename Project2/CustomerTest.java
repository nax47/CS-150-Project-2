import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CustomerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CustomerTest
{
    private Customer customer;
    /**
     * Default constructor for test class CustomerTest
     */
    public CustomerTest()
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
        customer = new Customer(56789, new City("Some City"), true, false, true, false, true, false);
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
    public void CustomerIDTest()
    {
        assertEquals(56789, customer.getID());
    }

    @Test
    public void CustomerCityTest()
    {
        assertEquals("Some City", customer.getCity().getName());
    }

    @Test
    public void NeedTest1()
    {
        assertEquals(true, customer.needsBaked());
        assertEquals(false, customer.needsMeat());
        assertEquals(true, customer.needsDairy());
        assertEquals(false, customer.needsFruit());
        assertEquals(true, customer.needsVegetable());
        assertEquals(false, customer.needsBeverage());
    }

    @Test
    public void NeedTest2()
    {
        ItemContainer testcont = new ItemContainer();
        assertEquals(true, customer.needs(testcont));
        testcont.add(new Item("baked goods"));
        assertEquals(true, customer.needs(testcont));
        testcont.add(new Item("dairy"));
        assertEquals(true, customer.needs(testcont));
        testcont.add(new Item("vegetables"));
        assertEquals(true, customer.needs(testcont));
        testcont.add(new Item("meat"));
        assertEquals(false, customer.needs(testcont));
    }

    @Test
    public void NeedTest3()
    {
        assertEquals(false, customer.needs(null));
    }
}

