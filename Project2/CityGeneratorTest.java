
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CityGeneratorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CityGeneratorTest
{
    private CityGenerator citygen;
    /**
     * Default constructor for test class CityGeneratorTest
     */
    public CityGeneratorTest()
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
        citygen = new CityGenerator(new CityContainer());
        assertEquals(null, citygen.generate());
    }

    @Test
    public void GenTest2()
    {
        CityContainer cont = new CityContainer();
        City city1 = new City("SomeCity1");
        City city2 = new City("SomeCity2");
        City city3 = new City("SomeCity3");

        cont.add(city1);
        citygen = new CityGenerator(cont);
        for(int i = 0; i<10; i++){
            assertEquals(city1, citygen.generate());
        }

        cont.add(city2);
        cont.add(city3);
        citygen = new CityGenerator(cont);
        for(int i = 0; i<10; i++){
            boolean valid = false;
            City testcity = citygen.generate();
            if(testcity.equals(city1)){valid = true;}
            if(testcity.equals(city2)){valid = true;}
            if(testcity.equals(city3)){valid = true;}
            assertEquals(true, valid);
        }
    }
}

