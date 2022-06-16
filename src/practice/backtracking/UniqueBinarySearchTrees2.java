package practice.backtracking;

import practice.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees2 {
    public List<TreeNode> generateTrees(int n) {
        return generateTreesRec(1, n);
    }

    private List<TreeNode> generateTreesRec(int start, int end) {
        if (start > end) {
            List<TreeNode> list = new ArrayList<>();
            list.add(null);
            return list;
        }
        List<TreeNode> allRootNodes = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubTree = generateTreesRec(start, i - 1);
            List<TreeNode> rightSubTree = generateTreesRec(i + 1, end);
            for (TreeNode left : leftSubTree) {
                for (TreeNode right : rightSubTree) {
                    TreeNode node = new TreeNode(i, left, right);
                    allRootNodes.add(node);
                }
            }
        }
        return allRootNodes;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees2 uniqueBinarySearchTrees2 = new UniqueBinarySearchTrees2();
        System.out.println(uniqueBinarySearchTrees2.generateTrees(3));
    }
}
