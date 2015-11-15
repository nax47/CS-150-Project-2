
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ItemContainerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ItemContainerTest
{
    private ItemContainer itemCont1;

    /**
     * Default constructor for test class ItemContainerTest
     */
    public ItemContainerTest()
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
        itemCont1 = new ItemContainer();
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
        itemCont1.add(new Item("SomeItem1"));
        assertEquals(itemCont1.get(0).getType(), "SomeItem1");
        itemCont1.add(new Item("SomeItem2"));
        itemCont1.add(new Item("SomeItem3"));
        assertEquals(itemCont1.get(2).getType(), "SomeItem3");
        assertEquals(itemCont1.get(1).getType(), "SomeItem2");
        assertEquals(itemCont1.get(0).getType(), "SomeItem1");
    }

    @Test
    public void AddGetTest2()
    {
        assertEquals(false, itemCont1.add(null));
        assertEquals(null, itemCont1.get(-1));
    }

    @Test
    public void SizeTest()
    {
        assertEquals(0, itemCont1.size());
        itemCont1.add(new Item("SomeItem1"));
        assertEquals(1, itemCont1.size());
        for(int i = 1; i<100; i++){
            itemCont1.add(new Item("SomeItem"+(i+1)));
        }
        assertEquals(100, itemCont1.size());
    }
}


