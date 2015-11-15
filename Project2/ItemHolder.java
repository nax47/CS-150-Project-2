import java.util.*;
/**
 * ItemHolder class.
 * 
 * @author Nakul Talwar
 */
public class ItemHolder
{
    //LinkedList object to be used as tertiary container
    private LinkedList<Customer> cont;
    //Item that this holder stores data for
    private Item item;
    /**
     * Default constructor.
     */
    public ItemHolder(Item item)
    {
        cont = new LinkedList<Customer>();
        this.item = item;
    }

    /**
     * Method to add a customer to the container.
     * 
     * @param customer Customer to be added.
     */
    public boolean add(Customer customer)
    {
        if(customer!=null)
            return cont.add(customer);
        return false;
    }

    /**
     * Method to retrieve a customer within this subcontainer.
     * 
     * @param index Index in the container which will be queried.
     * @return Returns the customer object.
     */
    public Customer get(int index){
        try{
            return cont.get(index);
        }catch(IndexOutOfBoundsException e){
            System.out.println(e.toString());
            return null;
        }
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
     * Method to retrieve Item type that corresponds to this sub container as String.
     * 
     * @return The type of item.
     */
    public String getType()
    {
        return item.getType();
    }
}

