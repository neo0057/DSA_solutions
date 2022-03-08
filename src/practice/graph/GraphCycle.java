package practice.graph;

import java.util.List;
import java.util.stream.IntStream;

public class GraphCycle {
    private final Graph graph;

    public GraphCycle(int v) {
        this.graph = new Graph(v, false);
    }

    public GraphCycle(int v, boolean isDirectedGraph) {
        this.graph = new Graph(v, isDirectedGraph);
    }

    public void addGraphEdge(int a, int b) {
        this.graph.addEdge(a, b);
    }

    public boolean isCycle() {
        boolean[] visited = new boolean[this.graph.getNumberOfVertices()];
        boolean[] recursionStack = new boolean[this.graph.getNumberOfVertices()];
        return IntStream.range(0, this.graph.getNumberOfVertices() - 1).anyMatch(vertex -> isCycleUtil(vertex, -1, visited, recursionStack));
    }

    private boolean isCycleUtil(int node, int nodeParent, boolean[] visited, boolean[] recursionStack) {
        if (recursionStack[node]) return true; // if part of recursion stack, return true
        if (visited[node]) return false; // if already processed, means no cycle
        visited[node] = true;
        recursionStack[node] = true;
        List<Integer> childList = this.graph.getAdjacencyMatrix().get(node);
        for (Integer child : childList) {
            if (!visited[child]) isCycleUtil(child, node, visited, recursionStack);
            else if (child != nodeParent) return true;
        }
        recursionStack[node] = false; // mark as not part of recursion
        return false;
    }

    public static void main(String[] args) {
        GraphCycle directedGraphCycle = new GraphCycle(4, true);
        directedGraphCycle.addGraphEdge(0, 1);
        directedGraphCycle.addGraphEdge(0, 2);
        directedGraphCycle.addGraphEdge(1, 2);
        directedGraphCycle.addGraphEdge(2, 0);
        directedGraphCycle.addGraphEdge(2, 3);
        directedGraphCycle.addGraphEdge(3, 3);
        long start = System.currentTimeMillis();
        boolean isCycle = directedGraphCycle.isCycle();
        long end = System.currentTimeMillis();
        System.out.println("is cycle in directed graph: " + isCycle + ", time taken: " + (end - start) + " ms");
        GraphCycle graphCycle = new GraphCycle(3);
        graphCycle.addGraphEdge(0, 1);
        graphCycle.addGraphEdge(1, 2);
//        graphCycle.addGraphEdge(2, 0); // uncomment this line to make it cyclic graph
        start = System.currentTimeMillis();
        isCycle = graphCycle.isCycle();
        end = System.currentTimeMillis();
        System.out.println("is cycle in un-directed graph: " + isCycle + ", time taken: " + (end - start) + " ms");
    }
}
