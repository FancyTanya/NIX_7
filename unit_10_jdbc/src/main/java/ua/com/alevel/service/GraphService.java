package ua.com.alevel.service;

import ua.com.alevel.dao.ProblemDao;
import ua.com.alevel.dao.RouteDao;
import ua.com.alevel.entity.Graph;
import ua.com.alevel.model.Location;
import ua.com.alevel.model.Route;
import ua.com.alevel.model.Solution;

import java.util.List;

public class GraphService {

    private final Graph graph = new Graph();
    private RouteService routeService;
    private LocationService locationService;
    private RouteDao routeDao;
    private ProblemDao problemDao ;
//    private GraphService graphService = new GraphService();

    public GraphService(ProblemDao problemDao, LocationService locationService) {
        this.problemDao = problemDao;
        this.locationService = locationService;
    }

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

    public List<Solution> shortWayPath() {
        return graph.listOfSolutions();
    }

    public List<Solution> startGraphService() {
        Graph graph = this.addEdgeToGraph();
        this.addVertexToGraph();
        List<Solution> shortWayPathList = this.shortWayPath();
        return shortWayPathList;
    }

}
