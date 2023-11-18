package farms;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import simulation.Farmer;

/**
 * Manages farms.
 * An "Observer" for the Observer pattern.
 * @author z
 *
 */
public class FarmManager implements PropertyChangeListener {

    private List<Farm> farms;                   //the list of farms
    private Queue<Farmer[]> branchingFarmers;   //the groups of farmers waiting create a new farm
    private FarmFactory factory;
    
    /*
     * Default constructor.
     */
    public FarmManager(){
        farms = new LinkedList<Farm>();
        branchingFarmers = new LinkedList<Farmer[]>();
        factory = new BasicFarmFactory(this);
    }
    
    
    
    /**
     * Adds a new farm to the collection of farms.
     * @param farm The farm to add.
     */
    public void addFarm(Farm farm) {
        farms.add(farm);
    }
    
    /**
     * Updates all farms by one half cycle.
     * @param isDay If it is daytime.
     */
    public void updateFarms(boolean isDay) {
        for (Farm farm : farms) {
            boolean isBroke = farm.update(isDay);
            if (isBroke) {
                System.out.println("***Farm has gone out of business***");
                farms.remove(farm);
            }
            farm.display();
        }
        createBranches();
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        System.out.println("Farm full.  Creating new farm.");
        Farmer[] farmers = (Farmer[]) event.getNewValue();
        branchingFarmers.add(farmers);
    }
    
    private void createBranches() {
        Farmer[] farmers;
        Farm newFarm;
        while (!branchingFarmers.isEmpty()) {
            farmers = branchingFarmers.remove();
            newFarm = factory.createFarm(FarmType.getRandom(), farmers);
            addFarm(newFarm);
        }     
    }
    
    public FarmFactory getFactory() {
        return factory;
    }
    
}
