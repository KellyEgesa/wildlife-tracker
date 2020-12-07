import org.junit.Test;

import static org.junit.Assert.*;

public class SightingsTest {
    private Sightings setUpSightings(){
        return new Sightings(1,1,1);
    }

    @Test
    public void sightingsInstantiatesProperly() {
        Sightings testSighting = setUpSightings();
        assertTrue(testSighting instanceof Sightings);
    }
}