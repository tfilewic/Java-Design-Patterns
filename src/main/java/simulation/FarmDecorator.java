package simulation;
import farms.Farm;

/**
 * Interface to give a farm extra functionality, like earning extra income from supplemental operations.
 * The "Decorator" class from the Decorator pattern.
 * @author tfilewic
 */
public abstract class FarmDecorator implements Farm {
    
    //Reference to the base farm that is being decorated.
    private Farm farm;
    
    /**
     * Earns extra income from supplemental operations.
     */
    protected abstract void doExtra();
    
    /**
     * Adds the additional income to the farm's base earnings.
     */
    @Override
    public void update(boolean isDay) {
        farm.update(isDay);
        doExtra();
    }
    
    //TODO : concrete implementations  (examples: apiary, market, events rental, 
}
