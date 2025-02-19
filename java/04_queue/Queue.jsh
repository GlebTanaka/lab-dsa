public class Queue {

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;

    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
    }

    public void enqueue(int value) {
        Node node = new Node(value);
        if (last == null) {
            first = node;
        } else {
            last.next = node;
        }
    }

    public Node dequeue() {
        if (first == null) {
            return null;
        }
        Node node = first;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return node;
    }

    public boolean isEmpty() {
        return first == null;
    }
}