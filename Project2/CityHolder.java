import java.util.*;
/**
 * CityHolder class.
 * 
 * @author Nakul Talwar
 */
public class CityHolder
{
    //HashMap object to be used as secondary container
    private HashMap<String,ItemHolder> cont;
    //City that this holder stores data for
    private City city;
    //Variable to store the number of customers who need a specific set of items
    //Is updated whenever a new set of items is queried
    private int CustomersWhoNeed;

    /**
     * Default constructor.
     */
    public CityHolder(City city)
    {
        cont = new HashMap<String,ItemHolder>();
        this.city = city;
        CustomersWhoNeed = 0;
    }

    /**
     * Method to add a customer to the container.
     * 
     * @param customer Customer to be added.
     */
    public boolean add(Customer customer)
    {
        if(customer == null){return false;}
        if(customer.needsBaked()){addToItemHolder(customer, new Item("baked goods"));}
        if(customer.needsMeat()){addToItemHolder(customer, new Item("meat"));}
        if(customer.needsDairy()){addToItemHolder(customer, new Item("dairy"));}
        if(customer.needsFruit()){addToItemHolder(customer, new Item("fruits"));}
        if(customer.needsVegetable()){addToItemHolder(customer, new Item("vegetables"));}
        if(customer.needsBeverage()){addToItemHolder(customer, new Item("beverages"));}
        return true;
    }

    /**
     * Method to add a customer to a specific item set.
     * 
     * @param customer Customer to be added.
     * @param item Item corresponding to the subcontainer where customer will be added.
     */
    private void addToItemHolder(Customer customer, Item item)
    {
        if(cont.get(item.getType()) == null){      
            cont.put(item.getType(), new ItemHolder(item));
        }
        cont.get(item.getType()).add(customer);
    }

    /**
     * Method to retrieve a subcontainer for this container(corresponding to a specific item).
     * 
     * @param item Item corresponding to the subcontainer to be retrieved,
     * @return Returns the subcontainer object.
     */
    public ItemHolder get(Item item){
        try{
            return cont.get(item.getType());
        }catch(NullPointerException e){
            System.out.println(e.toString());
            return null;
        }
    }

    /**
     * Method to retrieve City name that corresponds to this sub container as String.
     * 
     * @return The name of city.
     */
    public String getName()
    {
        return city.getName();
    }

    /**
     * Method to calculate and store the number of customers in a city who need a specific set of items.
     * 
     * @param items Set of items that customers should need.
     */
    public boolean setCustomersWhoNeed(ItemContainer items){
        CustomersWhoNeed = 0;
        try{
            for(int i = 0; i<this.get(items.get(0)).size(); i++){
                if(this.get(items.get(0)).get(i).needs(items)){
                    CustomersWhoNeed++;
                }
            }
            return true;
        }catch(NullPointerException e){
            System.out.println(e.toString());
            return false;
        }
    }

    /**
     * Method to retrieve the number of customers who needed a specific set of items.
     * 
     * Value retrieved corresponds to item set last used to call setCustomersWhoNeed().
     * 
     * @return Number of customers who needed that set of items.
     */
    public int getCustomersWhoNeed(){
        return CustomersWhoNeed;
    }
}

