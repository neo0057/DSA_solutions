package practice.graph;

import java.util.Stack;

public class TopologicalSort {

    private final Graph graph;

    TopologicalSort(int v) {
        this.graph = new Graph(v, true);
    }

    public void addGraphEdge(int a, int b) {
        this.graph.addEdge(a, b);
    }

    public void printTopologicalSort() {
        Stack<Integer> stack = new Stack<>();
        int numberOfVertices = this.graph.getNumberOfVertices();
        boolean[] visited = new boolean[numberOfVertices];
        for (int v = 0; v < numberOfVertices; v++) {
            if (!visited[v]) topologicalSortUtil(v, visited, stack);
        }
        while (!stack.empty()) System.out.print(stack.pop() + " ");
    }

    private void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (int child : this.graph.getAdjacencyMatrix().get(v)) {
            if (!visited[child]) topologicalSortUtil(child, visited, stack);
        }
        stack.push(v);
    }

    public static void main(String[] args) {
        TopologicalSort topologicalSort = new TopologicalSort(6);
        topologicalSort.addGraphEdge(5, 2);
        topologicalSort.addGraphEdge(5, 0);
        topologicalSort.addGraphEdge(4, 0);
        topologicalSort.addGraphEdge(4, 1);
        topologicalSort.addGraphEdge(2, 3);
        topologicalSort.addGraphEdge(3, 1);

        System.out.println("Following is a Topological sort of the given graph");
        // Function Call
        topologicalSort.printTopologicalSort();
    }
}
