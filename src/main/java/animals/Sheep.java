package animals;

public class Sheep extends Animal {

    public Sheep() {
        super();
        type = "sheep";
        fertility = 4;
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
        final int marketPrice = 5;
        if (age > 3 && lastProduction >= 2) {
            lastProduction = 0;
            return marketPrice;
        } else {
            lastProduction++;
            return 0;
        }
    }
}
