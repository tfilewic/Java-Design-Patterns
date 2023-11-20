package farm;

import asset.Asset;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.LinkedList;
import java.util.Queue;



/**
 * A basic farm.
 * The "Subject" of the Observer pattern.
 * Superclass of the "Concrete Components" of the Decorator pattern. 
 * @author tfilewic
 *
 */
public abstract class BasicFarm implements Farm {

    protected int id = -1;
    //the type of farm
    protected FarmType farmType; 
    //the current cycle of the farm
    protected int age = 0;
    //the amount of money the farm has
    protected int accountBalance;
    //the number of farmers after which farmers leave to start a new branch
    protected static final int maxFarmers = 9;
    //the collection of farmers working the farm
    protected Queue<Farmer> farmers;
    //instance to support the Observer pattern
    protected PropertyChangeSupport support;    
    //the farm's money earning asset
    protected Asset asset;                      
    //the cost of a standard upgrade
    protected static final int upgradeCost = 1000;     
    //the balance at which a farm will purchase an upgrade
    protected static final int upgradeThreshold = upgradeCost + 200;
    
    
    /**
     * Constructor.
     */
    public BasicFarm() {
        age = 0;
        accountBalance = 200;
        farmers = new LinkedList<Farmer>();
        support = new PropertyChangeSupport(this);
    }
    
    /**
     * Updates the status by one half cycle.
     */
    @Override
    public boolean update(boolean isDay) {
        if (!isDay) {
            payTax();
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
    
    /**
     * Purchases an upgrade if the farm has sufficient funds.
     */
    protected void upgrade() {
        int upgradesAvailable = accountBalance / upgradeThreshold;
        if (accountBalance > upgradeThreshold) {
            int moneySpent = upgradesAvailable * upgradeCost;
            asset.upgrade(moneySpent);
            accountBalance -= moneySpent;
        }
    }

    /**
     * Prints the current state of this farm.
     */
    public void display() {
        System.out.println(" ID -- Type -- Age -- Balance -- Farmers -- Assets");
        System.out.print("  " + id + "    ");
        System.out.printf("%-5s     ", ("" + farmType));
        System.out.print(age + "     ");
        System.out.printf("$%-4s        ", ("" + accountBalance));
        System.out.println(getFarmerCount() + "       "  + asset.display() + "\n");
    }
    
    /**
     * Deposits the current day's income from assets into the account.
     */
    public void earn() {
        accountBalance += asset.produce();
    }
    
    /**
     * Deposits the specified amount in the account.
     * @param amount The amount to deposit.
     */
    @Override
    public void earn(int amount) {
        accountBalance += amount;
    }
    
    /**
     * Pays taxes from the account.
     */
    public void payTax() {
        accountBalance = accountBalance * 95 / 100 - 25;
    }
    
    /**
     * Adds a farmer to the farm.
     * @param farmer The Farmer to add.
     */
    public void addFarmer(Farmer farmer) { 
        farmers.add(farmer);
    }
    
    /**
     * Sets the farm's id.
     * @param newId  The id to set.
     */
    public void setId(int newId) {
        if (id == -1) {
            id = newId;
        }
    }    
    
    /**
     * Hires a a new farmer every 10 days.
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
     * Gets the number of farmers working this farm.
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
