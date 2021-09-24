package ua.com.alevel.service;

import ua.com.alevel.dao.ShortWayDao;
import ua.com.alevel.entity.Graph;
import ua.com.alevel.model.Route;

import java.util.ArrayList;
import java.util.List;

public class RouteService {
    private ShortWayDao shortWayDao = ShortWayDao.getInstance();
    List<Route> routes = new ArrayList<>();
    Graph graph;

    public Route create(int fromId, int toId, int cost) {
        Route newRoute = new Route(fromId, toId, cost);
        routes.add(newRoute);
        graph.addEdge(fromId, toId, cost);
        return newRoute;
    }

    public Route findById(int id) {
        Route route = routes.get(id);
        return route;
    }

    public List<Route> findAll() {
        return routes;
    }
}
