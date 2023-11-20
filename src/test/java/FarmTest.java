import static org.junit.Assert.*;

import org.junit.Test;

import farm.BasicFarm;
import farm.BasicFarmFactory;
import farm.CornFarm;
import farm.DairyFarm;
import farm.Farm;
import farm.FarmFactory;
import farm.FarmManager;
import farm.FarmType;
import farm.Farmer;
import farm.SheepFarm;
import farm.WheatFarm;



/**
 * Tests the farm package.
 * * @author tfilewic
 */
public class FarmTest {

    /**
     * Tests that a BasicFarmFactory creates the correct types of farms with the Farm interface.
     */
    @Test
    public void basicFarmFactoryCreatesFarms() {
        FarmFactory factory = new BasicFarmFactory(null);

        Farm corn = factory.createFarm(FarmType.CORN);
        assertTrue("CornFarm", corn instanceof CornFarm);
        Farm wheat = factory.createFarm(FarmType.WHEAT);
        assertTrue("WheatFarm", wheat instanceof WheatFarm);
        Farm dairy = factory.createFarm(FarmType.DAIRY); 
        assertTrue("DairyFarm", dairy instanceof DairyFarm);
        Farm sheep = factory.createFarm(FarmType.SHEEP);
        assertTrue("SheepFarm", sheep instanceof SheepFarm);
    }
    
    /**
     * Tests that updating a farm with money returns false and no money returns true.
     */
    @Test
    public void assetUpdateReturnsCorrectValue() {
        FarmFactory factory = new BasicFarmFactory(null);
        
        Farm corn = factory.createFarm(FarmType.CORN, new Farmer[] {new Farmer(), new Farmer(), new Farmer(),
                new Farmer(), new Farmer(), new Farmer(), new Farmer(), new Farmer(), new Farmer(), new Farmer()});
        corn.display();
        corn.earn(1000);
        assertFalse("doesn't go broke", corn.update(true));
        assertFalse("doesn't go broke", corn.update(false));
        corn.earn(-1200);
        assertFalse("doesn't go broke", corn.update(true));
        assertTrue("goes broke", corn.update(false));
    }
    
    /**
     * Tests that FarmManager can update farms without failure.
     */
    @Test
    public void updatesWork() {
        FarmManager manager = new FarmManager();
        FarmFactory factory = new BasicFarmFactory(manager);
        BasicFarm[] farms = {(BasicFarm)factory.createFarm(FarmType.WHEAT), 
                (BasicFarm)factory.createFarm(FarmType.CORN), (BasicFarm)factory.createFarm(FarmType.SHEEP), 
                (BasicFarm)factory.createFarm(FarmType.DAIRY)};
        
        for (BasicFarm farm : farms) {
            Farmer[] farmers = {new Farmer(), new Farmer(), new Farmer(), new Farmer(), new Farmer(), 
                    new Farmer()};
            for (Farmer farmer : farmers) {
                farm.addFarmer(farmer);
            }
            manager.addFarm(farm);
        }
        
        try {
            for (int i = 0; i < 56; i++ ) {
                manager.updateFarms(true);
                manager.updateFarms(false);
            }
        } catch (RuntimeException ex) {
            fail("runtime exception thrown");
        }
    }    
    
}
