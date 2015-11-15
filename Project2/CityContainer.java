import java.util.*;
/**
 * CityContainer class.
 * 
 * @author Nakul Talwar
 */
public class CityContainer
{
    //ArrayList object to be used as the container.
    private ArrayList<City> cont;
    /**
     * Default constructor.
     */
    public CityContainer()
    {
        cont = new ArrayList<City>();
    }

    /**
     * Method to add an item to the container.
     * 
     * @return Whether the item was added successfully.
     */
    public boolean add(City city)
    {
        if(city==null){return false;}
        return cont.add(city);
    }

    /**
     * Method to retrieve size of the container.
     * 
     * @return Returns the size.
     */
    public int size(){
        return cont.size();
    }

    /**
     * Method to retrieve an item in the container.
     * 
     * @return Returns the item at specified index.
     */
    public City get(int index){
        try{
            return cont.get(index);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.toString());
            return null;
        }
    }
}
