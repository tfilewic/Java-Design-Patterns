import static org.junit.Assert.*;

import org.junit.Test;

import hazard.BadWeather;
import hazard.Predators;



/**
 * Tests the hazard package.
 * @author tfilewic
 *
 */
public class hazardTest {
    
    /**
     * Tests that flood sometimes returns more than zero. 
     */
    @Test
    public void floodsReturnsMoreThanZero() {
        int before = 160;
        int after = before;
        
        for (int i = 0; i < 90; i++) {
            after -= BadWeather.flood(after);
        }
        
        assertTrue("crops reduced", after < before);
    }
    
    /**
     * Tests that wolfKill sometimes returns more than zero. 
     */
    @Test
    public void wolfKillReturnsMoreThanZero() {
        int before = 50;
        int after = before;
        for (int i = 0; i < 90; i++) {
            after -= Predators.wolfKill(after);
        }
        assertTrue("herd reduced", after < before);
    }
    
    /**
     * Tests that wolfKill does not kill animals with a herd of 0. 
     */
    @Test
    public void wolfKillDoesNotKillNoAnimals() {
        for (int i = 0; i < 90; i++) {
            assertEquals("zero", 0, Predators.wolfKill(0));
        }
    }
    
    /**
     * Tests that wolfKill does not kill more than 4 animals with a herd of 4; 
     */
    @Test
    public void wolfKillDoesNotKillMoreThanFour() {
        for (int i = 0; i < 90; i++) {
            assertTrue("<=4", Predators.wolfKill(4) <= 4);
        }
    }
    

    
}
