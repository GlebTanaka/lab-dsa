    public class LinkedList {

        private Node head;
        private Node tail;
        private int length;

        // Helper method to check index bounds
        private boolean isIndexOutOfBounds(int index, boolean inclusiveUpperBound) {
            if (inclusiveUpperBound) {
                return index < 0 || index > length;
            } else {
                return index < 0 || index >= length;
            }
        }
        // Nested Node class
        private class Node {
            int value;
            Node next;

            Node(int value) {
                this.value = value;
            }
        }

        public LinkedList(int value) {
            Node newNode = new Node(value);
            head = newNode;
            tail = newNode;
            length = 1;
        }

        // Append a new node at the end
        public void append(int value) {
            Node newNode = new Node(value);
            if (head == null) { // If the list is empty
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            length++;
        }

        // Prepend a new node at the beginning
        public void prepend(int value) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
            length++;
        }

        // Get the current length of the linked list
        public int getLength() {
            return length;
        }

        // Get the node at a specific index
        public Node getAtIndex(int index) {
            if (isIndexOutOfBounds(index, false)) { // Use helper method
                System.out.println("Index out of bounds");
                return null;
            }

            Node current = head;
            for (int currentIndex = 0; currentIndex < index; currentIndex++) {
                current = current.next;
            }

            return current;
        }

        // Set the value at a specific index
        public boolean setAtIndex(int index, int value) {
            Node targetNode = getAtIndex(index);
            if (targetNode == null) return false;

            targetNode.value = value;
            return true;
        }

        // Insert a node at a specific index
        public boolean insert(int index, int value) {
            if (isIndexOutOfBounds(index, true)) { // Use helper method
                return false;
            }

            if (index == 0) {
                prepend(value);
                return true;
            }

            if (index == getLength()) { // Validate last index insertion
                append(value);
                return true;
            }

            Node newNode = new Node(value);
            Node temp = getAtIndex(index - 1);

            newNode.next = temp.next;
            temp.next = newNode;

            length++;
            return true;
        }

        // Remove a node from the list by index
        public Node removeAtIndex(int index) {
            if (isIndexOutOfBounds(index, false)) { // Use helper method
                System.out.println("Index out of bounds");
                return null;
            }

            if (index == 0) {
                return removeFirst();
            }

            if (index == getLength() - 1) {
                return removeLast();
            }

            Node prev = getAtIndex(index - 1);
            Node removedNode = prev.next;
            prev.next = removedNode.next;
            removedNode.next = null;

            length--;
            return removedNode;
        }

        // Other methods (removeFirst, removeLast, reverse, etc.) should remain unchanged.
        public Node removeFirst() {
            if (head == null) {
                return null;
            }

            Node removedNode = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
            }
            removedNode.next = null;
            length--;
            return removedNode;
        }

        public Node removeLast() {
            if (head == null) {
                return null;
            }

            if (head == tail) {
                Node removedNode = head;
                head = null;
                tail = null;
                length--;
                return removedNode;
            }

            Node current = head;
            Node previous = null;
            while (current.next != null) {
                previous = current;
                current = current.next;
            }

            tail = previous;
            tail.next = null;
            length--;
            return current;
        }

        // Reverse the linked list in-place
        public void reverse() {
            Node prev = null;
            Node current = head;
            Node next = null;

            // Traverse the list and reverse the next pointers
            while (current != null) {
                next = current.next;  // Store the next node
                current.next = prev;  // Reverse the current node's pointer
                prev = current;       // Move 'prev' forward
                current = next;       // Move 'current' forward
            }

            // Update head and tail pointers
            tail = head;
            head = prev;
        }

        // Print the linked list
        public void printList() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }