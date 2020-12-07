package dao;

import models.Animal;
import org.sql2o.Connection;

public class Sql2oAnimal implements AnimalDao {
    @Override
    public Animal findById(int id) {
        String sql = "SELECT * FROM animal WHERE id =:id";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Animal.class);
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
}
