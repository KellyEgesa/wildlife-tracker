package dao;

import java.util.List;

public interface LocationDao {
    //LIST
    List<models.Location> getAll();

    //CREATE
    void save(models.Location location);

    //READ
    models.Location findById(int id);
    List<SightingsDao> getSightingsByLocationById(int locationId);

    //UPDATE
    void update(int id, String name);

    //DELETE
    void deleteById(int id);
    void clearAllLocations();
}
