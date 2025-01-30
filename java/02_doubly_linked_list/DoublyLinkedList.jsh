public class DoublyLinkedList {
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

    public void append(int value) {
        // Step 1: Create a new node with the given value
        Node newNode = new Node(value);

        // Step 2: Update the tail node
        if (tail != null) {
            tail.next = newNode;  // Link the current tail to the new node
            newNode.prev = tail;  // Link the new node back to the current tail
        } else {
            // If the list is empty, set head and tail to the new node
            head = newNode;
        }
        tail = newNode;       // Update the tail to be the new node

        // Step 3: Increment the length of the list
        length++;
    }

    public void prepend(int value) {
        // Step 1: Create the new node with the given value
        Node newNode = new Node(value);

        // Step 2: Handle empty list case
        if (head == null) {
            head = newNode;
            tail = newNode; // Since it's the only node, head == tail
        } else {
            // Step 3: Link the new node to the current head
            newNode.next = head; // Point new node's next to the current head
            head.prev = newNode; // Point current head's prev to the new node
            head = newNode;      // Update head to the new node
        }

        // Step 4: Increment the length of the list
        length++;
    }

    public Node removeLast() {
        // Step 1: Handle edge case where the list is empty
        if (head == null) { // `length == 0` the list is empty nothing to remove
            return null; // Nothing to remove
        }

        // Step 2: Store reference to the current tail
        Node removedNode = tail;

        // Step 3: Handle the case where there's only one node in the list
        if (head == tail) { // `length == 1` only one node in the list
            head = null;
            tail = null;
        } else {
            // Step 4: Update the tail to the previous node
            tail = tail.prev;
            tail.next = null; // Remove the connection to the removed node
        }

        removedNode.prev = null; // Disconnect from the list fully

        // Step 5: Update the length
        length--;

        // Step 6: Return the removed node
        return removedNode;
    }

    public void printList() {
        // Start at the head of the list
        Node current = head;

        // Traverse the list and print the values of each node
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next; // Move to the next node
        }

        System.out.println("null"); // Move to the next line after printing all values
    }
}