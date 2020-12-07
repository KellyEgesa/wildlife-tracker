import org.junit.Test;

import static org.junit.Assert.*;

public class SightingsTest {
    private Sightings setUpSightings(){
        Animal testAnimal =  new Animal("Honey Badger", "Young");
        Rangers testRanger =  new Rangers("kelly.egesa@gmail.com", 158920);
        return new Sightings(1,1,1);
    }

    @Test
    public void sightingsInstantiatesProperly() {
        Sightings testSighting = setUpSightings();
        assertTrue(testSighting instanceof Sightings);
    }


}