package practice.tree;

import java.util.*;

public class BinaryTreeSolutions {

    static class Height {
        public int value;
    }

    public static int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    private static int diameterRec(TreeNode root, Height height) {
        // since java does not have pointers, we have to use a wrapper object to maintain height
        Height leftHeight = new Height();
        Height rightHeight = new Height();
        if (root == null) {
            height.value = 0;
            return 0;
        }
        int leftDiameter = diameterRec(root.left, leftHeight);
        int rightDiameter = diameterRec(root.right, rightHeight);
        height.value = Math.max(leftHeight.value, rightHeight.value) + 1;
        return Math.max(leftHeight.value + rightHeight.value + 1, Math.max(leftDiameter, rightDiameter));
    }

    public static int diameter(TreeNode root) {
        Height height = new Height();
        return diameterRec(root, height);
    }

    public static void printLevelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int count, level = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            count = queue.size();
            System.out.print("printing level " + level + " elements: ");
            while (count-- > 0) {
                TreeNode treeNode = queue.poll();
                if (treeNode == null) continue;
                System.out.print(treeNode.data + " ");
                if (treeNode.left != null) queue.add(treeNode.left);
                if (treeNode.right != null) queue.add(treeNode.right);
            }
            level++;
            System.out.println();
        }
    }

    public static void zigZagLevelOrderTraversal(TreeNode root) {
        if (root == null) return;
        System.out.println("printing zigzag level order traversal of tree: ");
        Deque<TreeNode> deque = new ArrayDeque<>();
        boolean reverse = false;
        deque.offer(root);
        while (!deque.isEmpty()) {
            int count = deque.size();
            if (!reverse) {
                while (count-- > 0) {
                    TreeNode first = deque.peekFirst();
                    if (first == null) continue;
                    if (first.left != null) deque.offerLast(first.left);
                    if (first.right != null) deque.offerLast(first.right);
                    System.out.print(deque.pollFirst().data + " ");
                }
            } else {
                while (count-- > 0) {
                    TreeNode last = deque.peekLast();
                    if (last == null) continue;
                    if (last.right != null) deque.offerFirst(last.right);
                    if (last.left != null) deque.offerFirst(last.left);
                    System.out.print(deque.pollLast().data + " ");
                }
            }
            reverse = !reverse;
            System.out.println();
        }
    }

    public static void printIterativeInOrderTraversal(TreeNode root) {
        if (root == null) return;
        System.out.print("printing iterative inorder traversal: ");
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
        System.out.println();
    }

    /**
     * https://leetcode.com/problems/find-bottom-left-tree-value/
     *
     * @param node
     */
    public int bottomLeftTreeValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int count, level = 0;
        int res = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            count = queue.size();
            res = queue.peek().data;
            while (count-- > 0) {
                TreeNode treeNode = queue.poll();
                if (treeNode == null) continue;
                if (treeNode.left != null) queue.add(treeNode.left);
                if (treeNode.right != null) queue.add(treeNode.right);
            }
        }
        return res;
    }

    /**
     * https://leetcode.com/problems/find-largest-value-in-each-tree-row/
     *
     * @param root
     * @return
     */
    public List<Integer> largestValuesInEachLevel(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int count, res;
        List<Integer> result = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            count = queue.size();
            res = Integer.MIN_VALUE;
            while (count-- > 0) {
                TreeNode treeNode = queue.poll();
                if (treeNode == null) continue;
                res = Math.max(res, treeNode.data);
                if (treeNode.left != null) queue.add(treeNode.left);
                if (treeNode.right != null) queue.add(treeNode.right);
            }
            result.add(res);
        }
        return result;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = root;
        insertIntoBSTRec(node, val);
        return root;
    }

    public void insertIntoBSTRec(TreeNode root, int val) {
        if (root == null) return;
        System.out.println(root.data);
        if (root.left == null && root.right == null) {
            if (root.data < val) root.right = new TreeNode(val);
            else root.left = new TreeNode(val);
        }
        if (root.data < val) insertIntoBST(root.right, val);
        insertIntoBST(root.right, val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        System.out.println("height of tree: " + height(root));
        System.out.println("diameter of tree: " + diameter(root));
        printIterativeInOrderTraversal(root);
        printLevelOrderTraversal(root);
        zigZagLevelOrderTraversal(root);
    }
}
