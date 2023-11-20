package farm;

/**
 * A farmer.
 * @author tfilewic
 *
 */
public class Farmer {
    
    private static int lastId = 0;
    private int id;
    
    /**
     * Constructor.
     */
    public Farmer() {
        id = getNextId();
    }
    
    /**
     * Gets this farmer's id.
     * @return the id.
     */
    public int getId() {
        return id;
    }
    
    /**
     * Gets the next available unique id.
     * @return the id.
     */
    private static int getNextId() {
        return ++lastId;
    }
}
