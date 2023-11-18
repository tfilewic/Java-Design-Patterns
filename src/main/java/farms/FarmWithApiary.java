package farms;

public class FarmWithApiary extends FarmDecorator{

    int lastHarvest = 0;
    final int frequency = 30;
    final int rate = 100;
    
    public FarmWithApiary(Farm farmToDecorate) {
        super(farmToDecorate);
    }

    @Override
    protected void doExtra(boolean isDay) {
        if (isDay) {
            if (lastHarvest >= frequency) {
                
            }
            else {
                lastHarvest++;
            }
        }
    }

}
