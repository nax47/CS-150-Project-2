import java.util.*;
import java.io.*;
/**
 * Interface class.
 * 
 * @author Nakul Talwar
 */
public class Interface
{
    //Filename to read city data from
    private static final String filename = "cities.txt";
    //Object to control and run program functionality
    private ExperimentController cntrl;
    //Object to scan user input
    private Scanner sc;

    /**
     * Default constructor.
     */
    public Interface()
    {
        cntrl = new ExperimentController();
        sc = new Scanner(System.in);
    }

    /**
     * Main method use to run program.
     * 
     * Starts the interface and calls method to start accepting user input.
     * 
     * @param args Any command line arguments.
     */
    public static void main(String[] args){
        Interface consol = new Interface();
        System.out.println("\fWelcome to the CS150 Project 2 interface!");
        consol.getInput();
    }

    /**
     * Method used to accept and parse user command inputs.
     * 
     * Calls additional methods for further processing.
     */
    private void getInput(){
        System.out.println("\nType a valid command:");
        String param = "";
        switch(sc.next()){
            case "init": init();
            break;
            case "run": cntrl.run(Integer.parseInt(sc.next()));
            break;
            case "clear": cntrl.clear();
            break;
            case "list": sc.nextLine(); list();
            break;
            case "findgoods": sc.nextLine(); findgoods();
            break;
            case "findcities": sc.nextLine(); findcities();
            break;
            case "add": sc.nextLine(); add();
            break;
            case "exit": sc.close(); return;
            default: System.out.println("Invalid input!");
            break;
        }
        getInput();
    }

    /**
     * Method used to read and parse file with city data
     * 
     * Passes city data in a container to a controller method.
     */
    private void init(){
        CityContainer CityCont = new CityContainer();
        try{
            Scanner sc2 = new Scanner(new File(filename));
            while(sc2.hasNextLine()){
                CityCont.add(new City(sc2.nextLine()));
            }
            sc2.close();
            cntrl.init(CityCont);
        }catch(IOException e){
            System.out.println(e.toString());
        }
    }

    /**
     * Method used to add an additional city for subsequent runs.
     * 
     * Passes City object to a controller method.
     */
    private void add(){
        cntrl.add(new City(parseParam(sc.nextLine())));
    }

    /**
     * Method used to parse and accept input of various cities and items for listing customers.
     * 
     * Passes containers with city data and item data to a controller method.
     */
    private void list(){
        Scanner sc2;
        CityContainer CityCont = new CityContainer();
        ItemContainer ItemCont = new ItemContainer();
        while(sc.hasNextLine()){
            sc2 = new Scanner(sc.nextLine());
            if(sc2.hasNext("city:")){
                CityCont.add(new City(parseParam(sc2.nextLine())));
            }
            else if(sc2.hasNext("item:")){
                ItemCont.add(new Item(parseParam(sc2.nextLine())));
            }
            else{
                break;
            }
            sc2.close();
        }
        cntrl.list(CityCont, ItemCont);
    }

    /**
     * Method used to parse and accept input of various cities for listing goods.
     * 
     * Passes containers with city data to a controller method.
     */
    private void findgoods(){
        Scanner sc2;
        CityContainer CityCont = new CityContainer();
        while(sc.hasNextLine()){
            sc2 = new Scanner(sc.nextLine());
            if(sc2.hasNext()){
                CityCont.add(new City(sc2.nextLine()));
            }
            else{
                break;
            }
            sc2.close();
        }
        cntrl.findgoods(CityCont);
    }

    /**
     * Method used to parse and accept input of various goods for listing cities.
     * 
     * Passes containers with item data to a controller method.
     */
    private void findcities(){
        Scanner sc2;
        ItemContainer ItemCont = new ItemContainer();
        while(sc.hasNextLine()){
            sc2 = new Scanner(sc.nextLine());
            if(sc2.hasNext()){
                ItemCont.add(new Item(sc2.nextLine()));
            }
            else{
                break;
            }
            sc2.close();
        }
        cntrl.findcities(ItemCont);
    }

    /**
     * Method used to parse any parameter input to the console.
     * 
     * This method is called by other methods to parse input.
     * 
     * @param line String to be parsed.
     * @return Returns parsed parameter value as a String.
     */
    private String parseParam(String line){
        Scanner sc2 = new Scanner(line);
        String param = "";
        sc2.next();
        do{ param = param + sc2.next() + " ";}while(sc2.hasNext());
        param = param.trim();
        sc2.close();
        return param;
    }
}
