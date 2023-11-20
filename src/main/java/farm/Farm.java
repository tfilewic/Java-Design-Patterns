package farm;

/**
 * Common interface for all farm.
 * The "Product" of the Factory pattern
 * The "Component" of the Decorator pattern.
 * @author tfilewic
 */
public interface Farm {
    
    /**
     * Updates the state of the farm by half a cycle.
     * @param isDay If it is daytime in the current cycle.
     * @return if the farm is broke.
     */
    boolean update(boolean isDay);
    
    /**
     * Prints the current state of the farm.
     */
    void display();

    /**
     * Deposits the specified amount in the account.
     * @param amount The amount to deposit.
     */
    void earn(int amount);
    
    
}
     