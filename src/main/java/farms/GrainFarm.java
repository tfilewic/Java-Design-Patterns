package farms;

import animals.Herd;

public class GrainFarm extends BasicFarm{

    Crop crop;
    
    public GrainFarm(){
        super();
        asset = new Crop("grain", 40);
    }
    

}
