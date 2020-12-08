package dao;

import models.EndangeredSpecie;

import java.util.List;

public interface EndangeredAnimalDao {
    //LIST
    List<EndangeredSpecie> getAllEndangeredSpecie();

    //CREATE
    void save(EndangeredSpecie animal);

    //DELETE
    void clearAllEndangeredAnimals();
}
