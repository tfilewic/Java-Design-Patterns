package animals;


public class Cow extends Animal{
    
    public Cow() {
        super();
        type = "cows";
    }
    
    @Override
    public int produce() {
        return milk();
    }

    @Override
    void giveBirth() {
        Cow calf = new Cow();
        System.out.println("calf born");
        support.firePropertyChange("birth", null, calf);
    }
    
    @Override
    void die() {
        Cow deadCow = this;
        System.out.println("cow died");
        support.firePropertyChange("death", null, deadCow);
    }   
    
    
    /**
     * Milk the cow for income.
     * @return the earnings.
     */
    private int milk() {

        if (age > 3 && lastProduction >= 2) {
            lastProduction = 0;
            return 17;
        } else {
            lastProduction++;
            return 0;
        }
    }


}
