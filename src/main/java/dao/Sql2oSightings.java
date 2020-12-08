package dao;

import models.Sightings;
import org.sql2o.Connection;

import java.util.List;

public class Sql2oSightings implements SightingsDao {
    @Override
    public List<Sightings> getAll() {
        String sql = "SELECT * FROM sightings";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(Sightings.class);
        }
    }

    @Override
    public void save(Sightings sightings) {
        String sql = " INSERT INTO sightings (rangersId, animalId, locationId, lastSighting) VALUES (:rangersId, :animalId, :locationId, now())";
        try (Connection con = DB.sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .addParameter("rangersId", sightings.getRangersId())
                    .addParameter("animalId", sightings.getAnimalId())
                    .addParameter("locationId", sightings.getLocationId())
                    .executeUpdate()
                    .getKey();
            sightings.setId(id);

        }

    }

    @Override
    public Sightings findById(int id) {
        String sql = "SELECT * FROM sightings WHERE id = :id";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sightings.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM sightings WHERE id = :id";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    @Override
    public void clearAllSightings() {
        String sql = "DELETE FROM sightings";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        }
    }

    @Override
    public List<Sightings> findByRanger(int rangersId) {
        String sql = "SELECT * FROM sightings WHERE rangersId = :rangersId";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("rangersId", rangersId)
                    .executeAndFetch(Sightings.class);
        }
    }

    @Override
    public List<Sightings> findByAnimals(int animalId) {
        String sql = "SELECT * FROM sightings WHERE animalId = :animalId";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("animalId", animalId)
                    .executeAndFetch(Sightings.class);
        }
    }

    @Override
    public List<Sightings> findByLocation(int locationId) {
        String sql = "SELECT * FROM sightings WHERE locationId = :locationId";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("locationId", locationId)
                    .executeAndFetch(Sightings.class);
        }
    }
}
