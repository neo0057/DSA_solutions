package interviews.india.zeta;

import practice.tree.TreeNode;

public class MaxPathSum {
    private int ans;

	int maxPathSum(TreeNode root) {
		 ans = Integer.MIN_VALUE;
		 maxPathSumRec(root);
		 return ans;
	}
    Integer maxPathSumRec(TreeNode root) {
        if (root == null) return 0;
        int leftPathSum = maxPathSumRec(root.left);
        int rightPathSum = maxPathSumRec(root.right);
        int maxChild = Math.max(leftPathSum, rightPathSum);
		int childSum = leftPathSum + rightPathSum;
        ans = Math.max(Math.max(Math.max(maxChild + root.val, root.val), childSum + root.val), ans);
        return Math.max(Math.max(Math.max(leftPathSum, rightPathSum) + root.val, root.val), childSum + root.val);
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(5);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(1);
		MaxPathSum maxPathSum = new MaxPathSum();
		System.out.println(maxPathSum.maxPathSum(root));
	}

}
