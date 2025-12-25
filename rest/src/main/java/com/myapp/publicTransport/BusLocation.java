package com.myapp.publicTransport;

public class BusLocation {
    // Declaring variables
    private int busId;
    private double latitude;
    private double longitude;
    private String status;

    // Constructor
    public BusLocation(int busId, double latitude, double longitude, String status) {
        this.busId = busId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = status;
    }

    // Setters and getters
    public int getBusId() {
        return busId;
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public String getStatus() {
        return status;
    }
}
