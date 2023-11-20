package farm;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Manages farm.
 * The "Observer" for the Observer pattern.
 * @author tfilewic
 *
 */
public class FarmManager implements PropertyChangeListener {

    private LinkedList<Farm> farms;             //the farms being managed
    private Queue<Farmer[]> branchingFarmers;   //the groups of farmers waiting create a new farm
    private FarmFactory factory;                //factory for creating farms
    
    /**
     * Constructor.
     */
    public FarmManager() {
        farms = new LinkedList<Farm>();
        branchingFarmers = new LinkedList<Farmer[]>();
        factory = new BasicFarmFactory(this);
    }
    
    
    /**
     * Adds a new farm to the collection of farm.
     * @param farm The farm to add.
     */
    public void addFarm(Farm farm) {
        farms.add(farm);
    }
    
    /**
     * Creates and adds a new farm.
     * @param type The type to create and add.
     */
    public void addNewFarm(FarmType type) {
        Farm newFarm = factory.createFarm(type);
        addFarm(newFarm);
    }
    
    /**
     * Updates all farm by one half cycle.
     * @param isDay If it is daytime.
     */
    public void updateFarms(boolean isDay) {
        Farm currentFarm;
        Farm wrappedFarm;
        boolean isBroke;
        int i = 0;
        while (i < farms.size()) {
            currentFarm = farms.get(i);
            isBroke = currentFarm.update(isDay);
            if (isBroke) {
                System.out.println("***Farm has gone out of business***");
                farms.remove(i);
            } else {
                wrappedFarm = addSupplementalOperations(currentFarm);
                if (wrappedFarm != currentFarm) {
                    farms.set(i, wrappedFarm);
                }
                i++;
            }
            currentFarm.display();
        }
        createBranches();
    }
    
    /**
     * Adds farmers to queue to open a new farm upon receiving farm is full event from Farm.
     * The Update() method from the Observer pattern.
     */
    @Override
    public void propertyChange(PropertyChangeEvent event) {
        System.out.println("Farm full.  Creating new farm.");
        Farmer[] farmers = (Farmer[]) event.getNewValue();
        branchingFarmers.add(farmers);
    }
    
    /**
     * Creates new farm for each group of farmers in branchingFarmers.
     */
    private void createBranches() {
        Farmer[] farmers;
        Farm newFarm;
        while (!branchingFarmers.isEmpty()) {
            farmers = branchingFarmers.remove();
            newFarm = factory.createFarm(FarmType.getRandom(), farmers);
            addFarm(newFarm);
        }     
    }
    
    /**
     * Has a chance to decorate a farm to earn extra income.
     * @param farm The farm to decorate.
     */
    private Farm addSupplementalOperations(Farm farm) {
        int n = simulation.RandomNumber.get(200);

        if (n == 1) {
            System.out.println("Added an apiary");
            farm = new FarmWithApiary(farm);
        } else if (n == 2) {
            System.out.println("Added a market");
            farm = new FarmWithMarket(farm);
        }
        return farm;
    }

    

}
