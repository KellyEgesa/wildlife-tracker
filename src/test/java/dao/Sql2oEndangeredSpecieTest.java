package dao;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredSpecieTest {

    private static Sql2oLocation locationDao;
    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    @BeforeClass
    public static void setUp(){
        locationDao = new Sql2oLocation();
    }

    @Test
    public void getAll() {
    }

    @Test
    public void add() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void getAnimalBySpecie() {
    }

    @Test
    public void update() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void clearAllAnimals() {
    }
}