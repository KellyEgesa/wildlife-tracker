package models;

import models.Location;
import org.junit.Test;

import static org.junit.Assert.*;

public class LocationTest {
    private Location setUpLocation(){
        return new Location("Near the River");
    }

    @Test
    public void locationInstantiatesCorrectly() {
        Location testLocation = setUpLocation();
        assertTrue(testLocation instanceof Location);
    }

    @Test
    public void getNameReturnsLocationNameCorrectly() {
        Location testLocation = setUpLocation();
        assertEquals("Near the River", testLocation.getName());
    }

    @Test
    public void setIdSetsIdCorrectly_1() {
        Location testLocation = setUpLocation();
        testLocation.setId(1);
        assertEquals(1, testLocation.getId());
    }

    @Test
    public void equalsWorksCorrectly_true() {
        Location testLocation = setUpLocation();
        Location testSecondLocation = new Location("Near the River");
        assertTrue(testLocation.equals(testSecondLocation));
    }
}