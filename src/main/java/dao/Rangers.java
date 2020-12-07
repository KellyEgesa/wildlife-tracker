package dao;

import java.util.List;

public interface Rangers {
    //LIST
    List<Rangers> getAll();

    //CREATE
    void add (Rangers rangers);

    //READ
    Rangers findById(int id);
    List<Sightings> getRangerSightingsById(int RangersId);

    //UPDATE
    void update(int id, String contact);

    //DELETE
    void deleteById(int id);
    void clearAllRangers();
}
