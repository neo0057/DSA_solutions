package practice.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final boolean isDirectedGraph;
    private final int numberOfVertices;
    private final List<List<Integer>> adjacencyMatrix;

    public Graph(int numberOfVertices, boolean isDirectedGraph) {
        this.numberOfVertices = numberOfVertices;
        this.isDirectedGraph = isDirectedGraph;
        this.adjacencyMatrix = new ArrayList<>();
        for (int i = 0; i < this.numberOfVertices; i++) this.adjacencyMatrix.add(new ArrayList<>());
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public List<List<Integer>> getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public boolean isDirectedGraph() {
        return isDirectedGraph;
    }

    public void addEdge(int a, int b) {
        adjacencyMatrix.get(a).add(b);
        if (!isDirectedGraph()) adjacencyMatrix.get(b).add(a);
    }
}
