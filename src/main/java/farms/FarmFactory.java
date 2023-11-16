package farms;
import simulation.Farmer;
import simulation.Simulation;

/**
 * Class to create Farm objects.
 * A concrete "Creator" class in the Factory pattern
 * @author tfilewic
 */
public class FarmFactory {
    
    Simulation simulation;
    int lastId = 0;
    
    public FarmFactory(Simulation simulation){
        this.simulation = simulation;
    }
    
    /**
     * Adds a new farm to the simulation.
     * @param farmers
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
       
        simulation.addFarm(farm);   
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
    
}
