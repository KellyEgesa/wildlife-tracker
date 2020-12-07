//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class AnimalTest {
//    private Animal setUpAnimal(){
//        return new Animal("Honey Badger", "Young");
//    }
//
//    @Test
//    public void instantiatesProperly() {
//        Animal testAnimal = setUpAnimal();
//        assertTrue(testAnimal instanceof Animal);
//    }
//
//    @Test
//    public void getNameReturnsNameProperly_HoneyBadger() {
//        Animal testAnimal = setUpAnimal();
//        assertEquals("Honey Badger", testAnimal.getName());
//    }
//
//    @Test
//    public void getAgeReturnsAgeProperly_Young() {
//        Animal testAnimal = setUpAnimal();
//        assertEquals("Young", testAnimal.getAge());
//    }
//
//    @Test
//    public void setIdSetsIdProperly() {
//        Animal testAnimal = setUpAnimal();
//        testAnimal.setId(1);
//        assertEquals(1, testAnimal.getId());
//    }
//
//    @Test
//    public void equalsWorksCorrectly_true() {
//        Animal testAnimal = setUpAnimal();
//        Animal testSecondAnimal = new Animal("Honey Badger", "Young");
//        assertTrue(testAnimal.equals(testSecondAnimal));
//    }
//}