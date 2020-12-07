public class Sightings {
    private int rangersId;
    private int locationId;
    private int animalId;
    private int id;

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
}
