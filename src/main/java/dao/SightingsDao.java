package dao;

import java.util.List;

public interface SightingsDao {
    //LIST
    List<SightingsDao> getAll();

    //CREATE
    void add (SightingsDao location);

    //READ
    SightingsDao findById(int id);

    //DELETE
    void deleteById(int id);
    void clearAllLocations();
}
