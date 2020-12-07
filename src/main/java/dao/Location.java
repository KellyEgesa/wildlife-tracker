package dao;

import java.util.List;

public interface Location {
    //LIST
    List<Location> getAll();

    //CREATE
    void add (Location location);

    //READ
    Location findById(int id);
    List<Sightings> getSightingsByLocationById(int locationId);

    //UPDATE
    void update(int id, String name);

    //DELETE
    void deleteById(int id);
    void clearAllLocations();
}
