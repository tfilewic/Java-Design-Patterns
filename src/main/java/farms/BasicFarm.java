package farms;


import java.util.LinkedList;

import simulation.Farmer;


public abstract class BasicFarm implements Farm {
    
    int id = -1;
    String farmType;
    int age = 0;
    int accountBalance = 0;
    int acreage = 160;
    int farmerCount = 0;
    LinkedList<Farmer> farmers = new LinkedList<Farmer>();
    
    protected abstract void earn();
    
    @Override
    public void update(boolean isDay){
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
        farmerCount = farmers.size();
    }
    
    @Override
    public void setId(int newId){
        if (id == -1) {
            id = newId;
        }
    }
    
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
