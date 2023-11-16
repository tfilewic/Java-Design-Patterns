package animals;

import java.util.Random;


public abstract class Animal {
    
    //TODO observe this
    Animal offspring = null;
    protected String type = "";
    final int fertility;
    int age = 0;
    int lastProduction = 0;
    
    protected Animal() {
        fertility = 3;
    }
    
    abstract int produce();
    
    abstract Animal giveBirth();
    
    public void update(boolean isDay) {
        if (isDay) {
            age++;
            if (isPregnant())  {
                System.out.println("NEW BAWBABY");
                offspring = giveBirth(); 
            }  
        } else {
            //do bad things
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
}
