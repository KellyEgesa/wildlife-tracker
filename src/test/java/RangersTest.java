import models.Rangers;
import org.junit.Test;

import static org.junit.Assert.*;

public class RangersTest {
    private Rangers setUpRanger(){
        return new Rangers("Kelly Egesa","kelly.egesa@gmail.com", 158920);
    }

    @Test
    public void rangersInstantiatesCorrectly() {
        Rangers testRanger = setUpRanger();
        assertTrue(testRanger instanceof Rangers);
    }

    @Test
    public void getContactReturnsContactCorrectly() {
        Rangers testRanger = setUpRanger();
        assertEquals("kelly.egesa@gmail.com", testRanger.getContact());
    }

    @Test
    public void getNameReturnsCorrectName_Kelly() {
        Rangers testRanger = setUpRanger();
        assertEquals("Kelly Egesa",testRanger.getName());
    }

    @Test
    public void getBadgeNumberReturnsBadgeNumberCorrectly_158920() {
        Rangers testRanger = setUpRanger();
        assertEquals(158920, testRanger.getBadgeNumber());
    }

    @Test
    public void setIdSetsIdCorrectly_1() {
        Rangers testRanger = setUpRanger();
        testRanger.setId(1);
        assertEquals(1, testRanger.getId());
    }

    @Test
    public void equalsWorksCorrectly_true() {
        Rangers testRanger = setUpRanger();
        Rangers testSecondRanger = new Rangers("Bartholomew","kelly.egesa@gmail.com", 158920);
        assertTrue(testRanger.equals(testSecondRanger));
    }
}