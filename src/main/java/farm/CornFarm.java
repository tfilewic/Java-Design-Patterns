package farm;

import asset.Crop;

/**
 * A farm that grows and sells corn.
 * @author tfilewic
 *
 */
public class CornFarm extends BasicFarm {

    final int cornPrice = 10;  //The amount earned per harvest acre 
    final int landPrice = 50;       //The cost per acre of land
    
    /**
     * Constructor
     */
    public CornFarm(){
        super();
        farmType = FarmType.CORN;
        asset = new Crop("corn", cornPrice, landPrice);
    }
    
}
