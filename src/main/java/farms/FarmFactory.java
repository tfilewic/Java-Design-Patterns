package farms;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.LinkedList;
import java.util.List;

import simulation.Farmer;

/**
 * Class to create Farm objects.
 * A concrete "Creator" class in the Factory pattern.
 * An "Observer" for the Observer pattern.                             //TODO implement branching when farm is full
 * @author tfilewic
 */
public class FarmFactory implements PropertyChangeListener{
    
    private List<Farm> farms = new LinkedList<Farm>();  //the list of farms
    int lastId = 0;
    
    public FarmFactory(){
        
    }
    
    /**
     * Adds a new farm.
     * @param farmers An array of at least 3 farmers.
     */
    public void addFarm(FarmType type, Farmer[] farmers){
        
        if (farmers.length < 3) {
            return;
        }
       
        Farm farm = createFarm(type);
        farm.setId(++lastId);
        for (Farmer farmer : farmers) {
            farm.addFarmer(farmer);
        }
       
        farms.add(farm);   
    }
    
    
    /**
     * Creates a new Farm.
     * The parameterized variation of the factoryMethod() from the Factory pattern.
     * @param type The type of farm to create.
     * @return the new Farm.
     */
    private Farm createFarm(FarmType type) {
        Farm farm;
        switch(type) {
            case DAIRY:
                farm = new DairyFarm();
                break;
            case GRAIN:
                farm = new GrainFarm();
                break;
            case SHEEP:
                farm = new SheepFarm();
                break;
            case VEGETABLE:
                farm = new VegetableFarm();
                break;
            default:
                farm = new DairyFarm();
                break;
            }
        return farm;
    }

    /**
     * Updates all farms by one half cycle.
     * @param isDay If it is daytime.
     */
    public void updateFarms(boolean isDay) {
        for (Farm farm : farms) {
            farm.update(isDay);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // TODO Auto-generated method stub
        
    }
    
}
