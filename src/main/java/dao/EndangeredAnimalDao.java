package dao;

import models.Animal;
import models.EndangeredSpecie;

import java.util.List;

public interface AnimalDao {
    //LIST
    List<EndangeredSpecie> getAll();

    //CREATE
    void save(EndangeredSpecie animal);

    //READ
    AnimalDao findById(int id);
    List<AnimalDao> getAnimalBySpecie(String type);

    //UPDATE
    void update(int id, String name);

    //DELETE
    void deleteById(int id);
    void clearAllAnimals();
}
