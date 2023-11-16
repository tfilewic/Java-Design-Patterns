package farms;

import animals.Herd;

public abstract class LivestockFarm extends BasicFarm {
    
    protected Herd herd = new Herd();
    
    public LivestockFarm() {
        super();
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
