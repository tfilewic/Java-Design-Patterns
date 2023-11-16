package farms;

import animals.Herd;
import animals.Sheep;

public class SheepFarm extends BasicFarm {

    Herd herd;
    
    public SheepFarm() {
        super();
        herd = new Herd();
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
