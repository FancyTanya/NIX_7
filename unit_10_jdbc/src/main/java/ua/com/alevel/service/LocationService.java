package ua.com.alevel.service;

import ua.com.alevel.dao.ShortWayDao;
import ua.com.alevel.entity.Graph;
import ua.com.alevel.model.Location;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class LocationService {
    private ShortWayDao shortWayDao = new ShortWayDao();
    List<Location> locations = new ArrayList<>();
    Location location;
    Graph graph;
    private final Connection connection;

    public LocationService(Connection connection) {
        this.connection = connection;
    }

    public Location create(String name) {
        Location newLocation = new Location(name);
        locations.add(newLocation);
        graph.addVertex(name);
        return newLocation;
    }

    public Location findById(int id) {
        Location location = locations.get(id);
        return location;
    }

    public List<Location> findAll() {
        return locations;
    }

    public String getName() {
       return location.getName();
    }
}
