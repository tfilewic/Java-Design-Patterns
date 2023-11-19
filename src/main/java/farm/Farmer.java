package farm;
/**
 * A farmer
 * @author tfilewic
 *
 */
public class Farmer {
    private static int lastId = 0;
    private int id;
    
    public Farmer() {
        id = ++lastId;
    }
    public int getId() {
        return id;
    }
}
