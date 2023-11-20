package farm;

/**
 * A wrapped Farm with added farmers market sales.
 * A "Concrete Decorator" in the Decorator pattern.
 * @author tfilewic
 *
 */
public class FarmWithMarket extends FarmDecorator {

    private int lastMarket = 0; //days since the market was last held
    private static final int frequency = 7; //how often the market is held
    private static final int sales = 35; //income generated from the market
    
    /**
     * Constructor.
     * @param farmToDecorate The farm to be wrapped.
     */
    public FarmWithMarket(Farm farmToDecorate) {
        super(farmToDecorate);
    }
    
    /**
     * Adds additional earnings from farmers market sales.
     */
    @Override
    protected void doExtra(boolean isDay) {
        if (isDay) {
            if (lastMarket >= frequency) {
                System.out.println("Earned extra $" + sales + " from selling at a farmers' market");
                earn(sales);
                lastMarket = 0;
            } else {
                lastMarket++;
            }
        }
    }

}
