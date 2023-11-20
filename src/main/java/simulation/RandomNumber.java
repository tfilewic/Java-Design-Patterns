package simulation;

import java.util.Random;

/**
 * Random number generator.
 * @author tfilewic
 *
 */
public class RandomNumber {
    private static Random random = new Random();
    
    public static int get(int upperBound) {
        return random.nextInt(upperBound);
    }
    
    
}

