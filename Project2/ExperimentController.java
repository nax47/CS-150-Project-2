import java.util.*;
/**
 * ExperimentController class.
 * 
 * @author Nakul Talwar
 */
public class ExperimentController
{
    //Container to store all the cities which customers come from
    private CityContainer cities;
    //Top level container which stores sub containers for storing customer data
    private TopLevelContainer cont;
    /**
     * Default constructor.
     */
    public ExperimentController()
    {
        cities = new CityContainer();
        cont = new TopLevelContainer();
    }

    /**
     * Method to initialize program by adding a set of cities to the container for this experiment.
     * 
     * @param cities Container of cities passed to this method externally.
     */
    public void init(CityContainer cities){
        this.cities = cities;
    }

    /**
     * Method to run the simultion a specific number of times.
     * 
     * @param n Number of times the simulation should be run.
     */
    public void run(int n){
        long startTime = System.nanoTime();
        Simulation sim;
        for(int i =0; i<n; i++){
            sim = new Simulation(cities,cont);
            cont = sim.run();
        }
        long stopTime = System.nanoTime();
        System.out.println("Time taken: "+(stopTime-startTime)+" nanoseconds");
    }

    /**
     * Method to clear all data by instantiating a new top level data container.
     */
    public void clear(){
        cont = new TopLevelContainer();
    }

    /**
     * Method to list customers within specific cities who need all specified items.
     * 
     * Calls method within top level container.
     * 
     * @param CityCont Cities to be searched for customers.
     * @param ItemCont Set of items that customers should need.
     */
    public void list(CityContainer CityCont, ItemContainer ItemCont){
        long startTime = System.nanoTime();
        if(CityCont.size() == 0 || ItemCont.size() == 0) {return;}
        for(int i = 0; i<CityCont.size(); i++){
            cont.list(CityCont.get(i), ItemCont);
        }
        long stopTime = System.nanoTime();
        System.out.println("Time taken: "+(stopTime-startTime)+" nanoseconds");
    }

    /**
     * Method to add city to container of cities for this experiment.
     * 
     * @param city City to be added.
     */
    public void add(City city){
        if(city == null){return;}
        cities.add(city);
    }

    /**
     * Method to find goods purchased by customers within specific cities in order of most purchased to least purchased.
     * 
     * Calls method within top level container.
     * 
     * @param CityCont Cities to be searched for customers.
     */
    public void findgoods(CityContainer CityCont){
        long startTime = System.nanoTime();
        if(CityCont.size() == 0) {return;}
        for(int i = 0; i<CityCont.size(); i++){
            cont.findgoods(CityCont.get(i));
        }
        long stopTime = System.nanoTime();
        System.out.println("Time taken: "+(stopTime-startTime)+" nanoseconds");
    }

    /**
     * Method to list cities sorted by the number of people from those cities who purchased a specific set of items.
     * 
     * Calls method within top level container.
     * 
     * @param city Cities to be listed in order.
     * @param items Set of items that customers should need.
     */
    public void findcities(ItemContainer ItemCont){
        long startTime = System.nanoTime();
        if(ItemCont.size() == 0) {return;}
        cont.findcities(cities, ItemCont);
        long stopTime = System.nanoTime();
        System.out.println("Time taken: "+(stopTime-startTime)+" nanoseconds");
    }
}
