/**
 * Item class.
 * 
 * @author Nakul Talwar
 */
public class Item
{
    //Type of item
    private String type;
    /**
     * Default constructor
     */
    public Item(String type)
    {
        this.type = type;
    }

    /**
     * Method to retrieve Item type.
     * 
     * @return The type of item.
     */
    public String getType()
    {
        return type;
    }
}
