package farm;

public class FarmWithApiary extends FarmDecorator{

    int lastHarvest = 0;
    final int frequency = 28;
    final int rate = 50;
    
    public FarmWithApiary(Farm farmToDecorate) {
        super(farmToDecorate);
    }

    @Override
    protected void doExtra(boolean isDay) {
        if (isDay) {
            if (lastHarvest >= frequency) {
                earn(rate);
                System.out.println("Earned extra $" + rate + " from beehives");
                lastHarvest = 0;
            }
            else {
                lastHarvest++;
            }
        }
    }



}
