package practice.array;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) lastIndex[s.charAt(i) - 'a'] = i;
        boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            if (visited[curr]) continue;
            while ((!stack.isEmpty()) && stack.peek() > curr && i < lastIndex[stack.peek()])
                visited[stack.pop()] = false;
            stack.push(curr);
            visited[curr] = true;
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) res.append((char) (stack.pop() + 'a'));
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
        System.out.println(removeDuplicateLetters.removeDuplicateLetters("bcabc"));
        System.out.println(removeDuplicateLetters.removeDuplicateLetters("cbacdcbc"));
    }
}
