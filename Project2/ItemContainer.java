import java.util.*;
/**
 * ItemContainer class.
 * 
 * @author Nakul Talwar
 */
public class ItemContainer
{
    //ArrayList object to be used as the container.
    private ArrayList<Item> cont;
    /**
     * Default constructor.
     */
    public ItemContainer()
    {
        cont = new ArrayList<Item>();
    }

    /**
     * Method to add an item to the container.
     * 
     * @return Whether the item was added successfully.
     */
    public boolean add(Item item)
    {
        if(item == null){return false;}
        return cont.add(item);
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
    public Item get(int index){
        try{
            return cont.get(index);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.toString());
            return null;
        }
    }
}
