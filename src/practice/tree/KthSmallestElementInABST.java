package practice.tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        kthSmallestRec(root, k, res);
        return res.get(k - 1);
    }

    private void kthSmallestRec(TreeNode node, int k, List<Integer> res) {
        if (node == null) return;
        kthSmallestRec(node.left, k, res);
        res.add(node.val);
        kthSmallestRec(node.right, k, res);
    }
}
