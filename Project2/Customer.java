/**
 * Customer class.
 * 
 * @author Nakul Talwar
 */
public class Customer
{
    //Boolean to store whether or not a customer needs certain items
    private boolean BakedNeed;
    private boolean MeatNeed;
    private boolean DairyNeed;
    private boolean FruitNeed;
    private boolean VegNeed;
    private boolean BevNeed;
    //Unique ID for each type of person
    private int ID;
    //City that the customer belongs to
    private City city;
    /**
     * Default constructor.
     * 
     * Initializes a customer's unique ID and randomly generates needs.
     * 
     * @param id Customer's ID number.
     * @param city City that the customer belongs to.
     * @param BakedNeed Whether or not the customer needs baked goods.
     * @param MeatNeed Whether or not the customer needs meat.
     * @param DairyNeed Whether or not the customer needs dairy.
     * @param FruitNeed Whether or not the customer needs fruits.
     * @param VegNeed Whether or not the customer needs vegetables.
     * @param BevNeed Whether or not the customer needs beverages.
     */
    public Customer(int ID, City city, boolean BakedNeed, boolean MeatNeed, boolean DairyNeed, boolean FruitNeed, boolean VegNeed, boolean BevNeed)
    {
        this.ID = ID;
        this.city = city;
        this.BakedNeed = BakedNeed;
        this.MeatNeed = MeatNeed;
        this.DairyNeed = DairyNeed;
        this.FruitNeed = FruitNeed;
        this.VegNeed = VegNeed;
        this.BevNeed = BevNeed;
    }

    /**
     * Method to retrieve a customer's Baked need.
     * 
     * @return Returns the need as a boolean.
     */
    public boolean needsBaked(){
        return BakedNeed;
    }

    /**
     * Method to retrieve a customer's Meat need.
     * 
     * @return Returns the need as a boolean.
     */
    public boolean needsMeat(){
        return MeatNeed;
    }

    /**
     * Method to retrieve a customer's Dairy need.
     * 
     * @return Returns the need as a boolean.
     */
    public boolean needsDairy(){
        return DairyNeed;
    }

    /**
     * Method to retrieve a customer's Fruit need.
     * 
     * @return Returns the need as a boolean.
     */
    public boolean needsFruit(){
        return FruitNeed;
    }

    /**
     * Method to retrieve a customer's Vegetable need.
     * 
     * @return Returns the need as a boolean.
     */
    public boolean needsVegetable(){
        return VegNeed;
    }

    /**
     * Method to retrieve a customer's Beverage need.
     * 
     * @return Returns the need as a boolean.
     */
    public boolean needsBeverage(){
        return BevNeed;
    }

    /**
     * Method to return a customers need for a certain set of items.
     * 
     * @param items ItemContainer object used to determine need.
     * @return Returns whether or not the customer needs all the items of this set.
     */
    public boolean needs(ItemContainer items){
        try{
            for(int i = 0; i<items.size(); i++){
                boolean need = true;
                switch(items.get(i).getType()){
                    case "baked goods": need = needsBaked();
                    break;
                    case "meat": need = needsMeat();
                    break;
                    case "dairy": need = needsDairy();
                    break;
                    case "fruits": need = needsFruit();
                    break;
                    case "vegetables": need = needsVegetable();
                    break;
                    case "beverages": need = needsBeverage();
                    break;
                }
                if(need == false){return false;}
            }
            return true;
        }catch(NullPointerException e){
            System.out.println(e.toString());
            return false;
        }
    }

    /**
     * Retrieves a person's ID number.
     * 
     * @return Returns ID as integer.
     */
    public int getID(){
        return ID;
    }

    /**
     * Retrieves a person's City.
     * 
     * @return Returns City.
     */
    public City getCity(){
        return city;
    }
}
