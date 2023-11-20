package asset;

/**
 * A cow animal.
 * @author tfilewic
 *
 */
public class Cow extends Animal {
    
    /**
     * Cosntructor.
     */
    public Cow() {
        super();
        type = "cows";
        fertility = 2;
    }
    
    /**
     * Produces income for the farm.
     * @return the income produced by this cow.
     */
    @Override
    public int produce() {
        return milk();
    }

    /**
     * Gives birth to a new Cow.
     */
    @Override
    protected void giveBirth() {
        Cow calf = new Cow();
        System.out.println("calf born");
        support.firePropertyChange("birth", null, calf);
    }
    
    /**
     * Dies at the end of its natural life.
     */
    @Override
    protected void die() {
        Cow deadCow = this;
        System.out.println("cow died");
        support.firePropertyChange("death", null, deadCow);
    }   
    
    
    /**
     * Milk the cow for income.
     * @return the earnings.
     */
    private int milk() {
        final int marketPrice = 55;
        if (age > 3 && lastProduction >= 2) {
            lastProduction = 0;
            return marketPrice;
        } else {
            lastProduction++;
            return 0;
        }
    }


}
