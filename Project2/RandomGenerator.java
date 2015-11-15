import java.util.*;
/**
 * RandomGenerator class to generate random numbers in a range.
 * 
 * @author Nakul Talwar
 */
public class RandomGenerator
{
    private Random rand;
    private int low;
    private int high;
    /**
     * Default constructor.
     * 
     * @param low Initializes lower bound.
     * @param high Initializes upper bound.
     */
    public RandomGenerator(int low, int high)
    {
        rand = new Random();
        this.low = low;
        this.high = high;
    }

    /**
     * Method to generate and return random numbers in a range.
     *
     * @return Returns random number as an integer.
     */
    public int generate(){
        return rand.nextInt((high-low)+1)+low;
    }
}
