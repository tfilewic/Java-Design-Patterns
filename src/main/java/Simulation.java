import java.util.Timer;
import java.util.TimerTask;

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
    
    
    
    int daysToArmageddon = 10;  //number of days to simulate
    boolean isDay = true;       //the time of day
    Timer timer = new Timer();  //timer to run the simulation
    final int start = 2000;     //simulation start time
    final int interval = 2000;  //update frequency
    
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
    
    
    
    /**
     * Main method.
     * @param args The args.
     */
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.simulate();
    }
        


}
