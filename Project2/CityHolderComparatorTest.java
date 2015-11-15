
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CityHolderComparatorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CityHolderComparatorTest
{
    private CityHolderComparator cityHold1;
    private CityHolder holder1;
    private CityHolder holder2;
    /**
     * Default constructor for test class CityHolderComparatorTest
     */
    public CityHolderComparatorTest()
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
        cityHold1 = new CityHolderComparator();
        holder1 = new CityHolder(new City("TestCity1"));
        holder2 = new CityHolder(new City("TestCity2"));
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
    public void CompareTest1()
    {
        Customer customer1 = new Customer(56789, new City("SomeCity1"), true, false, true, false, true, false);
        Customer customer2 = new Customer(98765, new City("SomeCity2"), false, true, false, true, false, true);
        Customer customer3 = new Customer(12345, new City("SomeCity2"), true, false, true, false, true, false);
        Customer customer4 = new Customer(54321, new City("SomeCity1"), false, true, false, true, false, true);
        Customer customer5 = new Customer(19283, new City("SomeCity1"), true, false, true, false, true, false);
        ItemContainer cont1 = new ItemContainer();
        cont1.add(new Item("baked goods"));
        cont1.add(new Item("dairy"));
        cont1.add(new Item("vegetables"));
        ItemContainer cont2 = new ItemContainer();
        cont2.add(new Item("meat"));
        cont2.add(new Item("fruits"));
        cont2.add(new Item("beverages"));

        holder1.setCustomersWhoNeed(cont1);
        holder2.setCustomersWhoNeed(cont1);
        assertTrue(cityHold1.compare(holder1,holder2)==0); 
        holder1.setCustomersWhoNeed(cont2);
        holder2.setCustomersWhoNeed(cont2);
        assertTrue(cityHold1.compare(holder1,holder2)==0); 

        holder1.add(customer1);
        holder1.setCustomersWhoNeed(cont1);
        holder2.setCustomersWhoNeed(cont1);
        assertTrue(cityHold1.compare(holder1,holder2)>0);

        holder2.add(customer2);
        holder1.setCustomersWhoNeed(cont2);
        holder2.setCustomersWhoNeed(cont2);
        assertTrue(cityHold1.compare(holder1,holder2)<0);

        holder2.add(customer3);
        holder1.setCustomersWhoNeed(cont1);
        holder2.setCustomersWhoNeed(cont1);
        assertTrue(cityHold1.compare(holder1,holder2)==0);

        holder1.add(customer4);
        holder1.setCustomersWhoNeed(cont2);
        holder2.setCustomersWhoNeed(cont2);
        assertTrue(cityHold1.compare(holder1,holder2)==0);

        holder1.add(customer5);
        holder1.setCustomersWhoNeed(cont1);
        holder2.setCustomersWhoNeed(cont1);
        assertTrue(cityHold1.compare(holder1,holder2)>0);
    }
}

