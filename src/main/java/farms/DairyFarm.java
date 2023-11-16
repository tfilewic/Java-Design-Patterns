package farms;

import animals.Cow;
import animals.Herd;

public class DairyFarm extends BasicFarm{
    
    Herd herd;
    
    public DairyFarm() {
        super();
        herd = new Herd();
        asset = herd;
        farmType = FarmType.DAIRY;
        final int minimumSize = 10;
        int count = 0;
        while (count < minimumSize) {
            herd.addAnimal(new Cow());
            count++;
        }
    }



}
