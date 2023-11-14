import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Example test class to ensure project is set up correctly.
 */
public class ExampleTest {

    /**
     * Tests that haveAFarm() sets oldMacDonaldHadAFarm to true.
     */
    @Test
    public void setProgressNodeAndEdgeCoverage() {
        Simulation simulation = new Simulation();
        simulation .haveAFarm();
        assertTrue("haveAFarm", simulation.oldMacDonaldHadAFarm);
    }
    
}
