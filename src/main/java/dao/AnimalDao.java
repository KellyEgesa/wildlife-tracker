package dao;

import models.Animal;

import java.util.List;

public interface AnimalDao {
    Animal findById(int id);
    void deleteById(int id);
    List<Animal> getAll();
}
