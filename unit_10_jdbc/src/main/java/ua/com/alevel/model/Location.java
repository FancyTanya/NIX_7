package ua.com.alevel.model;

public class Location {
    private static int id;
    private String name;

    Location() {}

    public Location(String name) {
        id++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
