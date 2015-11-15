
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CityContainerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CityContainerTest
{
    private CityContainer cityCont1;

    /**
     * Default constructor for test class CityContainerTest
     */
    public CityContainerTest()
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
        cityCont1 = new CityContainer();
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
        cityCont1.add(new City("SomeCity1"));
        assertEquals(cityCont1.get(0).getName(), "SomeCity1");
        cityCont1.add(new City("SomeCity2"));
        cityCont1.add(new City("SomeCity3"));
        assertEquals(cityCont1.get(2).getName(), "SomeCity3");
        assertEquals(cityCont1.get(1).getName(), "SomeCity2");
        assertEquals(cityCont1.get(0).getName(), "SomeCity1");
    }

    @Test
    public void AddGetTest2()
    {
        assertEquals(false, cityCont1.add(null));
        assertEquals(null, cityCont1.get(-1));
    }

    @Test
    public void SizeTest()
    {
        assertEquals(0, cityCont1.size());
        cityCont1.add(new City("SomeCity1"));
        assertEquals(1, cityCont1.size());
        for(int i = 1; i<100; i++){
            cityCont1.add(new City("SomeCity"+(i+1)));
        }
        assertEquals(100, cityCont1.size());
    }
}


