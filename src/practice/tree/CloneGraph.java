package practice.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    Map<Integer, Node> visited;

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node copyNode = new Node(node.val);
        visited = new HashMap<>();
        cloneGraphRec(node, copyNode, visited);
        return copyNode;
    }

    private void cloneGraphRec(Node node, Node copyNode, Map<Integer, Node> visited) {
        visited.put(copyNode.val, copyNode);
        for (Node node1 : node.neighbors) {
            if (!visited.containsKey(node1.val)) {
                Node newNode = new Node(node1.val);
                copyNode.neighbors.add(newNode);
                cloneGraphRec(node1, newNode, visited);
            } else {
                copyNode.neighbors.add(visited.get(node1.val));
            }
        }
    }
}
