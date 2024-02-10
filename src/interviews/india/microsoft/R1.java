package interviews.india.microsoft;
// https://app.codility.com/c/feedback/56DK48-3RT/
public class R1 {

    public String solution2(int N) {
        StringBuilder res = new StringBuilder();
        int freq = N / 26 + ((N % 26 > 0) ? 1 : 0);
        int t = N / freq;
        char[] alphabets = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < freq; j++) res.append(alphabets[i]);
        }
        return res.toString();
    }

    int[][] safeMatrix;
    boolean[][] visited;

    public boolean solution(String[] B) {
        int row = B.length;
        int col = B[0].length();

        safeMatrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char currChar = B[i].charAt(j);
                if (isGuard(currChar)) markObstacles(B, currChar, i, j);
            }
        }

        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (B[i].charAt(j) == 'A') return dfs(B, i, j, row, col);
            }
        }
        return false;
    }

    private boolean dfs(String[] grid, int i, int j, int row, int col) {
        if (i == row - 1 && j == col - 1 && safeMatrix[i][j] == 0) return true;
        if (i < 0 || j < 0 || i >= row || j >= col || visited[i][j] || grid[i].charAt(j) == 'X' || isGuard(grid[i].charAt(j)) || safeMatrix[i][j] == 1) {
            return false;
        }
        visited[i][j] = true;
        return dfs(grid, i - 1, j, row, col)
                || dfs(grid, i + 1, j, row, col)
                || dfs(grid, i, j - 1, row, col)
                || dfs(grid, i, j + 1, row, col);
    }

    private void markObstacles(String[] B, char ch, int r, int c) {
        int i;
        switch (ch) {
            case '<':
                i = c - 1;
                while (i >= 0 && (B[r].charAt(i) == '.' || B[r].charAt(i) == 'A')) {
                    safeMatrix[r][i] = 1;
                    i--;
                }
                break;
            case '>':
                i = c + 1;
                while (i < safeMatrix[0].length && (B[r].charAt(i) == '.' || B[r].charAt(i) == 'A')) {
                    safeMatrix[r][i] = 1;
                    i++;
                }
                break;
            case '^':
                i = r - 1;
                while (i >= 0 && (B[i].charAt(c) == '.' || B[i].charAt(c) == 'A')) {
                    safeMatrix[i][c] = 1;
                    i--;
                }
                break;
            case 'v':
                i = r + 1;
                while (i < safeMatrix.length && (B[i].charAt(c) == '.' || B[i].charAt(c) == 'A')) {
                    safeMatrix[i][c] = 1;
                    i++;
                }
                break;
        }
    }

    private boolean isGuard(char ch) {
        return ch == '<' || ch == '>' || ch == '^' || ch == 'v';
    }

    public static void main(String[] args) {
        String[] B1 = {"X.....>", "..v..X.", ".>..X..", "A......"};
        String[] B2 = {"...Xv", "AX..^", ".XX.."};
        String[] B3 = {"...", ">.A"};
        String[] B4 = {"A.v", "..."};
        R1 r1 = new R1();
        System.out.println(r1.solution(B1));
        System.out.println(r1.solution(B2));
        System.out.println(r1.solution(B3));
        System.out.println(r1.solution(B4));
    }
}
