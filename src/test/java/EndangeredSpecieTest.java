import models.EndangeredSpecie;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredSpecieTest {
    private EndangeredSpecie setUpAnimal(){
        return new EndangeredSpecie("Honey Badger", "Young", "healthy");
    }

    @Test
    public void endangeredSpecie_instantiatesProperly() {
        EndangeredSpecie testEndangeredSpecie = setUpAnimal();
        assertTrue(testEndangeredSpecie instanceof EndangeredSpecie);
    }

    @Test
    public void getNameReturnsNameProperly_HoneyBadger() {
        EndangeredSpecie testEndangeredSpecie = setUpAnimal();
        assertEquals("Honey Badger", testEndangeredSpecie.getName());
    }

    @Test
    public void getAgeReturnsAgeProperly_Young() {
        EndangeredSpecie testEndangeredSpecie= setUpAnimal();
        assertEquals("Young", testEndangeredSpecie.getAge());
    }

    @Test
    public void setIdSetsIdProperly() {
        EndangeredSpecie testEndangeredSpecie= setUpAnimal();
        testEndangeredSpecie.setId(1);
        assertEquals(1, testEndangeredSpecie.getId());
    }

    @Test
    public void equalsWorksCorrectly_true() {
        EndangeredSpecie testEndangeredSpecie = setUpAnimal();
        EndangeredSpecie testSecondEndangeredSpecie = new EndangeredSpecie("Honey Badger", "Young", "Healthy");
        assertTrue(testEndangeredSpecie.equals(testSecondEndangeredSpecie));
    }

}