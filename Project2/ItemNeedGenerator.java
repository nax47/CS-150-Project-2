/**
 * ItemNeedGenerator class.
 * 
 * @author Nakul Talwar
 */
public class ItemNeedGenerator
{
    //Objects to generate random numbers from a Gaussian Distribution based on percentage needs
    //Global objects will be used to generate one random number from a single random distribution every time generate() is used
    private static final GaussianGenerator BakedNeedGenerator = new GaussianGenerator(37,17);
    private static final GaussianGenerator MeatNeedGenerator = new GaussianGenerator(53,13);;
    private static final GaussianGenerator DairyNeedGenerator = new GaussianGenerator(59,19);
    private static final GaussianGenerator FruitNeedGenerator = new GaussianGenerator(47,13);
    private static final GaussianGenerator VegNeedGenerator = new GaussianGenerator(71,29);
    private static final GaussianGenerator BevNeedGenerator = new GaussianGenerator(43,11);
    //Object to generate a random number between 0 and 100
    //Global object will be used to generate one random number from a single random distribution every time generate() is used
    private static final RandomGenerator RandomNumberGenerator = new RandomGenerator(0,100);
    //Item distribution values to be used for this particular simulation run
    private int BakedDistributionValue;
    private int MeatDistributionValue;
    private int DairyDistributionValue;
    private int FruitDistributionValue;
    private int VegDistributionValue;
    private int BevDistributionValue;    
    /**
     * Default constructor.
     */
    public ItemNeedGenerator()
    {
        BakedDistributionValue = BakedNeedGenerator.generate();
        MeatDistributionValue = MeatNeedGenerator.generate();
        DairyDistributionValue = DairyNeedGenerator.generate();
        FruitDistributionValue = FruitNeedGenerator.generate();
        VegDistributionValue = VegNeedGenerator.generate();
        BevDistributionValue = BevNeedGenerator.generate();
    }

    /**
     * Method to generate need for a Baked item.
     * 
     * @return Returns the Baked need as a boolean.  
     */
    public boolean generateBakedNeed()
    {
        return RandomNumberGenerator.generate()<=BakedDistributionValue;
    }

    /**
     * Method to generate need for a Meat item.
     * 
     * @return Returns the Meat need as a boolean.  
     */
    public boolean generateMeatNeed()
    {
        return RandomNumberGenerator.generate()<=MeatDistributionValue;
    }

    /**
     * Method to generate need for a Dairy item.
     * 
     * @return Returns the Dairy need as a boolean.  
     */
    public boolean generateDairyNeed()
    {
        return RandomNumberGenerator.generate()<=DairyDistributionValue;
    }

    /**
     * Method to generate need for a Fruit item.
     * 
     * @return Returns the Fruit need as a boolean.  
     */
    public boolean generateFruitNeed()
    {
        return RandomNumberGenerator.generate()<=FruitDistributionValue;
    }

    /**
     * Method to generate need for a Veg item.
     * 
     * @return Returns the Veg need as a boolean.  
     */
    public boolean generateVegNeed()
    {
        return RandomNumberGenerator.generate()<=VegDistributionValue;
    }

    /**
     * Method to generate need for a Bev item.
     * 
     * @return Returns the Bev need as a boolean.  
     */
    public boolean generateBevNeed()
    {
        return RandomNumberGenerator.generate()<=BevDistributionValue;
    }
}
