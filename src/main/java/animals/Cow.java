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
    Animal giveBirth() {
        // TODO Auto-generated method stub
        return null;
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
