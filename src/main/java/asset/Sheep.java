package asset;

/**
 * A sheep animal.
 * @author tfilewic
 *
 */
public class Sheep extends Animal {

    /**
     * Constructor.
     */
    public Sheep() {
        super();
        type = "sheep";
        fertility = 3;
    }

    /**
     * Gives birth to a new Sheep.
     */
    @Override
    protected void giveBirth() {
        Sheep lamb = new Sheep();
        System.out.println("lamb born");
        support.firePropertyChange("birth", null, lamb);
    }
    
    /**
     * Dies at the end of its natural life.
     */
    @Override
    protected void die() {
        Sheep deadSheep = this;
        System.out.println("sheep died");
        support.firePropertyChange("death", null, deadSheep);
    }  

    /**
     * Produces income for the farm.
     * @return the income produced by this sheep.
     */
    @Override
    public int produce() {
        return shear();
    }

    /**
     * Shear the sheep for income.
     * @return the earnings.
     */
    private int shear() {
        final int marketPrice = 26;
        if (age > 3 && lastProduction >= 2) {
            lastProduction = 0;
            return marketPrice;
        } else {
            lastProduction++;
            return 0;
        }
    }
}
