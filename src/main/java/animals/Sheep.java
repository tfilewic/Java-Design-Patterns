package animals;

public class Sheep extends Animal {

    public Sheep() {
        super();
        type = "sheep";
    }

    @Override
    Animal giveBirth() {
        return new Sheep();
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
