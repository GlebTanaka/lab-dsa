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
    int length;

    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
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

    public int getLength() {
        return length;
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public void printQueue() {
        if (getFirst() == null) { // Using getFirst() directly
            System.out.println("Queue is empty.");
            return;
        }
        Node current = getFirst();
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}