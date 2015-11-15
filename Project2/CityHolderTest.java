
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CityHolderTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CityHolderTest
{
    private CityHolder cityHold1;

    /**
     * Default constructor for test class CityHolderTest
     */
    public CityHolderTest()
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
        cityHold1 = new CityHolder(new City("SomeCity"));
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
    public void NameTest()
    {
        assertEquals("SomeCity", cityHold1.getName());
    }

    @Test
    public void AddGetTest1()
    {
        assertEquals(false, cityHold1.add(null));
        assertEquals(null, cityHold1.get(new Item("SomeItem")));
    }

    @Test
    public void AddGetTest2()
    {
        Customer customer1 = new Customer(56789, new City("SomeCity"), true, false, true, false, true, false);
        assertEquals(true, cityHold1.add(customer1));
        assertNotNull(cityHold1.get(new Item("baked goods")));
        assertNull(cityHold1.get(new Item("meat")));
        assertNotNull(cityHold1.get(new Item("dairy")));
        assertNull(cityHold1.get(new Item("fruits")));
        assertNotNull(cityHold1.get(new Item("vegetables")));
        assertNull(cityHold1.get(new Item("beverages")));
    }

    @Test
    public void CustomersNeedTest()
    {
        assertEquals(false, cityHold1.setCustomersWhoNeed(null));

        ItemContainer cont1 = new ItemContainer();
        cont1.add(new Item("baked goods"));
        cont1.add(new Item("dairy"));
        cont1.add(new Item("vegetables"));
        ItemContainer cont2 = new ItemContainer();
        cont2.add(new Item("meat"));
        cont2.add(new Item("fruits"));
        cont2.add(new Item("beverages"));

        cityHold1.setCustomersWhoNeed(cont1);
        assertEquals(0, cityHold1.getCustomersWhoNeed());
        cityHold1.setCustomersWhoNeed(cont2);
        assertEquals(0, cityHold1.getCustomersWhoNeed());

        Customer customer1 = new Customer(56789, new City("SomeCity"), true, false, true, false, true, false);
        cityHold1.add(customer1);
        cityHold1.setCustomersWhoNeed(cont1);
        assertEquals(1, cityHold1.getCustomersWhoNeed());
        cityHold1.setCustomersWhoNeed(cont2);
        assertEquals(0, cityHold1.getCustomersWhoNeed());

        Customer customer2 = new Customer(98765, new City("SomeCity"), false, true, false, true, false, true);
        cityHold1.add(customer2);
        cityHold1.setCustomersWhoNeed(cont1);
        assertEquals(1, cityHold1.getCustomersWhoNeed());
        cityHold1.setCustomersWhoNeed(cont2);
        assertEquals(1, cityHold1.getCustomersWhoNeed());

        cityHold1.add(customer1);
        cityHold1.setCustomersWhoNeed(cont1);
        assertEquals(2, cityHold1.getCustomersWhoNeed());
        cityHold1.setCustomersWhoNeed(cont2);
        assertEquals(1, cityHold1.getCustomersWhoNeed());
    }
}

