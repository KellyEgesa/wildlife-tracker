package models;

public class EndangeredSpecie extends Animal {
    private String health;
    public EndangeredSpecie(String name, String age, String health){
        super(name, age);
        this.health = health;
    }

    public String getHealth() {
        return health;
    }
}
