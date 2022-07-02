package interviews.india.careem;

import practice.graph.Graph;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public int solution(int A, int B) {
        long res = (long) A * B;
        return countSetBits(res);
    }

    public boolean solution(int N, int[] A, int[] B) {
        Graph graph = new Graph(N, false);
        int noOfEdges = A.length;
        for (int i = 0; i < noOfEdges; i++) graph.addEdge(A[i], B[i]);
        int startVertex = 1;
        while (true) {
            List<Integer> edges = graph.getAdjacencyMatrix().get(startVertex);
            if (edges.contains(startVertex + 1)) startVertex++;
            else break;
        }
        return startVertex == N;
    }

    public int[] solution(int[] A, int F, int M) {
        int[] res = new int[F];
        int numberOfRolls = A.length + F;
        int sumOfRolls = M * numberOfRolls;
        int sumOfKnownRolls = 0;

        for (int rollValue : A) sumOfKnownRolls += rollValue;
        int sumOfUnknownRolls = sumOfRolls - sumOfKnownRolls;
        //if the sumOfUnknownRolls is out of range:
        if (sumOfUnknownRolls < F || sumOfUnknownRolls > 6 * F) return new int[1];
        /*all is left is to return one of the possible solutions. we will "fill" the dice results
         * with the maximum values possible (6 if possible), and when we hit the "lower bound" (meaning the
         * sumOfUnknownRolls left is equal to the number of rolls left) it means the rest of the
         * dice rolls are "1".*/
        for (int i = 0; i < res.length; i++) {
            if (sumOfUnknownRolls - (F - 1) <= 6) {
                res[i] = sumOfUnknownRolls - (F - 1);
                Arrays.fill(res, i + 1, res.length, 1);
                break;
            } else {
                res[i] = 6;
                sumOfUnknownRolls -= 6;
                F--;
            }
        }
        return res;
    }

    private int countSetBits(long n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(100000000, 100000000));
        System.out.println(solution.solution(1, 100000000));
    }
}
