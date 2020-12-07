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
}
