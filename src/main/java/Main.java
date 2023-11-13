/**
 * The Main class for assignment 5.
 * @author tfilewic
 */
public class Main {
    
    // Temporary attribute to set up basic testing.
    public boolean oldMacDonaldHadAFarm = false;
    
    /**
     * Temporary method to set up basic testing.
     * Sets oldMacDonaldHadAFarm to true.
     */
    public void haveAFarm() {
        oldMacDonaldHadAFarm = true;
        System.out.println("E-I-E-I-O");
    }
    
    /**
     * Main method.
     * @param args The args.
     */
    public static void main(String[] args) {
       
        Main main = new Main();
        main.haveAFarm();

    }

}
