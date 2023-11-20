package simulation;

import farm.FarmManager;
import farm.FarmType;

import java.util.Timer;
import java.util.TimerTask;


/**
 * The Main class for assignment 5.
 * Runs a farm simulation.
 * @author tfilewic
 */
public class Simulation {
    
    FarmManager farmManager;                //manages the farm
    private int cycle = 1;                  //the starting cycle number
    final int daysToArmageddon;             //number of cycles to run
    private static boolean isDay = true;    //the time of day
    Timer timer = new Timer();              //timer to run the simulation tasks
    int start;                              //simulation start time in milliseconds
    int interval;                           //update frequency in milliseconds
    

    /**
     * Default constructor.
     */
    public Simulation() {

        farmManager = new FarmManager();
        daysToArmageddon = 100;
        timer = new Timer();
        start = 2000; 
        interval = 2000;
        
        //instantiate and add initial farm
        farmManager.addNewFarm(FarmType.DAIRY);
        farmManager.addNewFarm(FarmType.SHEEP);
        farmManager.addNewFarm(FarmType.WHEAT);
        farmManager.addNewFarm(FarmType.CORN);
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
        
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                displayCycle();
                farmManager.updateFarms(isDay);
                
                if (!isDay) {
                    cycle++; //advance the simulation one cycle
                    }
                if (cycle >= daysToArmageddon) {
                    endSimulation();
                    }
                isDay = !isDay; //alternate day and night
                }
            }, start, interval);
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
