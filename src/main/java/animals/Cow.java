package animals;

public class Cow extends Animal{
    
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
    
    /**
     * 
     * @return
     */
    public int sell() {
        return 244;
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        
    }

    @Override
    Animal giveBirth() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int produce() {
        return milk();
    }
}
