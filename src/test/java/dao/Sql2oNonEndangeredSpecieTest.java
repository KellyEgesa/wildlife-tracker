package dao;

import models.NonEndangeredSpecie;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class Sql2oNonEndangeredSpecieTest {
    private static Sql2oNonEndangeredSpecie nonEndangeredSpecieDao;
    private static Sql2oAnimal animalDao;
    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    @BeforeClass
    public static void setUp() {
        nonEndangeredSpecieDao = new Sql2oNonEndangeredSpecie();
        animalDao = new Sql2oAnimal();
    }

    private NonEndangeredSpecie setUpAnimal() {
        return new NonEndangeredSpecie("Honey Badger", "Young");
    }

    @Test
    public void addSetsId() {
        NonEndangeredSpecie testNonEndangeredSpecie = setUpAnimal();
        int originalId = testNonEndangeredSpecie.getId();
        nonEndangeredSpecieDao.save(testNonEndangeredSpecie);
        assertNotEquals(originalId, testNonEndangeredSpecie);
    }

    @Test
    public void getAllReturnsAllEndangeredSpecie_2() {
        NonEndangeredSpecie testNonEndangeredSpecie = setUpAnimal();
        NonEndangeredSpecie testSecondEndangeredSpecie = new NonEndangeredSpecie("Rhino", "adult");
        nonEndangeredSpecieDao.save(testNonEndangeredSpecie);
        nonEndangeredSpecieDao.save(testSecondEndangeredSpecie);
        assertEquals(2, nonEndangeredSpecieDao.getAllNonEndangeredSpecie().size());
    }

    @Test
    public void findByIdFindsAnimalById() {
        NonEndangeredSpecie testNonEndangeredSpecie = setUpAnimal();
        nonEndangeredSpecieDao.save(testNonEndangeredSpecie);
        assertTrue(testNonEndangeredSpecie.equals(animalDao.findById(testNonEndangeredSpecie.getId())));
    }


    @Test
    public void deleteByIdDeletesTheCorrectAnimal() {
        NonEndangeredSpecie testNonEndangeredSpecie = setUpAnimal();
        nonEndangeredSpecieDao.save(testNonEndangeredSpecie);
        NonEndangeredSpecie testSecondEndangeredSpecie = new NonEndangeredSpecie("Rhino", "adult");
        nonEndangeredSpecieDao.save(testSecondEndangeredSpecie);
        animalDao.deleteById(testNonEndangeredSpecie.getId());
        assertTrue(testSecondEndangeredSpecie.equals(nonEndangeredSpecieDao.getAllNonEndangeredSpecie().get(0)));
    }

    @Test
    public void clearAllAnimalsRemovesAllAnimals_0() {
        NonEndangeredSpecie testEndangeredSpecie = setUpAnimal();
        nonEndangeredSpecieDao.save(testEndangeredSpecie);
        NonEndangeredSpecie testSecondEndangeredSpecie = new NonEndangeredSpecie("Rhino", "adult");
        nonEndangeredSpecieDao.save(testSecondEndangeredSpecie);
        nonEndangeredSpecieDao.clearAllNonEndangeredAnimals();
        assertEquals(0, nonEndangeredSpecieDao.getAllNonEndangeredSpecie().size());
    }
}