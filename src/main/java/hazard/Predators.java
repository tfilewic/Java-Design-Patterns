package hazard;


/**
 * Predators which can kill members of a herd.
 * @author tfilewic
 *
 */
public class Predators {
    
    /**
     * Gets the number of asset killed by wolves.
     * @param herdSize The size of the herd.
     * @return The number of asset killed.
     */
    public static int wolfKill(int herdSize) {
        int killedAnimals = 0;
        if (simulation.RandomNumber.get(10) < 3) {
            if (herdSize == 0) {
                killedAnimals = 0;
            } else if (herdSize < 4) {
                killedAnimals = simulation.RandomNumber.get(herdSize);
            } else {
                killedAnimals = simulation.RandomNumber.get(herdSize / 4);
            }
        }
        if (killedAnimals > 0) {
            System.out.println("wolves killed " + killedAnimals + " animals"); 
        }
        return killedAnimals;
    }
    
}
