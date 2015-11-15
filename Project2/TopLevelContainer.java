import java.util.*;
/**
 * TopLevelContainer class.
 * 
 * @author Nakul Talwar
 */
public class TopLevelContainer
{
    //HashMap object to be used as a primary container
    private HashMap<String,CityHolder> cont;
    //Number of customers that have been stored in the database
    private int size;

    /**
     * Default constructor.
     */
    public TopLevelContainer()
    {
        cont = new HashMap<String,CityHolder>();
        size = 0;
    }

    /**
     * Method to add a customer to the container.
     * 
     * @param customer Customer to be added.
     */
    public boolean add(Customer customer)
    {
        if(customer == null){return false;}
        if(cont.get(customer.getCity().getName()) == null){      
            cont.put(customer.getCity().getName(), new CityHolder(customer.getCity()));
        }
        cont.get(customer.getCity().getName()).add(customer);
        size++;
        return true;
    }

    /**
     * Method to retrieve size of the container.
     * 
     * @return Returns the size.
     */
    public int size(){
        return size;
    }

    /**
     * Method to retrieve a subcontainer for this container(corresponding to a city).
     * 
     * @param city City corresponding to the sub-container to be retrieved.
     * @return Returns the item using specific key.
     */
    public CityHolder get(City city){
        try{
            return cont.get(city.getName());
        }catch(NullPointerException e){
            System.out.println(e.toString());
            return null;
        }
    }

    /**
     * Method to list customers within a specific city who need all specified items.
     * 
     * @param city City to be searched for customers.
     * @param items Set of items that customers should need.
     */
    public void list(City city, ItemContainer items){  
        try{
            System.out.println("\n"+city.getName()+":");
            for(int i = 0; i<this.get(city).get(items.get(0)).size(); i++){
                if(this.get(city).get(items.get(0)).get(i).needs(items)){
                    System.out.println("Customer "+this.get(city).get(items.get(0)).get(i).getID());
                }
            }
        }catch(NullPointerException e){}
    }

    /**
     * Method to find goods purchased by customers within a specific city in order of most purchased to least purchased.
     * 
     * @param city City to be searched for customers.
     */
    public void findgoods(City city){    
        try{
            System.out.println("\n"+city.getName()+":");
            TreeSet<ItemHolder> ItemTree  = new TreeSet<ItemHolder>(new ItemHolderComparator());
            ItemTree.add(this.get(city).get(new Item("baked goods")));
            ItemTree.add(this.get(city).get(new Item("meat")));
            ItemTree.add(this.get(city).get(new Item("dairy")));
            ItemTree.add(this.get(city).get(new Item("fruits")));
            ItemTree.add(this.get(city).get(new Item("vegetables")));
            ItemTree.add(this.get(city).get(new Item("beverages")));
            Iterator<ItemHolder> itr = ItemTree.descendingIterator();
            while(itr.hasNext()){
                System.out.println(itr.next().getType());
            }
        }catch(NullPointerException e){}
    }

    /**
     * Method to list cities sorted by the number of people from those cities who purchased a specific set of items.
     * 
     * @param city Cities to be listed in order.
     * @param items Set of items that customers should need.
     */
    public void findcities(CityContainer cities, ItemContainer items){    
        try{
            TreeSet<CityHolder> CityTree  = new TreeSet<CityHolder>(new CityHolderComparator());
            for(int i = 0; i<cities.size(); i++){
                this.get(cities.get(i)).setCustomersWhoNeed(items);
                CityTree.add(this.get(cities.get(i)));
            }
            Iterator<CityHolder> itr = CityTree.descendingIterator();
            System.out.println();
            while(itr.hasNext()){
                System.out.println(itr.next().getName());
            }
        }catch(NullPointerException e){}
    }
}
