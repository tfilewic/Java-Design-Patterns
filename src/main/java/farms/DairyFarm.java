package farms;

import animals.Cow;

public class DairyFarm extends LivestockFarm{
    
    public DairyFarm() {
        super();
        farmType = FarmType.DAIRY;
        final int minimumSize = 10;
        int count = 0;
        while (count < minimumSize) {
            herd.addAnimal(new Cow());
            count++;
        }
    }


}
