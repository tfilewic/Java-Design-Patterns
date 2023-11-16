package simulation;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import farms.Farm;

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
    
    
    private ArrayList<Farm> farms = new ArrayList<Farm>();  //the list of farms
    int daysToArmageddon = 10;                              //total number of days to simulate
    private static boolean isDay = true;                    //the time of day
    Timer timer = new Timer();                              //timer to run the simulation
    final int start = 2000;                                 //simulation start time
    final int interval = 2000;                              //update frequency
    
    public static boolean isDay() {
        return isDay;
    }
    
    public Simulation(){
        //instantiate Farm and add to farms
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
                
              //TODO update everything
              System.out.println("we be farmin");
              
              
              
              
              //advance the simulation one day
              if (isDay) {
                  daysToArmageddon--;
              }
              if (daysToArmageddon == 0) {
                  endSimulation();
              }
              
              //advance the time 12hrs
              isDay = !isDay;
            }
          }, start, interval); 
    }
    
    public void addFarm(Farm farm) {
        farms.add(farm);
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
