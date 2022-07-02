package practice.design;

import practice.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {
    private final List<TreeNode> elements;
    private int index;

    public BSTIterator(TreeNode root) {
        elements = new ArrayList<>();
        index = 0;
        inOrderTraversal(root);
    }

    private void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        elements.add(root);
        inOrderTraversal(root.right);
    }

    public int next() {
        TreeNode node = elements.get(index);
        index++;
        return node.val;
    }

    public boolean hasNext() {
        return index < elements.size();
    }
}
