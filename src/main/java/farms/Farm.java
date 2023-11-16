package farms;
import java.beans.PropertyChangeListener;

import simulation.Farmer;

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
    void update(boolean isDay);
   
    void addFarmer(Farmer farmer);
    
    void setId(int id);
    
    void addPropertyChangeListener(PropertyChangeListener listener);
    
}
 