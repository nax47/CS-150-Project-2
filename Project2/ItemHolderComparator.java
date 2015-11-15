import java.util.*;
/**
 * ItemHolderComparator class to impose ordering based on ItemHolder size.
 * 
 * @author Nakul Talwar
 */
public class ItemHolderComparator implements Comparator<ItemHolder>
{
    /**
     * Default constructor.
     */
    public ItemHolderComparator(){

    }

    /**
     * Public method called to compare 2 ItemHolders.
     * 
     * @param holder1 First ItemHolder object.
     * @param holder2 Second ItemHolder object.
     */
    public int compare(ItemHolder holder1, ItemHolder holder2){
        return new Integer(holder1.size()).compareTo(new Integer(holder2.size()));
    }
}
