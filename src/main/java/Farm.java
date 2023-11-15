


/**
 * Common interface for all farms.
 * The "Product" of the Factory pattern
 * The "Component" of the Decorator pattern.
 * @author tfilewic
 */
public interface Farm {
    
    /**
     * Updates the state of the farm by one 12hr tick.
     */
    void tick(boolean isDay);
    
    /**
     * Earns the farm passive income from its operations;
     */
    void earn();
   
    
    void addFarmer(Farmer farmer);
   
    //TODO : concrete implementations
}
 