import java.util.*;
/**
 * GaussianGenerator class to generate random numbers with a Gaussian distribution.
 * 
 * @author Nakul Talwar
 */
public class GaussianGenerator
{
    private Random rand;
    private int mean;
    private int std_dev;
    /**
     * Default constructor.
     * 
     * @param mean Mean value for Gaussian distribution.
     * @param std_dev Standard deviation for Gaussian Distribution.
     */
    public GaussianGenerator(int mean, int std_dev)
    {
        rand = new Random();
        this.mean = mean;
        this.std_dev = std_dev;
    }

    /**
     * Method to generate and return random numbers in a Gaussian distribution.
     *
     * @return Returns random number as an integer.
     */
    public int generate(){
        return (int)(mean + rand.nextGaussian() * std_dev);
    }
}
