package practice.backtracking;

public class BeautifulArrangement {
    int res;

    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        res = 0;
        countArrangementRec(n, visited, 1);
        return res;
    }

    private void countArrangementRec(int n, boolean[] visited, int currNumber) {
        if (currNumber > n) res++;
        else {
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && (i % currNumber == 0 || currNumber % i == 0)) {
                    visited[i] = true;
                    countArrangementRec(n, visited, currNumber + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        BeautifulArrangement beautifulArrangement = new BeautifulArrangement();
        Long start = System.currentTimeMillis();
        System.out.println(beautifulArrangement.countArrangement(15));
        Long end = System.currentTimeMillis();
        System.out.println("time: " + (double) (end - start) + " ms");
    }
}
