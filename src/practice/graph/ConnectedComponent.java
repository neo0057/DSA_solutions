package practice.graph;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponent {

    private final Graph graph;

    public ConnectedComponent(int numberOfVertices) {
        this.graph = new Graph(numberOfVertices, false);
    }

    public void addGraphEdge(int a, int b) {
        this.graph.addEdge(a, b);
    }

    public int getNumberOfConnectedComponents() {
        int res = 0;
        List<List<Integer>> connectedComponents = new ArrayList<>();
        boolean[] visited = new boolean[this.graph.getNumberOfVertices()];
        for (int v = 0; v < this.graph.getNumberOfVertices(); v++) {
            List<Integer> connectedVertices = new ArrayList<>();
            if (!visited[v]) {
                connectedComponentRec(v, visited, connectedVertices);
                connectedComponents.add(connectedVertices);
                System.out.println();
                res++;
            }
        }
        System.out.println("connected components size: " + connectedComponents.size());
        return res;
    }

    private void connectedComponentRec(int v, boolean[] visited, List<Integer> connectedVertices) {
        visited[v] = true;
        connectedVertices.add(v);
        System.out.print(v + " ");
        for (Integer child : this.graph.getAdjacencyMatrix().get(v)) {
            if (!visited[child]) connectedComponentRec(child, visited, connectedVertices);
        }
    }

    public static void main(String[] args) {
        ConnectedComponent connectedComponent = new ConnectedComponent(5);
        connectedComponent.addGraphEdge(1, 0);
        connectedComponent.addGraphEdge(2, 3);
        connectedComponent.addGraphEdge(3, 4);
        System.out.println("number of connected components: " + connectedComponent.getNumberOfConnectedComponents());
    }
}
