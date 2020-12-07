package dao;

import models.EndangeredSpecie;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class Sql2oEndangeredSpecieTest {

    private static Sql2oEndangeredSpecie endangeredSpecieDao;
    private static Sql2oAnimal animalDao;

    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    @BeforeClass
    public static void setUp() {
        endangeredSpecieDao = new Sql2oEndangeredSpecie();
        animalDao = new Sql2oAnimal();
    }

    private EndangeredSpecie setUpAnimal() {
        return new EndangeredSpecie("Honey Badger", "Young", "healthy");
    }

    @Test
    public void addSetsId() {
        EndangeredSpecie testEndangeredSpecie = setUpAnimal();
        int originalId = testEndangeredSpecie.getId();
        endangeredSpecieDao.save(testEndangeredSpecie);
        assertNotEquals(originalId, testEndangeredSpecie);
    }

    @Test
    public void getAllReturnsAllEndangeredSpecie_2() {
        EndangeredSpecie testEndangeredSpecie = setUpAnimal();
        EndangeredSpecie testSecondEndangeredSpecie = new EndangeredSpecie("Rhino", "adult", "ill");
        endangeredSpecieDao.save(testEndangeredSpecie);
        endangeredSpecieDao.save(testSecondEndangeredSpecie);
        assertEquals(2, endangeredSpecieDao.getAllEndangeredSpecie().size());
    }

    @Test
    public void findByIdFindsAnimalById() {
        EndangeredSpecie testEndangeredSpecie = setUpAnimal();
        endangeredSpecieDao.save(testEndangeredSpecie);
        assertTrue(testEndangeredSpecie.equals(animalDao.findById(testEndangeredSpecie.getId())));
    }


    @Test
    public void deleteByIdDeletesTheCorrectAnimal() {
        EndangeredSpecie testEndangeredSpecie = setUpAnimal();
        endangeredSpecieDao.save(testEndangeredSpecie);
        EndangeredSpecie testSecondEndangeredSpecie = new EndangeredSpecie("Rhino", "adult", "ill");
        endangeredSpecieDao.save(testSecondEndangeredSpecie);
        animalDao.deleteById(testEndangeredSpecie.getId());
        assertTrue(testSecondEndangeredSpecie.equals(endangeredSpecieDao.getAllEndangeredSpecie().get(0)));
    }

    @Test
    public void clearAllAnimalsRemovesAllAnimals_0() {
        EndangeredSpecie testEndangeredSpecie = setUpAnimal();
        endangeredSpecieDao.save(testEndangeredSpecie);
        EndangeredSpecie testSecondEndangeredSpecie = new EndangeredSpecie("Rhino", "adult", "ill");
        endangeredSpecieDao.save(testSecondEndangeredSpecie);
        endangeredSpecieDao.clearAllEndangeredAnimals();
        assertEquals(0, endangeredSpecieDao.getAllEndangeredSpecie().size());
    }
}