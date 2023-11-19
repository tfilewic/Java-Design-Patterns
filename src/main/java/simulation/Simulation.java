package simulation;
import java.util.Timer;
import java.util.TimerTask;

import farm.*;


/**
 * The Main class for assignment 5.
 * Runs a farm simulation.
 * @author tfilewic
 */
public class Simulation {
    
    
    //TODO delete temporary stuff
    // Temporary attribute to set up basic testing.
    public boolean oldMacDonaldHadAFarm = false;
    
    /**
     * Temporary method to set up basic testing.
     * Sets oldMacDonaldHadAFarm to true.
     */
    public void haveAFarm() {
        oldMacDonaldHadAFarm = true;
        System.out.println("E-I-E-I-O");
    }
    
    
    
    
    FarmManager farmManager;                //manages the farm
    private int cycle = 1;                  //the starting cycle number
    final int daysToArmageddon;             //total number of days to simulate
    private static boolean isDay = true;    //the time of day
    Timer timer = new Timer();              //timer to run the simulation
    int start;                              //simulation start time in milliseconds
    int interval;                           //update frequency in milliseconds
    

    
    /**
     * Default constructor.
     */
    public Simulation(){

        farmManager = new FarmManager();
        daysToArmageddon = 100;
        timer = new Timer();
        start = 2000; 
        interval = 2000;
        
        //instantiate and add initial farm
        FarmFactory factory = farmManager.getFactory();
        Farm newFarm = factory.createFarm(FarmType.DAIRY);
        farmManager.addFarm(newFarm);
        newFarm = factory.createFarm(FarmType.SHEEP);
        farmManager.addFarm(newFarm);
        newFarm = factory.createFarm(FarmType.WHEAT);
        farmManager.addFarm(newFarm);
        newFarm = factory.createFarm(FarmType.CORN);
        farmManager.addFarm(newFarm);
    }
    
    /**
     * Ends the simulation.
     */
    private void endSimulation() {
        System.out.println("Oh no!  Armageddon has arrived and all farm are gone.  Goodbye");
        System.exit(0);
    }
    
    /**
     * Runs the simulation.
     */
    public void simulate() {
        
        FarmFactory factory = farmManager.getFactory();
        
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                displayCycle();
                farmManager.updateFarms(isDay);
                //advance the simulation one day
                if (!isDay) {
                    cycle++;
                    }
                if (cycle >= daysToArmageddon) {
                    endSimulation();
                    }
                //advance the time 12hrs
                isDay = !isDay;
                }
            }, start, interval);
        }
    
    /**
     * 
     * @return if it is daytime in the current cycle.
     */
    public static boolean isDay() {
        return isDay;
    }
    
    
    /**
     * Prints a header for the current cycle.
     */
    private void displayCycle() {
        String header = "                 CYCLE " + cycle + "  ";
        if (isDay) {
            header += "DAY";
        } else {
            header += "NIGHT";
        }
        System.out.println("\n\n====================================================");
        System.out.println(header);
        System.out.println("====================================================\n");
    }
    
    
    /**
     * Main method.
     * @param args The args.
     */
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.simulate();
    }
        


}
