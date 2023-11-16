package farms;


import java.util.LinkedList;

import simulation.Farmer;

/**
 * 
 * @author z
 *
 */
public abstract class BasicFarm implements Farm {
                                                
    protected int id = -1;
    protected FarmType farmType;
    protected int age = 0;
    protected int accountBalance = 0;
    protected int farmerCount = 0;
    protected boolean isFull;                //TODO implement branching when farm is full  OBSERVER subject
    protected LinkedList<Farmer> farmers = new LinkedList<Farmer>();
    
    protected abstract void earn();
    
    protected abstract void updateAssets(boolean isDay);
    
    protected abstract String displayAssets();
    
    public BasicFarm() {
        age = 0;
        accountBalance = 0;
        farmerCount = 0;
        farmers = new LinkedList<Farmer>();
    }
    
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
        updateAssets(isDay);
        display();
    }
    
    @Override
    public void addFarmer(Farmer farmer) {
        farmers.add(farmer);
        farmerCount++;
    }
    
    @Override
    public void setId(int newId){
        if (id == -1) {
            id = newId;
        }
    }
    
    public void display() {
        //TODO
        System.out.println(" ID -- Type -- Age -- Balance -- Farmers -- Assets");
        System.out.println("  " + id + "    " + farmType +  "    " + age + "       " +
        accountBalance + "          " + farmerCount + "        "  + displayAssets() + "\n");
    }
    
    /**
     * Hires a a new farmer every 10 days
     */
    protected void hire() {
        final int hiringFrequency = 2;   //TODO fix this to 10
        if (age % hiringFrequency == 0 && age > 0) {
            System.out.println("farmer hired");
            addFarmer(new Farmer());
        }
    }
    

    
    
}
