package models;

import dao.Sql2oAnimal;
import dao.Sql2oLocation;
import dao.Sql2oRangers;

import java.sql.Timestamp;
import java.util.Objects;

public class Sightings {
    private int rangersId;
    private int locationId;
    private int animalId;
    private int id;
    private Timestamp lastSighting;

    private Rangers rangers;
    private Location location;
    private Animal animal;

    private static Sql2oLocation locationDao = new Sql2oLocation();
    private static Sql2oRangers rangersDao = new Sql2oRangers();
    private static Sql2oAnimal animalDao = new Sql2oAnimal();

    public Sightings(int rangersId, int locationId, int animalId) {
        this.rangersId = rangersId;
        this.locationId = locationId;
        this.animalId = animalId;
    }

    public int getRangersId() {
        return rangersId;
    }

    public int getLocationId() {
        return locationId;
    }

    public int getAnimalId() {
        return animalId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getLastSighting() {
        return lastSighting;
    }

    public Rangers getRangers() {
        return rangersDao.findById(rangersId);
    }


    public Location getLocation() {
        return locationDao.findById(locationId);
    }


    public Animal getAnimal() {
        return animalDao.findById(animalId);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sightings)) return false;
        Sightings sightings = (Sightings) o;
        return getRangersId() == sightings.getRangersId() &&
                getLocationId() == sightings.getLocationId() &&
                getAnimalId() == sightings.getAnimalId() &&
                getId() == sightings.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRangersId(), getLocationId(), getAnimalId(), getId());
    }
}
