package asset;

/**
 * An income earning asset.
 * @author tfilewic
 *
 */
public interface Asset {

    /**
     * Produces income.
     * @return The amount earned/
     */
    public int produce();
    
    
    /**
     * Updates the asset by one half cycle.
     * @param isDay If it is daytime in the current cycle.
     */
    public void update(boolean isDay);
    
    
    /**
     * String to display the asset's current state.
     * @return The current state to as a String.
     */
    public String display();
    
    
    /**
     * Purchases an upgrade for this asset.
     * @param cost The amount to spend.
     */
    public void upgrade(int cost);
    
}
