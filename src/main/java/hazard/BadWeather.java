package hazard;

import java.util.Random;

/**
 * Weather functions that can destroy crops.
 * @author tfilewic
 *
 */
public class BadWeather {

    private static final Random random = new Random();
    
    /**
     * Calculates the size of crops destroyed by flooding.
     * @param cropSize The total size of the crop affected.
     * @return The size destroyed.
     */
    public static int flood(int cropSize) {
        int destroyedCrops = 0;
        if (random.nextInt(30) == 7) {
            destroyedCrops = random.nextInt(cropSize);
        }
        if (destroyedCrops > 0) {
            System.out.println("flooding destroyed " + destroyedCrops + "ac");
        }
        return destroyedCrops;
    }
}
