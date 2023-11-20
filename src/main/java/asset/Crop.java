package asset;

/**
 * A type of asset containing crops that are grown and harvested.
 * @author tfilewic
 *
 */
public class Crop implements Asset {
    private String type;
    private int size = 40;
    private int marketPrice;
    private int costPerAcre;
    private int lastHarvest = 0;
    
    /**
     * Constructor.
     * @param cropType The cropType.
     * @param marketPrice The price per acre the crop generates.
     * @param costPerAcre The cost to purchase each additional acre.
     */
    public Crop(String cropType, int marketPrice, int costPerAcre) {
        size = 40;
        type = cropType; 
        this.marketPrice = marketPrice;
        this.costPerAcre = costPerAcre;
    }
    
    /**
     * Increases the crop's size.
     * @param acres The amount to increase.
     */
    public void addAcres(int acres) {
        size += acres;
    }
    
    /**
     * Updates the crop state by half a cycle.
     */
    @Override
    public void update(boolean isDay) {
        if (! isDay) {
            weatherDamage();
        }
    }

    /**
     * Earns income for the farm.
     */
    @Override
    public int produce() {
        int revenue = 0;
        
        if (lastHarvest != 0 && lastHarvest >= 3) {
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
        int addedAcres = moneySpent / costPerAcre;
        System.out.println("upgrade: " + addedAcres + " ac " + type + " bought");
        size += addedAcres;
    }
    
    /**
     * Removes crops destroyed by weather events.
     */
    private void weatherDamage() {
        int destroyedCrops = hazard.BadWeather.flood(size);
        size -= destroyedCrops;
    }

        
}
