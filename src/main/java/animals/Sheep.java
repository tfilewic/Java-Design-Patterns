package animals;

import simulation.Simulation;

public class Sheep extends Animal {

    @Override
    public void update() {
        if (Simulation.isDay()) {
            age++;
        }  
        if (true /*TODO birth conditions */) {
            offspring = giveBirth(); 
        }
        
    }
    
    /**
     * Milk the cow for income.
     * @return the earnings.
     */
    private int shear() {
        if (age > 3 && lastProduction >= 2) {
            return 17;
        } else {
            return 0;
        }
    }

    @Override
    Animal giveBirth() {
        return new Sheep();
    }

    @Override
    public int produce() {
        return shear();
    }

}
