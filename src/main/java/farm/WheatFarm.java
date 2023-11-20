package farm;

import asset.Crop;

/**
 * A farm that grows and sells wheat.
 * @author tfilewic
 *
 */
public class WheatFarm extends BasicFarm {

    private static final int grainPrice = 13;   //The amount earned per harvest acre 
    private static final int landPrice = 100;   //The cost per acre of land
    
    /**
     * Constructor.
     */
    public WheatFarm() {
        super();
        farmType = FarmType.WHEAT;
        asset = new Crop("wheat", grainPrice, landPrice);
    }
    

}
