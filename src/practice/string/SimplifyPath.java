package practice.string;

import java.util.Stack;

/**
 * https://leetcode.com/problems/simplify-path/
 */
public class SimplifyPath {
    public static String simplifyPath(String path) {
        String[] dirArray = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String dir : dirArray) {
            dir = (dir != null) ? dir.trim() : "";
            if (dir.length() == 0) continue;
            if (dir.equals(".")) continue;
            if (dir.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else stack.push(dir);
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        if (res.length() == 0) res += "/";
        return res;
    }

    public static void main(String[] args) {
        String path = "/home/";
        String path2 = "/../";
        String path3 = "/home//foo/bar/../foo1";

        System.out.println(path + " -> " + simplifyPath(path));
        System.out.println(path2 + " -> " + simplifyPath(path2));
        System.out.println(path3 + " -> " + simplifyPath(path3));
    }
}
