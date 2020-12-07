package models;

import java.sql.Timestamp;
import java.util.Objects;

public class Sightings {
    private int rangersId;
    private int locationId;
    private int animalId;
    private int id;
    private Timestamp lastSighting;

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
