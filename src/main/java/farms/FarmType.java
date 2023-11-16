package farms;

import java.util.Random;

/**
 * Enumeration for the types of farms;
 * @author tfilewic
 *
 */
public enum FarmType {
    GRAIN,
    VEGETABLE,
    DAIRY,
    SHEEP;
    
    private static final FarmType[] VALUES = values();
    private static final Random RANDOM = new Random();
    private static final int SIZE = VALUES.length;
    
    /**
     * Get a random FarmType.
     * @return a random FarmType.
     */
    public static FarmType getRandom() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
}
