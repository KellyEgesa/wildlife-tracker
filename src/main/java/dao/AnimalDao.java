package dao;

import models.Animal;

public interface AnimalDao {
    Animal findById(int id);
    void deleteById(int id);
}
