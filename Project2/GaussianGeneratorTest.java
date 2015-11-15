

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GaussianGeneratorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GaussianGeneratorTest
{
    private GaussianGenerator gaussianGen;
    
    /**
     * Default constructor for test class GaussianGeneratorTest
     */
    public GaussianGeneratorTest()
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
        gaussianGen = new GaussianGenerator(50,10);
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
    public void Test()
    {
        int test;
        for(int i = 0; i<100; i++){
            assertNotNull(gaussianGen.generate());
        }
    }
}
