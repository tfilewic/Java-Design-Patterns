package farms;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.LinkedList;
import java.util.Queue;

import simulation.Farmer;

/**
 * A basic farm.
 * @author tfilewic
 *
 */
public abstract class BasicFarm implements Farm {

    protected int id = -1;
    protected FarmType farmType;
    protected int age = 0;
    protected int accountBalance;
    protected final int maxFarmers = 9;
    protected Queue<Farmer> farmers;
    protected PropertyChangeSupport support;  //Instance to support the Observer pattern
    protected Asset asset;
    protected final int upgradeCost = 1000;
    protected final int upgradeThreshold = upgradeCost + 200;
    
    public BasicFarm() {
        age = 0;
        accountBalance = 200;
        farmers = new LinkedList<Farmer>();
        support = new PropertyChangeSupport(this);
    }
    
    @Override
    public boolean update(boolean isDay){
        if (!isDay) {
            //TODO predators and disease
            //payTax();
            
            if (accountBalance <= 0) {
                return true;
            }
        }
        if (isDay) {
            upgrade();
            earn();
            branch();
            hire();
            age++;
        }
        asset.update(isDay);
        return false;
    }
    
    protected void upgrade () {
        int upgradesAvailable = accountBalance / upgradeThreshold;
        if (accountBalance > upgradeThreshold) {
            int moneySpent = upgradesAvailable * upgradeCost;
            asset.upgrade(moneySpent);
            accountBalance -= moneySpent;
        }
    };

    /**
     * Prints the current state of this farm.
     */
    public void display() {
        //TODO
        System.out.println(" ID -- Type -- Age -- Balance -- Farmers -- Assets");
        System.out.println("  " + id + "    " + farmType +  "    " + age + "      $" +
        accountBalance + "        " + getFarmerCount() + "        "  + asset.display() + "\n");
    }
    
    public void earn() {
        accountBalance += asset.produce();
    }
    
    public void earn(int amount) {
        accountBalance += amount;
    }
    
    public void payTax() {
        accountBalance = accountBalance * 9 / 10 - 10 ;
    }
    
    public void addFarmer(Farmer farmer) { 
        farmers.add(farmer);
    }
    
 
    public void setId(int newId){
        if (id == -1) {
            id = newId;
        }
    }
    
    
    /**
     * Hires a a new farmer every 10 days
     */
    protected void hire() {
        final int hiringFrequency = 10;
        if (age % hiringFrequency == 0 && age > 0) {
            System.out.println("farmer hired");
            addFarmer(new Farmer());
        }
    }
    
    /**
     * Notifies Observers if the number of farmers exceeds that maximum and removes 
     * three farmers to start their own farm.
     */
    protected void branch() {
        boolean isFull = getFarmerCount() > maxFarmers;
        if (isFull) {
            //remove farmers
            Farmer[] departingFarmers = new Farmer[3];
            for (int i = 0; i < departingFarmers.length; i++) {
                departingFarmers[i] = farmers.remove();
            }
            support.firePropertyChange("branch", null, departingFarmers);
        }
    }
    
    /**
     * Gets the number of farmers working this farm
     * @return the number of farmers.
     */
    protected int getFarmerCount() {
        return farmers.size();
    }
    
    /**
     * Adds a PropertyChangeListener to this PropertyChangeSupport.
     * @param listener The "Observer" of the Observer pattern.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Removes a PropertyChangeListener to this PropertyChangeSupport.
     * @param listener The "Observer" of the Observer pattern.
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
    

    
    
}
