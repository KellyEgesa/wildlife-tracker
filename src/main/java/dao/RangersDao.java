package dao;

import java.util.List;

public interface RangersDao {
    //LIST
    List<RangersDao> getAll();

    //CREATE
    void add (RangersDao rangers);

    //READ
    RangersDao findById(int id);
    List<SightingsDao> getRangerSightingsById(int RangersId);

    //UPDATE
    void update(int id, String contact);

    //DELETE
    void deleteById(int id);
    void clearAllRangers();
}
