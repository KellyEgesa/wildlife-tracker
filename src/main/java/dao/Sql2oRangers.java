package dao;

import models.Rangers;
import models.Sightings;
import org.sql2o.Connection;

import java.util.List;

public class Sql2oRangers implements RangersDao {
    @Override
    public List<Rangers> getAll() {
        String sql = "SELECT * FROM rangers";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(Rangers.class);
        }
    }

    @Override
    public void save(Rangers rangers) {
        String sql = "INSERT INTO rangers (name, contactInfo, badgeNumber) VALUES (:name, :contact, :badgeNumber)";
        try (Connection con = DB.sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .addParameter("name", rangers.getName())
                    .addParameter("contact", rangers.getContact())
                    .addParameter("badgeNumber", rangers.getBadgeNumber())
                    .executeUpdate()
                    .getKey();
            rangers.setId(id);
        }
    }

    @Override
    public Rangers findById(int id) {
        String sql = "SELECT * FROM rangers WHERE id =:id";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Rangers.class);
        }
    }

    @Override
    public List<Sightings> getRangerSightingsById(int RangersId) {
        return null;
    }


    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM rangers WHERE id =:id";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    @Override
    public void clearAllRangers() {
        String sql = "DELETE FROM rangers";
        try(Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        }

    }
}
