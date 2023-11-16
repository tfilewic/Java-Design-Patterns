package farms;

import animals.Herd;

public abstract class LivestockFarm extends BasicFarm {
    
    protected Herd herd = new Herd();
    
    @Override
    protected void earn(){
        accountBalance += herd.produce();
    }
}
