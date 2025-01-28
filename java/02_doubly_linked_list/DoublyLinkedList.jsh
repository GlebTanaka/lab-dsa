import org.w3c.dom.Node;public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    private class Node {
        int value;
        Node prev;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
        this.head = new Node(value);
        this.tail = this.head;
        this.length = 1;
    }
}