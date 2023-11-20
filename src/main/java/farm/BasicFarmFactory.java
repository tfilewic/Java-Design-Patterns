package farm;

import java.beans.PropertyChangeListener;

/**
 * Class to create BasicFarm objects.
 * A "Concrete Creator" class for the Factory pattern.

 * @author tfilewic
 */
public class BasicFarmFactory implements FarmFactory {
    
    static int lastId;
    PropertyChangeListener observer;
    
    
    /**
     * Default constructor.
     * @param observer The observer for property change events.
     */
    public BasicFarmFactory(FarmManager observer) {
        lastId = 0;
        this.observer = observer;
    }
   
    
    /**
     * Creates a new Farm with a default six new farmers.
     * The parameterized variation of the factoryMethod() from the Factory pattern.
     * @param type The type of farm to create.
     * @return the new Farm.
     */
    @Override
    public Farm createFarm(FarmType type) {
        BasicFarm farm = createBasicFarm(type);
        farm.setId(++lastId);
        farm.addPropertyChangeListener(observer);
        addFarmers(farm, new Farmer[] {new Farmer(), new Farmer(), new Farmer(), 
            new Farmer(), new Farmer(), new Farmer()});
        return farm;
    }
    
    /**
     * Creates a Farm object of the specified type with
     * the provided Farmers.
     * @param farmers An array of Farmers.
     */
    @Override
    public Farm createFarm(FarmType type, Farmer[] farmers) {
        BasicFarm farm = createBasicFarm(type);
        farm.setId(++lastId);
        farm.addPropertyChangeListener(observer);
        addFarmers(farm, farmers);
        return farm;
    }
    
    /**
     * Creates a BasicFarm of the provided type.
     * @param type The type of farm to create.
     * @return The new BasicFarm object.
     */
    private BasicFarm createBasicFarm(FarmType type) {
        BasicFarm farm;
        switch (type) {
            case DAIRY:
                farm = new DairyFarm();
                break;
            case WHEAT:
                farm = new WheatFarm();
                break;
            case SHEEP:
                farm = new SheepFarm();
                break;
            case CORN:
                farm = new CornFarm();
                break;
            default:
                farm = new DairyFarm();
                break;
        }
        return farm;
    }
    
    /**
     * Adds the farmers to the farm.
     * @param farm The farm.
     * @param farmers An array of three or more farmers.
     */
    private void addFarmers(BasicFarm farm, Farmer[] farmers) {
        if (farmers == null || farmers.length < 3) {
            throw new IllegalArgumentException("Must have 3 or more Farmers");
        }
       
        for (Farmer farmer : farmers) {
            farm.addFarmer(farmer);
        }
    }
    

}
