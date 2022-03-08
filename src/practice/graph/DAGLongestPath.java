package practice.graph;

public class DAGLongestPath {

    private final Graph graph;

    public DAGLongestPath(int v) {
        this.graph = new Graph(v, true);
    }

    public void addGraphEdge(int v, int u) {
        this.graph.addEdge(v, u);
    }

    public int getLongestPathLength() {
        boolean[] visited = new boolean[this.graph.getNumberOfVertices()];
        int[] dp = new int[this.graph.getNumberOfVertices()];
        for (int v = 0; v < this.graph.getNumberOfVertices(); v++) {
            if (!visited[v]) longestPathRec(v, visited, dp);
        }
        int res = 0;
        for (int i = 0; i < this.graph.getNumberOfVertices(); i++) res = Math.max(res, dp[i]);
        return res;
    }

    private void longestPathRec(int node, boolean[] visited, int[] dp) {
        visited[node] = true;
        for (int child : this.graph.getAdjacencyMatrix().get(node)) {
            if (!visited[child]) longestPathRec(child, visited, dp);
            dp[node] = Math.max(dp[node], dp[child] + 1);
        }
    }

    public static void main(String[] args) {
        int v = 4;
        DAGLongestPath dagLongestPath = new DAGLongestPath(v);
        dagLongestPath.addGraphEdge(0, 1);
        dagLongestPath.addGraphEdge(0, 2);
        dagLongestPath.addGraphEdge(2, 1);
        dagLongestPath.addGraphEdge(1, 3);
        dagLongestPath.addGraphEdge(2, 3);
        System.out.println("longest path in DAG: " + dagLongestPath.getLongestPathLength());
    }

}
