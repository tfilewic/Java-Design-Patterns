package animals;

import java.util.LinkedList;



/**
 * Manages the animals on a farm
 * @author tfilewic
 */
public class Herd {
    
    //implements observer to add new animals when born
    
    private LinkedList<Animal> animals;
    
    
    public Herd() {
        animals = new LinkedList<Animal>();
        System.out.println("herd created with size" + getSize()); 
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
            type = animals.getFirst().getAnimalType();
        }
        return type;
    }
   
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public String display() {
        String description = getSize() + " " + getType();
        return description;
    }
    
}
