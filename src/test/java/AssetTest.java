import static org.junit.Assert.*;

import org.junit.Test;

import asset.*;
import farm.DairyFarm;
import farm.FarmType;
import simulation.Simulation;

/**
 * Tests the asset package.
 * @author tfilewic
 */
public class AssetTest {

    /**
     * Tests that a cow produces after 3 days.
     */
    @Test
    public void cowsGenerateIncome() {
        int revenue = 0;
        Herd herd = new Herd();
        Cow cow = new Cow();
        herd.addAnimal(cow);
        
        herd.update(true);
        herd.update(true);
        herd.update(true);
        herd.update(true);
        herd.produce();
        herd.produce();
        herd.display();

        revenue = herd.produce();;

        assertTrue("Cows produce " + revenue, revenue > 0);
    }
    
    /**
     * Tests that a cow produces after 3 days.
     */
    @Test
    public void sheepGenerateIncome() {
        int revenue = 0;
        Herd herd = new Herd();
        Sheep sheep = new Sheep();
        herd.addAnimal(sheep);
        
        herd.update(true);
        herd.update(true);
        herd.update(true);
        herd.update(true);
        herd.produce();
        herd.produce();
        herd.display();

        revenue = herd.produce();;

        assertTrue("Sheep produce " + revenue, revenue > 0);
    }
    
    /**
     * Tests that a crop produces after 2 days.
     */
    @Test
    public void cropsGenerateIncome() {
        int revenue = 0;
        Crop crop = new Crop("z", 22, 33);
        
        crop.produce();
        crop.produce();
        crop.produce();
        crop.display();
        revenue = crop.produce();;

        assertTrue("Crops produce " + revenue, revenue > 0);
    }
    

    /**
     * Tests that a cow dies after days.
     */
    @Test
    public void cowsDie() {
        Herd herd = new Herd();
        Cow cow1 = new Cow();
        Cow cow2 = new Cow();
        for (int i = 14; i >0; i--) {
            cow1.update(true);
            cow2.update(true);
        }
        herd.addAnimal(cow1);
        herd.addAnimal(cow2);
        int herdSize = herd.getSize();
        assertEquals("Herd size 2", 2 , herdSize);
        herd.update(false);
        herdSize = herd.getSize();
        assertEquals("Herd size 0", 0, herdSize);
    }
    
    
    /**
     * Tests that a sheep dies after days.
     */
    @Test
    public void sheepDie() {
        Herd herd = new Herd();
        Sheep sheep1 = new Sheep();
        Sheep sheep2 = new Sheep();
        for (int i = 14; i >0; i--) {
            sheep1.update(true);
            sheep2.update(true);
        }
        herd.addAnimal(sheep1);
        herd.addAnimal(sheep2);
        int herdSize = herd.getSize();
        assertEquals("Herd size 2", 2 , herdSize);
        herd.update(false);
        herdSize = herd.getSize();
        assertEquals("Herd size 0", 0, herdSize);
    }
    
    /**
     * Tests that purchasing an upgrade increases the crop size.
     */
    @Test
    public void cropsUpgrade() {
        Crop crop = new Crop("z", 22, 33);
        String before = crop.display();
        crop.upgrade(1000);
        String after = crop.display();
        assertFalse("before: " + before + " after: " + after, before.equals(after));
    }
    
    /**
     * Tests that addAcres increases the crop size.
     */
    @Test
    public void cropsAddAcres() {
        Crop crop = new Crop("z", 22, 33);
        String before = crop.display();
        crop.addAcres(77);
        String after = crop.display();
        assertFalse("before: " + before + " after: " + after, before.equals(after));
    }
    
    
    
}
