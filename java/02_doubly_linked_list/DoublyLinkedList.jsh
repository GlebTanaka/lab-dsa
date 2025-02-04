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

    public Node removeFirst() {
        // Step 1: Handle the empty list case
        if (head == null) { // List is empty
            return null;
        }

        // Step 2: Store reference to the current head
        Node removedNode = head;

        // Step 3: Handle the single-node list case
        if (head == tail) { // List has only one node
            head = null;
            tail = null;
        } else {
            // Step 4: Update the head to the next node and adjust references
            head = head.next;
            head.prev = null; // Remove reference to the old head
        }

        // Step 5: Completely disconnect the removed node
        removedNode.next = null;

        // Step 6: Update the length
        length--;

        // Step 7: Return the removed node
        return removedNode;
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

    public Node removeAtIndex(int index) {
        // Step 1: Check if index is out of bounds
        if (index < 0 || index >= length) {
            return null; // Invalid index
        }

        // Step 2: Handle edge cases for removing the first or last node
        if (index == 0) {
            return removeFirst(); // Use removeFirst() for index 0
        }

        if (index == length - 1) {
            return removeLast(); // Use removeLast() for the last index
        }

        // Step 3: Find the node at the specified index
        Node nodeToRemove = getAtIndex(index);
        if (nodeToRemove == null) {
            return null; // Safeguard in case getAtIndex unexpectedly fails
        }

        // Step 4: Update the previous and next nodes to skip over the node to remove
        Node prevNode = nodeToRemove.prev;
        Node nextNode = nodeToRemove.next;

        if (prevNode != null) {
            prevNode.next = nextNode; // Update the next pointer of the previous node
        }

        if (nextNode != null) {
            nextNode.prev = prevNode; // Update the prev pointer of the next node
        }

        // Step 5: Disconnect the node from the list
        nodeToRemove.prev = null;
        nodeToRemove.next = null;

        // Step 6: Decrement the length of the list
        length--;

        // Step 7: Return the removed node
        return nodeToRemove;
    }

    public Node removeAtIndexOnePointer(int index) {
        // Step 1: Check if index is out of bounds
        if (index < 0 || index >= length) {
            return null; // Invalid index
        }

        // Step 2: Handle edge cases for first or last node
        if (index == 0) {
            return removeFirst(); // Use existing method to remove the first node
        }
        if (index == length - 1) {
            return removeLast(); // Use existing method to remove the last node
        }

        // Step 3: Use getAtIndex to get the node at the specified index
        Node nodeToRemove = getAtIndex(index);
        if (nodeToRemove == null) {
            return null; // Safeguard in case getAtIndex unexpectedly fails
        }

        // Step 4: Update the pointers to remove the node
        nodeToRemove.prev.next = nodeToRemove.next;  // Link previous node to the next node
        nodeToRemove.next.prev = nodeToRemove.prev;  // Link next node to the previous node

        // Step 5: Disconnect the node to be removed
        nodeToRemove.prev = null;
        nodeToRemove.next = null;

        // Step 6: Decrement the length of the list
        length--;

        // Step 7: Return the removed node
        return nodeToRemove;
    }

    public Node getAtIndex(int index) {
        // Step 1: Check if the index is out of bounds
        if (index < 0 || index >= length) {
            return null; // Return null for invalid index
        }

        Node current;

        // Step 2: Optimize traversal by selecting the direction
        if (index < length / 2) {
            // Start from head and move forward
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            // Start from tail and move backward
            current = tail;
            for (int i = length - 1; i > index; i--) {
                current = current.prev;
            }
        }

        // Step 3 & 4: Return the node at the desired index
        return current;
    }

    public boolean setAtIndex(int index, int value) {
        // Step 1: Use getAtIndex to get the node at the specified index
        Node nodeToUpdate = getAtIndex(index);

        // Step 2: Check if the node exists (valid index)
        if (nodeToUpdate == null) {
            return false; // Index is out of bounds, return false
        }

        // Step 3: Update the node's value
        nodeToUpdate.value = value;
        return true; // Update was successful, return true
    }

    public boolean insertAtIndex(int index, int value) {
        // Step 1: Check if the index is valid
        if (index < 0 || index > length) {
            return false; // Index is out of bounds
        }

        // Step 2: Handle inserting at the beginning of the list
        if (index == 0) {
            prepend(value);
            return true;
        }

        // Step 3: Handle inserting at the end of the list
        if (index == length) {
            append(value);
            return true;
        }

        // Step 4: For all other cases, find the node at the specified index - 1
        Node prevNode = getAtIndex(index - 1); // Get the node at index - 1
        if (prevNode == null) {
            return false; // Safeguard in case getAtIndex unexpectedly fails
        }

        // Step 5: Create a new node with the given value
        Node newNode = new Node(value);

        // Step 6: Update the pointers to insert the new node at the correct position
        Node nextNode = prevNode.next;  // The node currently at the given index
        newNode.next = nextNode;        // Link new node to the next node
        newNode.prev = prevNode;        // Link new node back to the previous node

        prevNode.next = newNode;        // Link previous node to the new node
        if (nextNode != null) {
            nextNode.prev = newNode;    // Link the next node back to the new node
        }

        // Step 7: Increment the length of the list
        length++;

        // Step 8: Return true to indicate success
        return true;
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