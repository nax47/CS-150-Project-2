
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ItemHolderComparatorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ItemHolderComparatorTest
{
    private ItemHolderComparator itemHold1;
    private ItemHolder holder1;
    private ItemHolder holder2;
    /**
     * Default constructor for test class ItemHolderComparatorTest
     */
    public ItemHolderComparatorTest()
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
        itemHold1 = new ItemHolderComparator();
        holder1 = new ItemHolder(new Item("TestItem1"));
        holder2 = new ItemHolder(new Item("TestItem2"));
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
        assertEquals(0, itemHold1.compare(holder1,holder2)); 
        holder1.add(customer1);
        assertTrue(itemHold1.compare(holder1,holder2)>0);
        holder2.add(customer1);
        assertEquals(0, itemHold1.compare(holder1,holder2));
        holder2.add(customer2);
        assertTrue(itemHold1.compare(holder1,holder2)<0);
        holder1.add(customer2);
        assertEquals(0, itemHold1.compare(holder1,holder2));
    }
}

