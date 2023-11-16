package farms;

import animals.Sheep;

public class SheepFarm extends LivestockFarm {

    
    public SheepFarm() {
        super();
        farmType = FarmType.SHEEP;
        int minimumSize = 18;
        int count = 0;
        while (count < minimumSize) {
            herd.addAnimal(new Sheep());
            count++;
        }
    }


}
