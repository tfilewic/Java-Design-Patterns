package farms;

public class VegetableFarm extends BasicFarm {

    final int vegetablePrice = 11;
    final int landPrice = 50;
    
    public VegetableFarm(){
        super();
        farmType = FarmType.VEGETABLE;
        asset = new Crop("vegetables", vegetablePrice, landPrice);
    }
    
}
