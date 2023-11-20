package farm;

/**
 * A wrapped Farm with added beehive earnings.
 * @author tfilewic
 *
 */
public class FarmWithApiary extends FarmDecorator {

    int lastHarvest = 0;
    final int frequency = 28;
    final int rate = 50;
    
    /**
     * Constructor.
     * @param farmToDecorate The farm to decorate.
     */
    public FarmWithApiary(Farm farmToDecorate) {
        super(farmToDecorate);
    }

    /**
     * Adds additional earnings from beehives.
     * @param isDay If it is daytime in the current cycle.
     */
    @Override
    protected void doExtra(boolean isDay) {
        if (isDay) {
            if (lastHarvest >= frequency) {
                earn(rate);
                System.out.println("Earned extra $" + rate + " from beehives");
                lastHarvest = 0;
            } else {
                lastHarvest++;
            }
        }
    }



}
