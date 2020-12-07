package dao;

import java.util.List;

public interface Animal {
    //LIST
    List<Animal> getAll();

    //CREATE
    void add (Animal location);

    //READ
    Animal findById(int id);
    List<Animal> getAnimalBySpecie(String type);

    //UPDATE
    void update(int id, String name);

    //DELETE
    void deleteById(int id);
    void clearAllAnimals();
}
