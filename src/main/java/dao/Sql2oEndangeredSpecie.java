package dao;

import models.EndangeredSpecie;
import org.sql2o.Connection;

import java.util.List;

public class Sql2oEndangeredSpecie implements EndangeredAnimalDao {
    private final String SPECIE_TYPE = "Endangered";

    @Override
    public List<EndangeredSpecie> getAllEndangeredSpecie() {
        String sql = "SELECT * FROM animal where type = :type";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("type", SPECIE_TYPE)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(EndangeredSpecie.class);
        }
    }

    @Override
    public void save(EndangeredSpecie animal) {
        String sql = "INSERT INTO animal (name, age, health, type) VALUES (:name, :age, :health, :type)";
        try(Connection con = DB.sql2o.open()){
            int id = (int)con.createQuery(sql)
                    .addParameter("name", animal.getName())
                    .addParameter("age", animal.getAge())
                    .addParameter("health", animal.getHealth())
                    .addParameter("type", SPECIE_TYPE)
                    .executeUpdate()
                    .getKey();
            animal.setId(id);
        }

    }

    @Override
    public void clearAllEndangeredAnimals() {
        String sql = "DELETE FROM animal WHERE type = :type";
        try(Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .addParameter("type", SPECIE_TYPE)
                    .executeUpdate();
        }
    }

}
