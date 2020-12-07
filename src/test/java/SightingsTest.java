import org.junit.Test;

import static org.junit.Assert.*;

public class SightingsTest {
    private Sightings setUpSightings(){
        Animal testAnimal =  new Animal("Honey Badger", "Young");
        Rangers testRanger =  new Rangers("kelly.egesa@gmail.com", 158920);
        Location testLocation = new Location("Near the River");
        testAnimal.setId(1);
        testRanger.setId(1);
        testLocation.setId(1);
        return new Sightings(testRanger.getId(),testLocation.getId(),testAnimal.getId());
    }

    @Test
    public void sightingsInstantiatesProperly() {
        Sightings testSighting = setUpSightings();
        assertTrue(testSighting instanceof Sightings);
    }

    @Test
    public void getLocationIdCorrectly_1() {
        Sightings testSighting = setUpSightings();
        assertEquals(1, testSighting.getLocationId());
    }

    @Test
    public void getRangerIdCorrectly_1() {
        Sightings testSighting = setUpSightings();
        assertEquals(1, testSighting.getRangersId());
    }

    @Test
    public void getAnimalIdCorrectly_1() {
        Sightings testSighting = setUpSightings();
        assertEquals(1, testSighting.getAnimalId());
    }

    @Test
    public void setIdSetsIdCorrectly_1() {
        Sightings testSighting = setUpSightings();
        testSighting.setId(1);
        assertEquals(1, testSighting.getId());
    }
}