package farms;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.LinkedList;
import java.util.Queue;

import simulation.Farmer;

/**
 * A simple farm.
 * @author tfilewic
 *
 */
public abstract class BasicFarm implements Farm {

    protected int id = -1;
    protected FarmType farmType;
    protected int age = 0;
    protected int accountBalance = 0;
    protected final int maxFarmers = 9;
    protected Queue<Farmer> farmers;
    protected PropertyChangeSupport support;  //Instance to support the Observer pattern
    protected Asset asset;
    
    public BasicFarm() {
        age = 0;
        accountBalance = 0;
        farmers = new LinkedList<Farmer>();
        support = new PropertyChangeSupport(this);
    }
    
    @Override
    public void update(boolean isDay){
        if (!isDay) {
            //TODO predators and disease
        }
        if (isDay) {
            earn();
            branch();
            hire();
            age++;
        }
        asset.update(isDay);
        display();
    }
    
    
    @Override
    public void earn() {
        accountBalance += asset.produce();
    }
    
    
    
    @Override
    public void addFarmer(Farmer farmer) {
        farmers.add(farmer);
    }
    
    @Override
    public void setId(int newId){
        if (id == -1) {
            id = newId;
        }
    }
    
    /**
     * Prints the current state of this farm.
     */
    public void display() {
        //TODO
        System.out.println(" ID -- Type -- Age -- Balance -- Farmers -- Assets");
        System.out.println("  " + id + "    " + farmType +  "    " + age + "      $" +
        accountBalance + "        " + getFarmerCount() + "        "  + asset.display() + "\n");
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
