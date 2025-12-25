package com.myapp.publicTransport;

public class Feedback {
    // Declaring variables
    private Integer busId;
    private Integer routeId;
    private String user;
    private String message;

    // Setters and getters
    public Integer getBusId() {
        return busId;
    }
    public void setBusId(Integer busId) {
        this.busId = busId;
    }
    public Integer getRouteId() {
        return routeId;
    }
    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    // Override toString to print info later
    @Override
    public String toString() {
        return "Feedback{" +
                "user='" + user + '\'' +
                ", routeId=" + routeId +
                ", busId=" + busId +
                ", message='" + message + '\'' +
                '}';
    }
}
