package farms;

/**
 * Common interface for all farms.
 * The "Product" of the Factory pattern
 * The "Component" of the Decorator pattern.
 * @author tfilewic
 */
public interface Farm {
    
    /**
     * Updates the state of the farm by one 12hr tick.
     * @return if the farm is broke.
     */
    boolean update(boolean isDay);
    
    /**
     * Prints the current state of the farm.
     */
    void display();
    
    
}
     