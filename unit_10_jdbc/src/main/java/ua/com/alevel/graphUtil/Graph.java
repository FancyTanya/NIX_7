package ua.com.alevel.graphUtil;

import ua.com.alevel.model.Problem;
import ua.com.alevel.model.Solution;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {

    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node node) {
        nodes.add(node);
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

    public Graph calculateShortestWayFromSource(Graph graph, Node src) {
        src.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(src);

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);

            for (Map.Entry<Node, Integer> adjPair : currentNode.adjacentNodes.entrySet()) {
                Node adjNode = adjPair.getKey();
                Integer edgeWeight = adjPair.getValue();
                if (!settledNodes.contains(adjNode)) {
                    calculateMinDistance(adjNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    private Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node : unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private void calculateMinDistance(Node evaluationNode, Integer cost, Node sourceNode) {
        Integer srcDistance = sourceNode.getDistance();
        if ((srcDistance + cost) < evaluationNode.getDistance()) {
            evaluationNode.setDistance(srcDistance + cost);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    public List<Solution> solutionFromGraph(Graph graph, List<Problem> problems) {
        List<Solution> solutions = new ArrayList<>();

        for (Problem currentProblem: problems) {
            Node node = new Node(currentProblem.getFromId());

            graph.addNode(node);
            graph = graph.calculateShortestWayFromSource(graph, node);
        }

        Set<Node> nodes = graph.getNodes();
        for (Node res: nodes) {
            int id = res.getId();
            int distance = res.getDistance();
            Solution solution = new Solution(id, distance);
            solutions.add(solution);
        }
        return solutions;
    }
}
