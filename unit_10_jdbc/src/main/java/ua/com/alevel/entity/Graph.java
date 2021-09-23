package ua.com.alevel.entity;


public class Graph {

    private final int MAX_VERTS = 20;
    private final int INFINITY = 1000000;
    private Vertex[] vertexList;
    private int[][] adjacencyMatrix;
    private int vertexAmount;
    private int currentVert;
    private int amountVertsInTree;
    private DistanceParent[] shortestPath;
    private int vertexAmountInTree;
    private int startToCurrent;
    private int startCity;


    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjacencyMatrix = new int[MAX_VERTS][MAX_VERTS];
        vertexAmount = 0;
        amountVertsInTree = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjacencyMatrix[i][j] = INFINITY;
                shortestPath = new DistanceParent[MAX_VERTS];
            }
        }
    }

    public void addVertex(String cityName) {
        vertexList[vertexAmount++] = new Vertex(cityName);
    }

    public void addEdge(int start, int end, int cost) {
        adjacencyMatrix[start][end] = cost;
        adjacencyMatrix[end][start] = cost;
    }

    public void path(int[][] adjacencyMatrix) {
        int startTree = 1;
        vertexList[startTree].isInTree = true;
        amountVertsInTree = 1;
        for (int i = 0; i < amountVertsInTree; i++) {
            int tempDistance = adjacencyMatrix[startTree][i];
            shortestPath[i] = new DistanceParent(startTree, tempDistance);
        }
        while (amountVertsInTree < vertexAmount) {
            int indexMin = getMin();
            int minDistance = shortestPath[indexMin].distance;

            if (minDistance == INFINITY) {
                System.out.println("There are unreachable vertices");
                break;
            } else {
                currentVert = indexMin;
                startToCurrent = shortestPath[indexMin].distance;
            }
            vertexList[currentVert].isInTree = false;
        }
    }

    public int getMin() {
        int minDistance = INFINITY;
        int minIndex = 0;
        for (int i = 0; i < vertexAmount; i++) {
            if (!vertexList[i].isInTree && shortestPath[i].distance < minDistance) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public String displayPaths() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < vertexAmount; i++) {
            result.append(vertexList[i].cityName).append(" = ");
            if (shortestPath[i].distance == INFINITY) {
                result.append("INFINITY");
            } else {
                result.append(shortestPath[i].distance);
                String parent = vertexList[shortestPath[i].parentVert].cityName;
                result.append(" ( " + parent + " )");
            }
        }
        return result.toString();
    }
}
