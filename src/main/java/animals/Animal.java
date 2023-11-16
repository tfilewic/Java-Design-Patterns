package animals;

import simulation.Simulation;

public abstract class Animal {
    
    //TODO observe this
    Animal offspring = null;
    
    final double fertility = 0.3;
    int age = 0;
    int lastProduction = 0;
    
    abstract int produce();
    
    abstract Animal giveBirth();
    
    public void update() {
        if (Simulation.isDay()) {
            age++;
            
            if (isPregnant())  {
                offspring = giveBirth(); 
            }   
        }
 
    }
    
    
    /**
     * TODO UNIT TEST THIS
     * @return
     */
    private boolean isPregnant() {
        boolean correctTiming = (age > 2 && (age - 2) % 4 == 0);
        boolean isLucky = false;
        
        return (correctTiming && isLucky);
        
        
    }
}
