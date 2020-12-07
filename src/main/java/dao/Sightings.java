package dao;

import java.util.List;

public interface Sightings {
    //LIST
    List<Sightings> getAll();

    //CREATE
    void add (Sightings location);

    //READ
    Sightings findById(int id);

    //DELETE
    void deleteById(int id);
    void clearAllLocations();
}
