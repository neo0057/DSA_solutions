package practice.tree;

public class MaxSumPath {
    TreeNode root;
    private int res;

    public MaxSumPath() {
    }

    public MaxSumPath(TreeNode root) {
        this.root = root;
    }

    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        maxPathSumRec(root);
        return res;
    }

    private int maxPathSumRec(TreeNode root) {
        if (root == null) return 0;
        int leftSum = maxPathSumRec(root.left);
        int rightSum = maxPathSumRec(root.right);
        int maxSingle = Math.max(Math.max(leftSum, rightSum) + root.val, root.val);
        int maxOfAll = Math.max(maxSingle, leftSum + rightSum + root.val);
        res = Math.max(res, maxOfAll);
        return maxSingle;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        MaxSumPath maxSumPath = new MaxSumPath();
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(-25);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        System.out.println("maximum path sum is : " + maxSumPath.maxPathSum(root));
    }
}
