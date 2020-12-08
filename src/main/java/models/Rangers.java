package models;

import java.util.Objects;

public class Rangers {
    private String contactInfo;
    private int badgeNumber;
    private String name;
    private int id;

    public Rangers(String name ,String contact, int badgeNumber){
        this.name = name;
        this.badgeNumber = badgeNumber;
        this.contactInfo = contact;
    }

    public String getContact() {
        return contactInfo;
    }

    public int getBadgeNumber() {
        return badgeNumber;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rangers)) return false;
        Rangers rangers = (Rangers) o;
        return getBadgeNumber() == rangers.getBadgeNumber() &&
                getId() == rangers.getId() &&
                Objects.equals(getContact(), rangers.getContact());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContact(), getBadgeNumber(), getId());
    }
}
