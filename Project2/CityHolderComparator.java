import java.util.*;
/**
 * CityHolderComparator class to impose ordering based on number of customers who need a set of items in a CityHolder.
 * 
 * @author Nakul Talwar
 */
public class CityHolderComparator implements Comparator<CityHolder>
{
    /**
     * Default constructor.
     */
    public CityHolderComparator(){

    }

    /**
     * Public method called to compare 2 CityHolders.
     * 
     * @param holder1 First CityHolder object.
     * @param holder2 Second CityHolder object.
     */
    public int compare(CityHolder holder1, CityHolder holder2){
        return new Integer(holder1.getCustomersWhoNeed()).compareTo(new Integer(holder2.getCustomersWhoNeed()));
    }
}