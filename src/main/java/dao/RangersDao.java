package dao;

import models.Rangers;
import models.Sightings;

import java.util.List;

public interface RangersDao {
    //LIST
    List<Rangers> getAll();

    //CREATE
    void save(Rangers rangers);

    //READ
    Rangers findById(int id);
    List<Sightings> getRangerSightingsById(int RangersId);

    //UPDATE
    void update(int id, String contact);

    //DELETE
    void deleteById(int id);
    void clearAllRangers();
}
