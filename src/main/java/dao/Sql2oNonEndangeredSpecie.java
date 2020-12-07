package dao;

import org.sql2o.Connection;

import java.util.List;

public class NonEndangeredSpecie {
    private final String SPECIE_TYPE = "Endangered";

    @Override
    public List<EndangeredSpecie> getAll() {
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
    public EndangeredSpecie findById(int id) {
        String sql = "SELECT * FROM animal WHERE id =:id";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(EndangeredSpecie.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM animal WHERE id =:id";
        try(Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }

    }

    @Override
    public void clearAllAnimals() {
        String sql = "DELETE FROM animal WHERE type = :type";
        try(Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .addParameter("type", SPECIE_TYPE)
                    .executeUpdate();
        }
    }

}
