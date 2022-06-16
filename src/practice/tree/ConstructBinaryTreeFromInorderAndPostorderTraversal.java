package practice.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    int rootIndex;
    Map<Integer, Integer> inOrderMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        rootIndex = n - 1;
        inOrderMap = new HashMap<>();
        for (int i = 0; i < n; i++) inOrderMap.put(inorder[i], i);
        return buildTreeRec(postorder, 0, n - 1);
    }

    private TreeNode buildTreeRec(int[] postorder, int startIndex, int endIndex) {
        if (rootIndex < 0 || startIndex > endIndex) return null;
        int rootVal = postorder[rootIndex--];
        TreeNode root = new TreeNode(rootVal);
        if (startIndex == endIndex) return root;
        int inOrderIndex = inOrderMap.get(rootVal);
        root.left = buildTreeRec(postorder, startIndex, inOrderIndex);
        root.right = buildTreeRec(postorder, inOrderIndex + 1, endIndex);
        return root;
    }
}
