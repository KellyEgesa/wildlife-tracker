package models;

import java.util.Objects;

public class Rangers {
    private String contact;
    private int badgeNumber;
    private int id;

    public Rangers(String contact, int badgeNumber){
        this.badgeNumber = badgeNumber;
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

    public int getBadgeNumber() {
        return badgeNumber;
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
