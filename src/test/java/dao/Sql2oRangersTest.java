package dao;

import models.Rangers;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class Sql2oRangersTest {
    private static Sql2oRangers rangersDao;
    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    @BeforeClass
    public static void setUp(){
        rangersDao = new Sql2oRangers();
    }

    private Rangers setUpRanger(){
        return new Rangers("kelly.egesa@gmail.com", 158920);
    }

    @Test
    public void addRangerSetsId() {
        Rangers testRanger = setUpRanger();
        int originalId = testRanger.getId();
        rangersDao.save(testRanger);
        assertNotEquals(originalId, testRanger.getId());
    }

    @Test
    public void getAllReturnsAllTheRangers_2() {
        Rangers testRanger = setUpRanger();
        rangersDao.save(testRanger);
        Rangers testSecondRanger = new Rangers("kelly123.egesa@gmail.com", 158320);
        rangersDao.save(testSecondRanger);
        assertEquals(2, rangersDao.getAll().size());
    }

    @Test
    public void findById_returnsCorrectRanger_true() {
        Rangers testRanger = setUpRanger();
        rangersDao.save(testRanger);
        Rangers testSecondRanger = new Rangers("kelly123.egesa@gmail.com", 158320);
        rangersDao.save(testSecondRanger);
        assertTrue(testSecondRanger.equals(rangersDao.findById(testSecondRanger.getId())));
    }

    @Test
    public void getRangerSightingsById() {
    }

    @Test
    public void update() {
        Rangers testRanger = setUpRanger();
        rangersDao.save(testRanger);
        rangersDao.update(testRanger.getId(), "moringa12@gmail.com");
        assertEquals("moringa12@gmail.com", rangersDao.findById(testRanger.getId()).getContact());
    }

    @Test
    public void deleteByIdDeletesRanger_1() {
        Rangers testRanger = setUpRanger();
        rangersDao.save(testRanger);
        Rangers testSecondRanger = new Rangers("kelly123.egesa@gmail.com", 158320);
        rangersDao.save(testSecondRanger);
        rangersDao.deleteById(testRanger.getId());
        assertEquals(1, rangersDao.getAll().size());

    }

    @Test
    public void clearAllRangersRemovesAllRangers_0() {
        Rangers testRanger = setUpRanger();
        rangersDao.save(testRanger);
        Rangers testSecondRanger = new Rangers("kelly123.egesa@gmail.com", 158320);
        rangersDao.save(testSecondRanger);
        rangersDao.clearAllRangers();
        assertEquals(0, rangersDao.getAll().size());
    }
}