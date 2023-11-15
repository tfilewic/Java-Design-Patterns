

import java.util.LinkedList;


public abstract class BasicFarm implements Farm {
    
    String farmType;
    int age = 0;
    int accountBalance;
    int acreage = 160;
    LinkedList<Farmer> farmers = new LinkedList<Farmer>();
    
    
    @Override
    public void tick(boolean isDay){
        if (!isDay) {
            //TODO predators and disease
        }
        if (isDay) {
            earn();
            hire();
            age++;
        }
        display();
    }
    
    @Override
    public void addFarmer(Farmer farmer) {
        farmers.add(farmer);
    }
    
    @Override
    public abstract void earn();
    

    
    private void display() {
        //TODO
        // print farm type
        // account balance
        // farmers
        // size
        // assets?
    }
    
    /**
     * Hires a a new farmer every 10 days
     */
    protected void hire() {
        final int hiringFrequency = 10;
        if (age % hiringFrequency == 0) {
            farmers.add(new Farmer());
        }
    }
    
    
}
