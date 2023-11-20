package hazard;

/**
 * Weather functions that can destroy crops.
 * @author tfilewic
 *
 */
public class BadWeather {
    
    /**
     * Calculates the size of crops destroyed by flooding.
     * @param cropSize The total size of the crop affected.
     * @return The size destroyed.
     */
    public static int flood(int cropSize) {
        int destroyedCrops = 0;
        if (simulation.RandomNumber.get(30) == 7) {
            destroyedCrops = simulation.RandomNumber.get(cropSize);
        }
        if (destroyedCrops > 0) {
            System.out.println("flooding destroyed " + destroyedCrops + "ac");
        }
        return destroyedCrops;
    }
}
