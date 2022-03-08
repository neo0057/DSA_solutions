package practice.tree;

public class LongestUniValuePath {
    private int res;

    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        longestUnivaluePathRec(root);
        return res;
    }

    private int longestUnivaluePathRec(TreeNode root) {
        if (root == null) return 0;
        int leftCount, rightCount;
        leftCount = longestUnivaluePathRec(root.left);
        rightCount = longestUnivaluePathRec(root.right);
        int lLeft = 0;
        int rRight = 0;
        if (root.left != null && root.left.data == root.data) lLeft = leftCount + 1;
        if (root.right != null && root.right.data == root.data) rRight = rightCount + 1;
        res = Math.max(res, lLeft + rRight);
        return Math.max(lLeft, rRight);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(5);
        LongestUniValuePath longestUniValuePath = new LongestUniValuePath();
        System.out.println("longest Unique Path: " + longestUniValuePath.longestUnivaluePath(root));
    }
}
