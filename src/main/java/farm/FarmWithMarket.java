package farm;

/**
 * A wrapped Farm with added farmers market sales.
 * @author tfilewic
 *
 */
public class FarmWithMarket extends FarmDecorator {

    int lastMarket = 0;
    final int frequency = 7;
    final int sales = 35;
    
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
