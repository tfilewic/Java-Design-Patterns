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
        id = ++lastId;
    }
    
    /**
     * Gets this farmer's id.
     * @return the id.
     */
    public int getId() {
        return id;
    }
}
