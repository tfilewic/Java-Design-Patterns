package animals;

import java.util.ArrayList;

import animals.Animal;


/**
 * Manages the animals on a farm
 * @author tfilewic
 */
public class Herd {
    
    //implements observer to add new animals when born
    
    ArrayList<Animal> animals = new ArrayList<Animal>();
    
    
    public int produce() {
        int revenue = 0;
        for (Animal animal : animals) {
            revenue += animal.produce();
        }
        return revenue;
    }
   
    
}
