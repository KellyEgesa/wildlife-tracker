package dao;

import models.Location;
import org.sql2o.Connection;

import java.util.List;

public class Sql2oLocation implements LocationDao {

    @Override
    public List<Location> getAll() {
        String sql = "SELECT * FROM locations";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(Location.class);
        }
    }

    @Override
    public void save(Location location){
        String sql = "INSERT INTO locations (name) VALUES (:name)";
        try(Connection con = DB.sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .addParameter("name", location.getName())
                    .executeUpdate()
                    .getKey();
            location.setId(id);
        }
    }

    @Override
    public Location findById(int id) {
        String sql = "SELECT * FROM locations WHERE id =:id";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Location.class);
        }
    }

    @Override
    public List<SightingsDao> getSightingsByLocationById(int locationId) {
        return null;
    }

    @Override
    public void update(int id, String name) {
        String sql = "UPDATE locations SET name = :name WHERE id =:id";
        try(Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("id", id)
                    .executeUpdate();
        }

    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM locations where id =:id";
        try(Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    @Override
    public void clearAllLocations() {
        String sql = "DELETE FROM locations";
        try(Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        }
    }
}
