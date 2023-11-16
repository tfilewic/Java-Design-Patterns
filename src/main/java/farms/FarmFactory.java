package farms;


/**
 * Interface to create Farm objects.
 * The "Creator" for the Factory pattern.
 * @author tfilewic
 */
public interface FarmFactory {
   
    /**
     * Creates a Farm object of the specified type.
     * The FactoryMethod of the Factory pattern.
     * @param type The type of Farm to create.
     * @return the Farm object.
     */
    public Farm createFarm(FarmType type);
    
}
