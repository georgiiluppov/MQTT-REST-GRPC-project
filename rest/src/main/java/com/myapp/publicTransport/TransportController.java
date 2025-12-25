package com.myapp.publicTransport;

import org.springframework.web.bind.annotation.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

// Mark this class as a REST controller to handle HTTP requests
@RestController
// Base URL path for all endpoints in this controller
@RequestMapping("/api")
public class TransportController {

    // GET /api//routes
    // Returns a list of predefined routes
    @GetMapping("/routes")
    public List<Route> getRoutes() {
        ArrayList<Route> routes = new ArrayList<>();

        // Creating and adding sample Route objects to the list
        Route route1 = new Route(1, "Route 101", "Bus");
        routes.add(route1);

        Route route2 = new Route(2, "Route 102", "Bus");
        routes.add(route2);

        Route route3 = new Route(3, "Route 103", "Bus");
        routes.add(route3);

        return routes;
    }

    // GET /api//routes/busesLive
    // Returns a list of buses currently running on a randomly selected route
    @GetMapping("/routes/busesLive")
    public List<BusLocation> getBusesOnRoute() {
        ArrayList<BusLocation> buses = new ArrayList<>();
        // Select a random route number between 1 and 3
        int randomRoute = (int) (Math.random() * 3) + 1;
        // Buses location info depending on the random route
        if (randomRoute == 1) {
            buses.add(new BusLocation(101, 53.347625305418326, -6.2590545814028005, "On Time"));
        } else if (randomRoute == 2) {
            buses.add(new BusLocation(201, 53.34885852669177, -6.237723634360727, "On Time"));
        } else {
            buses.add(new BusLocation(301, 53.34804160690227, -6.247478167395365, "Delayed"));
        }
        return buses;
    }

    // POST /api/feedback
    // Accepts feedback data in the request body and returns a confirmation message
    @PostMapping("/feedback")
    public String postFeedback(@RequestBody Feedback feedback) {
        System.out.println(LocalTime.now() + "Feedback submitted successfully.");
        return "Feedback submitted successfully. " + feedback;
    }
}
