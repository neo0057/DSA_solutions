package practice.linkedlist;

public class DoublyList {
    int data;
    DoublyList next;
    DoublyList prv;

    public DoublyList(){

    }

    public DoublyList(int data) {
        this.data = data;
        this.next = null;
        this.prv = null;
    }
}
