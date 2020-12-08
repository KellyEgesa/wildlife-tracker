package dao;

import models.Animal;
import models.Location;
import models.Rangers;
import models.Sightings;

import java.util.List;

public interface SightingsDao {
    //LIST
    List<Sightings> getAll();

    //CREATE
    void save(Sightings sightings);

    //READ
    Sightings findById(int id);
    List<Sightings> findByRanger(int rangersId);
    List<Sightings> findByAnimals(int animalId);
    List<Sightings> findByLocation(int locationId);

    //DELETE
    void deleteById(int id);
    void clearAllSightings();
}
