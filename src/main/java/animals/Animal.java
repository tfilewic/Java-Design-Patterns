package animals;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;


public abstract class Animal {
    
    protected PropertyChangeSupport support;  //Instance to support the Observer pattern
    Animal offspring = null;
    protected String type = "";
    final int fertility;
    int age = 0;
    int lastProduction = 0;
    
    protected Animal() {
        fertility = 3;
        support = new PropertyChangeSupport(this);
    }
    
    abstract int produce();
    
    abstract void giveBirth();
    
    abstract void die();
    
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
     * Calculates if the animal is ready to give birth.
     * @return if the animal is ready to give birth.
     */
    private boolean isPregnant() {
        Random random = new Random();
        
        boolean correctTiming = (age > 2 && (age - 2) % 4 == 0);  
        boolean isLucky = fertility >= random.nextInt(1, 10);
        
        return (correctTiming && isLucky);  
    }
    
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
