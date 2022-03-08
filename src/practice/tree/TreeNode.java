package practice.tree;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public static void preOrderTraversal(TreeNode root) {
        if (root == null) return;
        System.out.println(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    public static void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
    }
    public static void postOrderTraversal(TreeNode root) {
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.data);
    }
}
