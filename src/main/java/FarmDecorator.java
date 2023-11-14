/**
 * Interface to allow a farm to earn extra income from supplemental operations.
 * The "Decorator" class from the Decorator pattern.
 * @author tfilewic
 */
public abstract class FarmDecorator implements Farm {
    
    //Reference to the base farm that is being decorated.
    private Farm farm;
    
    /**
     * Earns extra income from supplemental operations.
     */
    protected abstract void earnExtra();
    
    /**
     * Adds the additional income to the farm's base earnings.
     */
    @Override
    public void earn() {
        farm.earn();
        earnExtra();
    }
    
    //TODO : concrete implementations  (examples: apiary, market, events rental, 
}
