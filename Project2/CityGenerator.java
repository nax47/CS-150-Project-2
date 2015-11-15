/**
 * CityGenerator class.
 * 
 * @author Nakul Talwar
 */
public class CityGenerator
{
    //Object to generate a random number between in range with the number of cities
    private RandomGenerator RandomNumberGenerator;
    //Object to store cities to be selected from
    private CityContainer CityCont;
    /**
     * Default constructor.
     */
    public CityGenerator(CityContainer CityCont)
    {
        this.CityCont = CityCont;
        RandomNumberGenerator = new RandomGenerator(0,CityCont.size()-1);
    }

    /**
     * Method to randomly pick a city from the container of cities.
     * 
     * @return Returns the randomly chosen city.
     */
    public City generate(){
        if(CityCont.size()==0){return null;}
        return CityCont.get(RandomNumberGenerator.generate());
    }
}
