package dao;

import models.NonEndangeredSpecie;
import org.sql2o.Connection;

import java.util.List;

public class Sql2oNonEndangeredSpecie implements NonEndangeredAnimalDao {
    private final String SPECIE_TYPE = "NonEndangered";

    @Override
    public List<NonEndangeredSpecie> getAllNonEndangeredSpecie() {
        String sql = "SELECT * FROM animal where type = :type";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("type", SPECIE_TYPE)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(NonEndangeredSpecie.class);
        }
    }

    @Override
    public void save(NonEndangeredSpecie animal) {
        String sql = "INSERT INTO animal (name, age, type) VALUES (:name, :age, :type)";
        try(Connection con = DB.sql2o.open()){
            int id = (int)con.createQuery(sql)
                    .addParameter("name", animal.getName())
                    .addParameter("age", animal.getAge())
                    .addParameter("type", SPECIE_TYPE)
                    .executeUpdate()
                    .getKey();
            animal.setId(id);
        }

    }

    @Override
    public void clearAllNonEndangeredAnimals() {
        String sql = "DELETE FROM animal WHERE type = :type";
        try(Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .addParameter("type", SPECIE_TYPE)
                    .executeUpdate();
        }
    }

}
