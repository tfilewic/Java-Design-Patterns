package animals;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.LinkedList;
import java.util.Queue;



/**
 * Manages the animals on a farm
 * @author tfilewic
 */
public class Herd implements PropertyChangeListener {
    
    //implements observer to add new animals when born
    
    private LinkedList<Animal> animals;
    private Queue<Animal> babies;
    
    
    public Herd() {
        animals = new LinkedList<Animal>();
        babies = new LinkedList<Animal>();
    }
    /**
     * Uses the herd for income.
     * @return the revenue generated.
     */
    public int produce() {
        int revenue = 0;
        for (Animal animal : animals) {
            revenue += animal.produce();
        }
        return revenue;
    }
    
    /*
     * Updates the herd's animals by one half day tick.
     */
    public void update(boolean isDay) {
        for (Animal animal : animals) {
            animal.update(isDay);
        }
        while (!babies.isEmpty()) {
            addAnimal(babies.remove());
        }
        
        
    }
    
    /*
     * Gets the number of animals in the herd.
     */
    public int getSize() {
        return animals.size();
    }
    
    public String getType() {
        String type = "animals";
        if (animals != null && !(animals.isEmpty())) {
            type = animals.peek().getAnimalType();
        }
        return type;
    }
   
    public void addAnimal(Animal animal) {
        animals.add(animal);
        animal.addPropertyChangeListener(this);
    }
    

    public String display() {
        String description = getSize() + " " + getType();
        return description;
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String propertyName = evt.getPropertyName();
        
        if (propertyName.equals("birth")) {
            Animal baby = (Animal) evt.getNewValue();
            babies.add(baby);
        }

        
    }
    
}
