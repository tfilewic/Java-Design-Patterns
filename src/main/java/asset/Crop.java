package asset;

/**
 * A type of asset containing crops that are grown and harvested.
 * @author tfilewic
 *
 */
public class Crop implements Asset{
    private String type;
    private int size = 40;
    private int marketPrice;
    private int costPerAcre;
    private int lastHarvest = 0;
    
    public Crop(String cropType, int marketPrice, int costPerAcre) {
        size = 40;
        type = cropType; 
        this.marketPrice = marketPrice;
        this.costPerAcre = costPerAcre;
    }
    
    public void addAcres(int acres) {
        size += acres;
    }
    
    @Override
    public void update(boolean isDay) {
        if (! isDay) {
            weatherDamage();

        }
    }

    @Override
    public int produce() {
        int revenue = 0;
        
        if (lastHarvest != 0 && lastHarvest % 3 == 0) {
            revenue = size * marketPrice;
            lastHarvest = 0;
        } else {
            lastHarvest++;   
        }
        return revenue;
    }
    
    /*
     * Gets a description of the quantity and type of asset in this herd.
     * @return the descript ion.
     */
    @Override
    public String display() {
        String description = size + "ac " + type;
        return description;
    }

    /**
     * Purchases extra land as an upgrade.
     * @param moneySpent The amount spent on the upgrade.
     */
    @Override
    public void upgrade(int moneySpent) {
        int addedAcres = moneySpent/costPerAcre;
        System.out.println("upgrade: " + addedAcres + " ac " + type + " bought");
        size += addedAcres;
    }
    
    /**
     * Removes crops destroyed by weather events.
     */
    private void weatherDamage() {
        int destroyedCrops = hazard.BadWeather.flood(size);
        size-= destroyedCrops;
    }
        
}
