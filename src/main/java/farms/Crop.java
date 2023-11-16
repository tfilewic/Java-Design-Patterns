package farms;

public class Crop implements Asset{
    private String type;
    private int size = 40;
    private int price;
    int lastHarvest = 0;
    
    Crop(String cropType, int marketPrice) {
        size = 40;
        type = cropType; 
        price = marketPrice;
    }
    
    

    
    public void addAcres(int acres) {
        size += acres;
    }
    
    @Override
    public void update(boolean isDay) {
        //TODO
    }

    @Override
    public int produce() {
        int revenue = 0;
        
        if (lastHarvest != 0 && lastHarvest % 3 == 0) {
            revenue = size * price;
            lastHarvest = 0;
        };
        
        return revenue;
    }
    
    /*
     * Gets a description of the quantity and type of animals in this herd.
     * @return the descript ion.
     */
    @Override
    public String display() {
        String description = size + "ac " + type;
        return description;
    }
        
}
