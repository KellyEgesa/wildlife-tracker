package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {
    private Animal setUpAnimal(){
        return new Animal("Honey Badger", "Young");
    }

    @Test
    public void animalInstantiatesCorrectly() {
        Animal testAnimal = setUpAnimal();
        assertTrue(testAnimal instanceof Animal);
    }

    @Test
    public void getNameReturnsNameProperly() {
        Animal testAnimal = setUpAnimal();
        assertEquals("Honey Badger", testAnimal.getName());
    }

    @Test
    public void getAgeReturnsAgeProperly() {
        Animal testAnimal = setUpAnimal();
        assertEquals("Young", testAnimal.getAge());
    }

    @Test
    public void setIdSetsIdProperly() {
        Animal testAnimal = setUpAnimal();
        testAnimal.setId(1);
        assertEquals(1, testAnimal.getId());
    }

    @Test
    public void testEquals() {
        Animal testAnimal = setUpAnimal();
        Animal testSecondAnimal = new Animal("Honey Badger", "Young");
        assertTrue(testAnimal.equals(testSecondAnimal));
    }

    @Test
    public void ageCannotBeSetToTheWrongProperty() {
        String argumentExceptionMessage = null;
        try{
            Animal testSecondAnimal = new Animal("Honey Badger", "not old");
        } catch(IllegalArgumentException ex){
            argumentExceptionMessage = ex.getMessage();
        }
        assertTrue(argumentExceptionMessage.equals("Bad parameter for age"));
    }
}