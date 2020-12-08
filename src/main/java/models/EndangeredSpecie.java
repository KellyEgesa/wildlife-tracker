package models;

public class EndangeredSpecie extends Animal {
    private String health;

    private final String HEALTH_HEALTHY = "healthy";
    private final String HEALTH_ILL = "ill";
    private final String HEALTH_OKAY = "okay";

    public EndangeredSpecie(String name, String age, String health){
        super(name, age);
        if(health.equals(HEALTH_HEALTHY) || health.equals(HEALTH_ILL) || health.equals(HEALTH_OKAY)){
            this.health = health;
        }else {
            throw new IllegalArgumentException("Bad parameter for health");
        }
    }

    public String getHealth() {
        return health;
    }
}
