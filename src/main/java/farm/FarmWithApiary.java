package farm;

/**
 * A wrapped Farm with added beehive earnings.
 * A "Concrete Decorator" in the Decorator pattern.
 * @author tfilewic
 *
 */
public class FarmWithApiary extends FarmDecorator {

    private int lastHarvest = 0; //days since the honey was last harvested
    private static final int frequency = 28; //how often the honey can be harvested
    private static final int rate = 50; //the income generated per harvest
    
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
