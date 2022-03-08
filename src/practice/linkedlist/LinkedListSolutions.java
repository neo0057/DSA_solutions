package practice.linkedlist;

public class LinkedListSolutions {
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode root = null;
        ListNode temp = null;
        ListNode minNode;
        int len = lists.length;
        int count = 0;
        for (ListNode node : lists) {
            while (node != null) {
                count++;
                node = node.next;
            }
        }
        int id = 0;
        while (count-- > 0) {
            minNode = null;
            for (int i = 0; i < len; i++) {
                ListNode node = lists[i];
                if (node == null) continue;
                if (minNode == null) {
                    minNode = node;
                    id = i;
                    continue;
                }
                if (node.val < minNode.val) {
                    minNode = node;
                    id = i;
                }
            }
            if (root == null) {
                temp = root = new ListNode(minNode.val);
                lists[id] = lists[id].next;
            } else {
                temp.next = new ListNode(minNode.val);
                temp = temp.next;
                if (lists[id] != null) lists[id] = lists[id].next;
            }
        }
        return root;
    }

    public static DoublyList mergeDLL(DoublyList root) {
        if (root == null || root.next == null) return root;
        DoublyList secondNode = split(root);
        DoublyList firstNode = mergeDLL(root);
        secondNode = mergeDLL(secondNode);
        return merge(firstNode, secondNode);
    }

    private static DoublyList split(DoublyList node) {
        DoublyList slow, fast;
        slow = node;
        fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        DoublyList temp = slow.next;
        slow.next = null;
        return temp;
    }

    private static DoublyList merge(DoublyList first, DoublyList second) {
        if (first == null) return second;
        if (second == null) return first;
        if (first.data < second.data) {
            first.next = merge(first.next, second);
            first.next.prv = first;
            first.prv = null;
            return first;
        } else {
            second.next = merge(first, second.next);
            second.next.prv = second;
            second.prv = null;
            return second;
        }
    }

    public static void testMergeKLists() {
        ListNode[] lists = new ListNode[3];
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(2);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(4);
        node3.next = new ListNode(6);

        lists[0] = node1;
        lists[1] = node2;
        lists[2] = node3;
        ListNode sortedRootNode = mergeKLists(lists);
        while (sortedRootNode != null) {
            System.out.print(sortedRootNode.val + " -> ");
            sortedRootNode = sortedRootNode.next;
        }
        System.out.println();
    }

    public static void testMergeDLL() {
        DoublyList list = new DoublyList(1);
//        list.head = new Node(10);
//        list.head.next = new Node(30);
//        list.head.next.next = new Node(3);
//        list.head.next.next.next = new Node(4);
//        list.head.next.next.next.next = new Node(20);
//        list.head.next.next.next.next.next = new Node(5);
    }
    public static void main(String[] args) {
        testMergeKLists();

    }
}
