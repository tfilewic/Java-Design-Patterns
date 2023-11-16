package animals;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.LinkedList;
import java.util.Queue;



/**
 * Manages the animals on a farm
 * The "Observer" in the Observer pattern to handle births and deaths.
 * @author tfilewic
 */
public class Herd implements PropertyChangeListener {
    

    private LinkedList<Animal> animals; //the current animals in the herd
    private Queue<Animal> births;       //the newly born animals to be added to the herd
    private Queue<Animal> deaths;       //the newly dead animals to be removed from the herd
    
    /**
     * Default constructor.
     */
    public Herd() {
        animals = new LinkedList<Animal>();
        births = new LinkedList<Animal>();
        deaths = new LinkedList<Animal>();
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
        processBirths();
        processDeaths();
    }
    
    /*
     * Gets the number of animals in the herd.
     */
    public int getSize() {
        return animals.size();
    }
    
    /**
     * Gets the string description for this type of animal.
     * @return the type.
     */
    public String getType() {
        String type = "animals";
        if (animals != null && !(animals.isEmpty())) {
            type = animals.peek().getAnimalType();
        }
        return type;
    }
   
    /**
     * Adds an animal to the herd.
     * @param animal The animal to add.
     */
    public void addAnimal(Animal animal) {
        animals.add(animal);
        animal.addPropertyChangeListener(this);
    }
    
    /*
     * Prints the quantity and type of animals in this herd.
     */
    public String display() {
        String description = getSize() + " " + getType();
        return description;
    }
    
    /*
     * Handles property change events for the Subject classes being observed.
     * Adds newly born animals to births queue, and newly dead animals to
     * deaths queue.
     */
    @Override
    public void propertyChange(PropertyChangeEvent event) {
        String propertyName = event.getPropertyName();
        
        if (propertyName.equals("birth")) {
            Animal baby = (Animal) event.getNewValue();
            births.add(baby);
        } else if (propertyName.equals("death")) {
            Animal deadAnimal = (Animal) event.getNewValue();
            deaths.add(deadAnimal);
        }
    }
    
    /**
     * Adds animals in births queue to the herd.
     */
    private void processBirths() {
        while (!births.isEmpty()) {
            Animal baby = births.remove();
            addAnimal(baby);
        }
    }
    
    /**
     * Removes animals in deaths queue from the herd.
     */
    private void processDeaths() {
        while (!deaths.isEmpty()) {
            Animal deadAnimal = deaths.remove();
            animals.remove(deadAnimal);
        }
    }
}
