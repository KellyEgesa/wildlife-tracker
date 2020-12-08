package models;

import java.util.Objects;

public class Animal {
    private String name;
    private String age;
    private String type;
    private int id;

    private final String AGE_YOUNG = "Young";
    private final String AGE_NEW_BORN = "newborn";
    private final String AGE_ADULT = "adult";

    public Animal(String name, String age){
        this.name = name;
        if(age.equals(AGE_ADULT) || age.equals(AGE_NEW_BORN) || age.equals(AGE_YOUNG)){
            this.age = age;
        }else {
            throw new IllegalArgumentException("Bad parameter for age");
        }

    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return getId() == animal.getId() &&
                Objects.equals(getName(), animal.getName()) &&
                Objects.equals(getAge(), animal.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getId());
    }
}
