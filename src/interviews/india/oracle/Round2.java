package interviews.india.oracle;

public class Round2 {

    private int pass;
    private Node root;

    public Round2() {
        this.pass = 0;
        this.root = null;
    }

    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void findElementInBST(Node root, int key) {
        if (root == null) return;
        if (root.data == key) {
            System.out.println("found element in tree, passes: " + pass);
            return;
        }
        if (root.data > key) {
            pass++;
            findElementInBST(root.left, key);
        } else {
            pass++;
            findElementInBST(root.right, key);
        }
    }

    public Node insertInBSTRec(Node node, int e) {
        if (node == null) {
            return new Node(e);
        }

        if (node.data > e) {
            node.left = insertInBSTRec(node.left, e);
        }
        else {
            node.right = insertInBSTRec(node.right, e);
        }
        return node;
    }

    public void insertInBST(int[] data) {
        for (int e : data) {
            if (this.root == null) this.root = new Node(e);
            else insertInBSTRec(this.root, e);
        }
    }

    public void printBST(Node node, int flag) {
        if (node == null) return;
        printBST(node.left, -1);
        System.out.println(node.data + ", " + flag);
        printBST(node.right, 1);
    }

    /**
     *              5
     *          3       6
     *              10      20
     *                  15      30
     *              10
     *
     *
     * @param args
     */

    public static void main(String[] args) {
        Round2 r2 = new Round2();
        int[] arr = {5, 3, 6, 20, 15, 30, 10, 10, 5, 30};
        r2.insertInBST(arr);
        r2.findElementInBST(r2.root, 30);
        r2.printBST(r2.root, 0);
    }
}
