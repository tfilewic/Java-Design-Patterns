package farm;

import asset.Herd;
import asset.Sheep;

public class SheepFarm extends BasicFarm {

    Herd herd;
    
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
