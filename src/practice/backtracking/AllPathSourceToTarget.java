package practice.backtracking;

import java.util.ArrayList;
import java.util.List;

public class AllPathSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int s = 0;
        int t = graph.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(s);
        allPathsSourceTargetRec(graph, s, t, path, res);
        return res;
    }

    private void allPathsSourceTargetRec(int[][] graph, int s, int t, List<Integer> path, List<List<Integer>> res) {
        if (s == t) {
            res.add(new ArrayList<>(path));
            return;
        }
        int[] childs = graph[s];
        for (int i : childs) {
            path.add(i);
            allPathsSourceTargetRec(graph, i, t, path, res);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[4][];
        graph[0] = new int[]{1, 2};
        graph[1] = new int[]{3};
        graph[2] = new int[]{3};
        graph[3] = new int[]{};
        AllPathSourceToTarget allPathSourceToTarget = new AllPathSourceToTarget();
        List<List<Integer>> res = allPathSourceToTarget.allPathsSourceTarget(graph);
        for (List<Integer> list : res) {
            for (Integer path : list) System.out.print(path + " ");
            System.out.println();
        }
    }
}
