package asset;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * A farm animal used for income.
 * The "Subject" of the Observer pattern.
 * @author tfilewic
 *
 */
public abstract class Animal {
    
    protected PropertyChangeSupport support;    //Instance to support the Observer pattern
    protected String type = "";                 //The description for the type of crop.
    protected int fertility = 3;                //The fertility factor of this species (1-10)
    protected int age = 0;                      //The number of cycles the animal has been alive
    protected int lastProduction = 0;           //The number of cycles since the animal has produced
    
    /**
     * Constructor.
     */
    protected Animal() {
        support = new PropertyChangeSupport(this);
    }
    
    /**
     * Produces income for the farm.
     * @return the income produced by this animal.
     */
    abstract int produce();
    
    /**
     * Gives birth to offspring.
     */
    protected abstract void giveBirth();
    
    /**
     * Dies at the end of its natural life.
     */
    protected abstract void die();
    
    /**
     * Updates the status of this animal by one half cycle.
     * @param isDay If it is daytime in the current cycle.
     */
    public void update(boolean isDay) {
        if (isDay) {
            age++;
            if (isPregnant())  {
                giveBirth();
            }  
        } else {
            if (age >= 14) {
                die();
            }
        }
    }
    
    /**
     * Calculates if the asset is ready to give birth.
     * @return if the asset is ready to give birth.
     */
    private boolean isPregnant() {
        
        boolean correctTiming = (age > 2 && (age - 2) % 4 == 0);  
        boolean isLucky = fertility >= simulation.RandomNumber.get(10);
        
        return (correctTiming && isLucky);  
    }
    
    /**
     * Gets the animal's type.
     * @return
     */
    public String getAnimalType() {
        return type;
    }
    
    /**
     * Adds a PropertyChangeListener to this PropertyChangeSupport.
     * @param listener The "Observer" of the Observer pattern.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Removes a PropertyChangeListener to this PropertyChangeSupport.
     * @param listener The "Observer" of the Observer pattern.
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
