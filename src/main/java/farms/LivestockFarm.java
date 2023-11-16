package farms;

import animals.Herd;

/**
 * A type of farm consisting of livestock.
 * 
 * @author tfilewic
 */
public abstract class LivestockFarm extends BasicFarm {
    
    protected Herd herd;       //Contains the farm's animals

    
    public LivestockFarm() {
        super();
        herd = new Herd();
    }
    
    
    @Override
    protected void earn(){
        accountBalance += herd.produce();
    }
    
    @Override
    protected void updateAssets(boolean isDay) {
        herd.update(isDay);
    }
    
    @Override
    public String displayAssets() {
        return herd.display();
    }
    
}
