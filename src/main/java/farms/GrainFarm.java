package farms;

public class GrainFarm extends BasicFarm{

    Crop crop;
    final int grainPrice = 5;
    final int landPrice = 25;
    
    
    public GrainFarm(){
        super();
        farmType = FarmType.GRAIN;
        asset = new Crop("wheat", grainPrice, landPrice);
    }
    

}
