import org.junit.Test;

import static org.junit.Assert.*;

public class NonEndangeredSpecieTest {
    private NonEndangeredSpecie setUpAnimal(){
        return new NonEndangeredSpecie("Honey Badger", "Young");
    }

    @Test
    public void endangeredSpecie_instantiatesProperly() {
        NonEndangeredSpecie testNonEndangeredSpecie = setUpAnimal();
        assertTrue(testNonEndangeredSpecie instanceof NonEndangeredSpecie);
    }

    @Test
    public void getNameReturnsNameProperly_HoneyBadger() {
        NonEndangeredSpecie testNonEndangeredSpecie = setUpAnimal();
        assertEquals("Honey Badger", testNonEndangeredSpecie.getName());
    }

    @Test
    public void getAgeReturnsAgeProperly_Young() {
        NonEndangeredSpecie testNonEndangeredSpecie = setUpAnimal();
        assertEquals("Young", testNonEndangeredSpecie.getAge());
    }

    @Test
    public void setIdSetsIdProperly() {
        NonEndangeredSpecie testNonEndangeredSpecie = setUpAnimal();
        testNonEndangeredSpecie.setId(1);
        assertEquals(1, testNonEndangeredSpecie.getId());
    }

    @Test
    public void equalsWorksCorrectly_true() {
        NonEndangeredSpecie testNonEndangeredSpecie = setUpAnimal();
        NonEndangeredSpecie testNonSecondEndangeredSpecie = new NonEndangeredSpecie("Honey Badger", "Young");
        assertTrue(testNonEndangeredSpecie.equals(testNonSecondEndangeredSpecie));
    }
}