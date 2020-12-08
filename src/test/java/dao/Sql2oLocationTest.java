package dao;

import models.Location;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class Sql2oLocationTest {
    private static Sql2oLocation locationDao;
    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    @BeforeClass
    public static void setUp(){
        locationDao = new Sql2oLocation();
    }

    private Location setUpLocation() {
        return new Location("Near the River");
    }

    @Test
    public void addingLocationSetsId() {
        Location testLocation = setUpLocation();
        int locationId = testLocation.getId();
        locationDao.save(testLocation);
        assertNotEquals(locationId, testLocation.getId());
    }

    @Test
    public void findByIdReturnsCorrectLocation() {
        Location testLocation = setUpLocation();
        locationDao.save(testLocation);
        assertTrue(testLocation.equals(locationDao.findById(testLocation.getId())));
    }

    @Test
    public void getAllReturnsAllLocations_2() {
        Location testLocation = setUpLocation();
        locationDao.save(testLocation);
        Location testSecondLocation = new Location("Near the Gate");
        locationDao.save(testSecondLocation);
        assertEquals(2, locationDao.getAll().size());
    }

    @Test
    public void clearAllLocationsDeletesAllLocations_0() {
        Location testLocation = setUpLocation();
        locationDao.save(testLocation);
        Location testSecondLocation = new Location("Near the Gate");
        locationDao.save(testSecondLocation);
        locationDao.clearAllLocations();
        assertEquals(0, locationDao.getAll().size());
    }

    @Test
    public void deleteByIdDeletesALocationById() {
        Location testLocation = setUpLocation();
        locationDao.save(testLocation);
        Location testSecondLocation = new Location("Near the Gate");
        locationDao.save(testSecondLocation);
        locationDao.deleteById(testLocation.getId());
        assertTrue(testSecondLocation.equals(locationDao.getAll().get(0)));
    }

    @Test
    public void updateUpdatesLocationName() {
        Location testLocation = setUpLocation();
        locationDao.save(testLocation);
        locationDao.update(testLocation.getId(), "Zone A");
        assertEquals("Zone A", locationDao.findById(testLocation.getId()).getName());
    }
}