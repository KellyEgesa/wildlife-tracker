package dao;

import models.*;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class Sql2oSightingsTest {

    private static Sql2oSightings sightingsDao;
    private static Sql2oNonEndangeredSpecie nonEndangeredSpecieDao;
    private static Sql2oEndangeredSpecie endangeredSpecieDao;
    private static Sql2oLocation locationDao;
    private static Sql2oRangers rangersDao;
    private static Sql2oAnimal animalDao;

    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    @BeforeClass
    public static void setUp() {
        sightingsDao = new Sql2oSightings();
        rangersDao = new Sql2oRangers();
        animalDao = new Sql2oAnimal();
        locationDao = new Sql2oLocation();
        nonEndangeredSpecieDao = new Sql2oNonEndangeredSpecie();
        endangeredSpecieDao = new Sql2oEndangeredSpecie();
    }

    private Sightings setUpSightings() {
        EndangeredSpecie testEndangeredSpecie = new EndangeredSpecie("Honey Badger", "Young", "healthy");
        Rangers testRanger = new Rangers("Kelly","kelly.egesa@gmail.com", 158920);
        Location testLocation = new Location("Near the River");
        endangeredSpecieDao.save(testEndangeredSpecie);
        rangersDao.save(testRanger);
        locationDao.save(testLocation);
        return new Sightings(testRanger.getId(), testLocation.getId(), testEndangeredSpecie.getId());
    }

    private Sightings setUpSecondSightings() {
        NonEndangeredSpecie testNonEndangeredSpecie = new NonEndangeredSpecie("Rhino", "adult");
        Rangers testRanger = new Rangers("Kelly","kelly123.egesa@gmail.com", 158960);
        Location testLocation = new Location("Near the gate");
        nonEndangeredSpecieDao.save(testNonEndangeredSpecie);
        rangersDao.save(testRanger);
        locationDao.save(testLocation);
        return new Sightings(testRanger.getId(), testLocation.getId(), testNonEndangeredSpecie.getId());
    }

    @Test
    public void addSetsIdCorrectly() {
        Sightings testSightings = setUpSightings();
        int originalId = testSightings.getId();
        sightingsDao.save(testSightings);
        assertNotEquals(originalId, testSightings.getId());
    }

    @Test
    public void lastSightingIsSetWhenSightingAddedToTheDB() {
        Sightings testSightings = setUpSightings();
        sightingsDao.save(testSightings);
        Timestamp timeNow = new Timestamp(new Date().getTime());
        Timestamp timeLastSighted = sightingsDao.findById(testSightings.getId()).getLastSighting();
        assertEquals(DateFormat.getDateInstance().format(timeNow), DateFormat.getDateInstance().format(timeLastSighted));
    }

    @Test
    public void getAllReturnsAllSightings_2() {
        Sightings testSightings = setUpSightings();
        Sightings testSecondSightings = setUpSecondSightings();
        sightingsDao.save(testSightings);
        sightingsDao.save(testSecondSightings);
        assertEquals(2, sightingsDao.getAll().size());
    }


    @Test
    public void findByIdReturnsTheCorrectSighting_true() {
        Sightings testSightings = setUpSightings();
        Sightings testSecondSightings = setUpSecondSightings();
        sightingsDao.save(testSightings);
        sightingsDao.save(testSecondSightings);
        assertTrue(testSightings.equals(sightingsDao.findById(testSightings.getId())));

    }

    @Test
    public void deleteByIdDeletesTheCorrectSighting_true() {
        Sightings testSightings = setUpSightings();
        Sightings testSecondSightings = setUpSecondSightings();
        sightingsDao.save(testSightings);
        sightingsDao.save(testSecondSightings);
        sightingsDao.deleteById(testSightings.getId());
        assertTrue(testSecondSightings.equals(sightingsDao.getAll().get(0)));
    }

    @Test
    public void clearAllLocations_0() {
        Sightings testSightings = setUpSightings();
        Sightings testSecondSightings = setUpSecondSightings();
        sightingsDao.save(testSightings);
        sightingsDao.save(testSecondSightings);
        sightingsDao.clearAllSightings();
        assertEquals(0, sightingsDao.getAll().size());
    }

    @Test
    public void findByRangerReturnsAllSightingsMadeByRanger() {
        Sightings testSightings = setUpSightings();
        Sightings testSecondSightings = setUpSecondSightings();
        sightingsDao.save(testSightings);
        sightingsDao.save(testSecondSightings);
        assertEquals(1, sightingsDao.findByRanger(testSightings.getRangersId()).size());

    }

    @Test
    public void findByAnimalsReturnsAllSightingsByAnimal() {
        Sightings testSightings = setUpSightings();
        Sightings testSecondSightings = setUpSecondSightings();
        sightingsDao.save(testSightings);
        sightingsDao.save(testSecondSightings);
        assertEquals(1, sightingsDao.findByAnimals(testSightings.getAnimalId()).size());

    }

    @Test
    public void findByLocationReturnsAllSightingsByLocation() {
        Sightings testSightings = setUpSightings();
        Sightings testSecondSightings = setUpSecondSightings();
        sightingsDao.save(testSightings);
        sightingsDao.save(testSecondSightings);
        assertEquals(1, sightingsDao.findByLocation(testSightings.getLocationId()).size());

    }
}