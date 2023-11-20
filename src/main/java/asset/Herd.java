package asset;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.LinkedList;
import java.util.Queue;


/**
 * Manages the asset on a farm
 * The "Observer" in the Observer pattern to handle births and deaths.
 * @author tfilewic
 */
public class Herd implements PropertyChangeListener, Asset {
    

    private LinkedList<Animal> animals; //the current asset in the herd
    private Queue<Animal> births;       //the newly born asset to be added to the herd
    private Queue<Animal> deaths;       //the newly dead asset to be removed from the herd.
    private int costPerAnimal = 100;    //the cost to purchase new asset for the herd.
   
    
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
    
    /**
     * Updates the herd by one half cycle.
     * @param isDay If it is daytime in the current cycle.
     */
    public void update(boolean isDay) {
        if (! isDay) {
            predatorKill();  
        }
        for (Animal animal : animals) {
            animal.update(isDay);
        }
        processBirths();
        processDeaths();
    }
    
    /*
     * Gets the number of asset in the herd.
     */
    public int getSize() {
        return animals.size();
    }
    
    /**
     * Gets the string description for this type of asset.
     * @return the type.
     */
    public String getType() {
        String type = "asset";
        if (animals != null && !(animals.isEmpty())) {
            type = animals.peek().getAnimalType();
        }
        return type;
    }
   
    /**
     * Adds an asset to the herd.
     * @param animal The animal to add.
     */
    public void addAnimal(Animal animal) {
        animals.add(animal);
        animal.addPropertyChangeListener(this);
    }
    
    /*
     * Prints the quantity and type of asset in this herd.
     */
    public String display() {
        String description = getSize() + " " + getType();
        return description;
    }
    
    /*
     * Handles property change events for the Subject classes being observed.
     * Adds newly born asset to births queue, and newly dead asset to
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
     * Adds asset in births queue to the herd.
     */
    private void processBirths() {
        while (!births.isEmpty()) {
            Animal baby = births.remove();
            addAnimal(baby);
        }
    }
    
    /**
     * Removes asset in deaths queue from the herd.
     */
    private void processDeaths() {
        while (!deaths.isEmpty()) {
            Animal deadAnimal = deaths.remove();
            animals.remove(deadAnimal);
        }
    }

    /**
     * Purchases new asset for the herd.
     */
    @Override
    public void upgrade(int moneySpent) {
        int newAnimals = moneySpent / costPerAnimal;
        
        if (animals.isEmpty()) {
            return;
        }
        Animal firstAnimal = animals.getFirst();
        Class<? extends Animal> animalType = firstAnimal.getClass();
        try {
            System.out.println("upgrade: " + newAnimals + " " + firstAnimal.getAnimalType()
                + " bought");
            while (newAnimals > 0) {
                Animal newAnimal = animalType.newInstance();
                addAnimal(newAnimal);
                newAnimals--;
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Sets the purchase price for the herd asset type.
     * @param cost The new price.
     */
    public void setAnimalCost(int cost) {
        costPerAnimal = cost;
    }
    
    /**
     * Removes asset killed by predation.
     */
    public void predatorKill() {
        int killCount = hazard.Predators.wolfKill(getSize());
        int index = 0;

        while (killCount > 0) {
            Animal victim = animals.get(index);
            deaths.add(victim);
            index++;
            killCount--;
        }
        processDeaths();
    }
}
