package animals;

public class Sheep extends Animal {

    public Sheep() {
        super();
        type = "sheep";
    }

    @Override
    void giveBirth() {
        Sheep lamb = new Sheep();
        System.out.println("lamb born");
        support.firePropertyChange("birth", null, lamb);
    }
    
    @Override
    void die() {
        Sheep deadSheep = this;
        System.out.println("sheep died");
        support.firePropertyChange("death", null, deadSheep);
    }  

    @Override
    public int produce() {
        return shear();
    }

    /**
     * Shear the sheep for income.
     * @return the earnings.
     */
    private int shear() {
        if (age > 3 && lastProduction >= 2) {
            return 17;
        } else {
            return 0;
        }
    }
}
