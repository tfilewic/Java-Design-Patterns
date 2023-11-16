package simulation;
import java.util.Timer;
import java.util.TimerTask;

import farms.*;

/**
 * The Main class for assignment 5.
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
    
    FarmManager farmManager;
    private int cycle = 1;
    final int daysToArmageddon = 1111;              //total number of days to simulate
    private static boolean isDay = true;            //the time of day
    Timer timer = new Timer();                      //timer to run the simulation
    final int start = 2000;                         //simulation start time
    final int interval = 2000;                      //update frequency
    
    public static boolean isDay() {
        return isDay;
    }
    
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
    
    public Simulation(){
        farmManager = new FarmManager();
        
        //instantiate a single farm
        farmManager.addFarm(FarmType.DAIRY, new Farmer[] {new Farmer(), new Farmer(), new Farmer(), 
                new Farmer(), new Farmer(), new Farmer()} );
    }
    
    /**
     * Ends the simulation.
     */
    private void endSimulation() {
        System.out.println("Oh no!  Armageddon has arrived and all farms are gone.  Goodbye");
        System.exit(0);
    }
    
    /**
     * Runs the simulation.
     */
    public void simulate() {
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
     * Main method.
     * @param args The args.
     */
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.simulate();
    }
        


}
