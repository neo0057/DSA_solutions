package practice.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch2 {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        for (String word : words) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    int len = dfs(board, i, j, word, visited, 0);
                    if (len == word.length()) res.add(word);
                }
            }
        }
        return new ArrayList<>(res);
    }

    private int dfs(char[][] board, int i, int j, String word, boolean[][] visited, int currIndex) {
        if (currIndex >= word.length()) return 0;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return 0;
        if (visited[i][j]) return 0;
        if (board[i][j] != word.charAt(currIndex)) return 0;
        visited[i][j] = true;
        int left = dfs(board, i, j - 1, word, visited, currIndex + 1);
        int right = dfs(board, i, j + 1, word, visited, currIndex + 1);
        int up = dfs(board, i - 1, j, word, visited, currIndex + 1);
        int down = dfs(board, i + 1, j, word, visited, currIndex + 1);
        visited[i][j] = false;
        return Math.max(Math.max(left, right), Math.max(up, down)) + 1;
    }
}
