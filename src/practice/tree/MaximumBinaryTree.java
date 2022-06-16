package practice.tree;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] arr) {
        int n = arr.length;
        return constructMaximumBinaryTreeRec(arr, 0, n - 1);
    }

    private TreeNode constructMaximumBinaryTreeRec(int[] arr, int startIndex, int endIndex) {
        if (startIndex > endIndex) return null;
        if (startIndex == endIndex) return new TreeNode(arr[startIndex]);
        int maxIndex = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] > arr[maxIndex]) maxIndex = i;
        }
        TreeNode root = new TreeNode(arr[maxIndex]);
        root.left = constructMaximumBinaryTreeRec(arr, startIndex, maxIndex - 1);
        root.right = constructMaximumBinaryTreeRec(arr, maxIndex + 1, endIndex);
        return root;
    }
}
