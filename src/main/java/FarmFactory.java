/**
 * Class to create Farm objects.
 * A concrete "Creator" class in the Factory pattern
 * @author tfilewic
 */
public class FarmFactory {
    
    Simulation simulation;
    
    /**
     * Adds a new farm to the simulation.
     * @param farmers
     */
    public void addFarm(FarmType type, Farmer[] farmers){
        
        if (farmers.length < 3) {
            return;
        }
       
        Farm farm = createFarm(type);
        
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
            case BEEF:
                farm = new BeefFarm();
                break;
            case DIARY:
                farm = new DairyFarm();
                break;
            case GRAIN:
                farm = new GrainFarm();
                break;
            case OILSEED:
                farm = new OilseedFarm();
                break;
            case SHEEP:
                farm = new SheepFarm();
                break;
            case VEGETABLE:
                farm = new VegetableFarm();
                break;
            default:
                farm = new BeefFarm();
                break;
            }
        return farm;
    }
    
    //TODO : concrete implementations
}
