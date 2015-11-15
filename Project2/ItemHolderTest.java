
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ItemHolderTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ItemHolderTest
{
    private ItemHolder itemHold1;

    /**
     * Default constructor for test class ItemHolderTest
     */
    public ItemHolderTest()
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
        itemHold1 = new ItemHolder(new Item("SomeItem"));
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
    public void TypeTest()
    {
        assertEquals("SomeItem", itemHold1.getType());
    }

    @Test
    public void AddGetTest1()
    {
        assertEquals(false, itemHold1.add(null));
        assertEquals(null, itemHold1.get(0));
    }

    @Test
    public void AddGetTest2()
    {
        Customer customer1 = new Customer(56789, new City("SomeCity1"), true, false, true, false, true, false);
        Customer customer2 = new Customer(98765, new City("SomeCity2"), false, true, false, true, false, true);
        assertEquals(true, itemHold1.add(customer1));
        assertEquals(true, itemHold1.add(customer2));
        assertEquals(customer1, itemHold1.get(0));
        assertEquals(customer2, itemHold1.get(1));
    }

    @Test
    public void SizeTest()
    {
        assertEquals(0, itemHold1.size());
        Customer customer1 = new Customer(56789, new City("SomeCity1"), true, false, true, false, true, false);
        itemHold1.add(customer1);
        assertEquals(1, itemHold1.size());
        Customer customer2 = new Customer(98765, new City("SomeCity2"), false, true, false, true, false, true);
        itemHold1.add(customer2);
        assertEquals(2, itemHold1.size());
    }

}

