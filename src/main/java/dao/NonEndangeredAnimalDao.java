package dao;

import models.NonEndangeredSpecie;

import java.util.List;

public interface NonEndangeredAnimalDao {
    //LIST
    List<NonEndangeredSpecie> getAllNonEndangeredSpecie();

    //CREATE
    void save(NonEndangeredSpecie animal);

    //DELETE
    void clearAllNonEndangeredAnimals();
}
