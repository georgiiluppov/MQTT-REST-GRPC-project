package com.myapp.publicTransport;

public class Route {
    // Declaring variables
    private int id;
    private String name;
    private String type;

    // Constructor
    public Route(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    // Setters and getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
}
