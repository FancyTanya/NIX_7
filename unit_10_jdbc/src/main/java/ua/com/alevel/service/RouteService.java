package ua.com.alevel.service;

import ua.com.alevel.dao.RouteDao;
import ua.com.alevel.dao.ShortWayDao;
import ua.com.alevel.entity.Graph;
import ua.com.alevel.model.Route;

import java.util.ArrayList;
import java.util.List;

public class RouteService {
    private ShortWayDao shortWayDao = new ShortWayDao();
    List<Route> routes = new ArrayList<>();
    RouteDao routeDao;
    Graph graph;

    public Route create(int fromId, int toId, int cost) {
        Route newRoute = new Route(fromId, toId, cost);
        routes.add(newRoute);
        graph.addEdge(fromId, toId, cost);
        return newRoute;
    }

    public RouteDao findById(int id) {
        routeDao.findById(id);
        return routeDao;
    }

    public List<Route> findAll() {
        return routes;
    }
}
