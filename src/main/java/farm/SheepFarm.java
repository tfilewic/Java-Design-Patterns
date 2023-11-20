package farm;

import asset.Herd;
import asset.Sheep;

/**
 * A farm that raises sheep for wool.
 * A "Concrete Product" in the Factory pattern.
 * @author tfilewic
 *
 */
public class SheepFarm extends BasicFarm {

    Herd herd;
    
    /**
     * Constructor.
     */
    public SheepFarm() {
        super();
        herd = new Herd();
        herd.setAnimalCost(100);
        asset = herd;
        farmType = FarmType.SHEEP;
        final int minimumSize = 18;
        int count = 0;
        while (count < minimumSize) {
            herd.addAnimal(new Sheep());
            count++;
        }
    }


}
