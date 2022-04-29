package practice.tree;

import java.util.ArrayList;
import java.util.List;

public class ElementsInTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> treeElements1 = new ArrayList<>();
        List<Integer> treeElements2 = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        inorder(root1, treeElements1);
        inorder(root2, treeElements2);
        int i1 = 0, i2 = 0;
        while (i1 < treeElements1.size() && i2 < treeElements2.size()) {
            if (treeElements1.get(i1) < treeElements2.get(i2)) {
                res.add(treeElements1.get(i1));
                i1++;
            } else {
                res.add(treeElements2.get(i2));
                i2++;
            }
        }
        while (i1 < treeElements1.size()) {
            res.add(treeElements1.get(i1));
            i1++;
        }
        while (i2 < treeElements2.size()) {
            res.add(treeElements2.get(i2));
            i2++;
        }
        return res;
    }

    private void inorder(TreeNode root, List<Integer> treeElements) {
        if (root == null) return;
        inorder(root.left, treeElements);
        treeElements.add(root.val);
        inorder(root.right, treeElements);
    }
}
