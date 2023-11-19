 package hazard;

import java.util.Random;

/**
 * Predators which can kill members of a herd.
 * @author tfilewic
 *
 */
public class Predators {
    
    private static final Random random = new Random();
    
    /**
     * Gets the number of asset killed by wolves.
     * @param herdSize The size of the herd.
     * @return The number of asset killed.
     */
    public static int wolfKill(int herdSize) {
        int killedAnimals = 0;
        if (random.nextInt(10) < 3) {
            if (herdSize == 0) {
                killedAnimals = 0;
            } else if (herdSize < 4) {
                killedAnimals = random.nextInt(herdSize);
            } else {
                killedAnimals = random.nextInt(herdSize / 4);
            }
        }
        if (killedAnimals > 0) {
            System.out.println("wolves killed " + killedAnimals + " animals"); 
        }
        return killedAnimals;
    }
    
}
