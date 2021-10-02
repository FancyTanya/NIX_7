package ua.com.alevel.service;

import ua.com.alevel.dao.ProblemDao;
import ua.com.alevel.dao.RouteDao;
import ua.com.alevel.dao.ShortWayDao;
import ua.com.alevel.entity.Graph;
import ua.com.alevel.model.Location;
import ua.com.alevel.model.Problem;
import ua.com.alevel.model.Route;

import java.util.HashMap;
import java.util.List;

public class GraphService {

    private final Graph graph = new Graph();
    private RouteService routeService;
    private LocationService locationService;
    private RouteDao routeDao;
    private ProblemDao problemDao;
    private GraphService graphService;

    public Graph addEdgeToGraph() {
        for (Route route : problemDao.routesForSolution()) {
            graph.addEdge(route.getFromId(), route.getToId(), route.getCost());
        }
        return graph;
    }

    public Graph addVertexToGraph() {
        for (Location location : locationService.findAll()) {
            graph.addVertex(location.getName());
        }
        return graph;
    }

    public HashMap shortWayPath() {
        return graph.mapOfVertexAndMinDistance();
    }

    public HashMap startGraphService() {
        var graph = graphService.addEdgeToGraph();
        graphService.addVertexToGraph();
        HashMap shortWayPathMap = graphService.shortWayPath();
        return shortWayPathMap;
    }

}
