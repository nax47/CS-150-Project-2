

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SimulationTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SimulationTest
{
    /**
     * Default constructor for test class SimulationTest
     */
    public SimulationTest()
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
    public void RunTest()
    {
        CityContainer cont = new CityContainer();
        TopLevelContainer cont2 = new TopLevelContainer();
        cont.add(new City("SomeCity1"));
        cont.add(new City("SomeCity2"));
        cont.add(new City("SomeCity3"));
        Simulation sim = new Simulation(cont, cont2);
        assertTrue(cont2.size()==0);
        assertTrue(sim.run().size()>0);
    }
}

