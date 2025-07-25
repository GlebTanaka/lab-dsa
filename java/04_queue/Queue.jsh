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
        if (last == null) { // If the queue is empty
            first = node;
            last = node;
        } else { // Add the new node to the end of the queue
            last.next = node;
            last = node; // Update the `last` reference
        }
        length++; // Increment the queue length
    }

    public int dequeue() {
        if (first == null) { // Check if the queue is empty
            return -1; // Return a sentinel value (e.g., -1) or throw an exception
        }
        Node node = first; // Store the current first node
        first = first.next; // Move the first pointer to the next node
        if (first == null) { // If the queue is now empty
            last = null; // Update the last pointer to null
        }
        length--; // Decrement the length
        return node.value; // Return the value of the dequeued node
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