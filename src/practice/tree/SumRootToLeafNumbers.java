package practice.tree;

public class SumRootToLeafNumbers {
    private int sum;

    public int sumNumbers(TreeNode root) {
        sum = 0;
        sumNumbersRec(root, 0);
        return sum;
    }

    private void sumNumbersRec(TreeNode root, int prvSum) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sum += prvSum*10 + root.val;
            return;
        }
        sumNumbersRec(root.left, prvSum * 10 + root.val);
        sumNumbersRec(root.right, prvSum * 10 + root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(0);
        root2.left.left = new TreeNode(5);
        root2.left.right = new TreeNode(1);

        SumRootToLeafNumbers sumRootToLeafNumbers = new SumRootToLeafNumbers();
        System.out.println("left sum for tree1 : " + sumRootToLeafNumbers.sumNumbers(root));
        System.out.println("left sum for tree2 : " + sumRootToLeafNumbers.sumNumbers(root2));
    }
}
