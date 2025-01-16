// LinkedList.jsh

    public class LinkedList {

        private Node head;
        private Node tail;
        private int length;

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

        // append a new node at the end of the list
        public void append(int data) {
            Node newNode = new Node(data);
            if (head == null) { // if the list is empty
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode; // update the next pointer to the current tail
                tail = newNode; // update the tail to the new node
            }
            length++; // increment the length
        }

        // prepend
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

        // Get the Node at a specific index
        public Node getAtIndex(int index) {
            if (index < 0 || index >= length) { // Validate the index
                System.out.println("Index out of bounds");
                return null; // Return null if the index is invalid
            }

            Node current = head; // Start from the head
            for (int currentIndex = 0; currentIndex < index; currentIndex++) {
                current = current.next;
            }

            return current; // Return the Node at the desired index
        }

        public boolean setAtIndex(int index, int value) {
            // Use the getAtIndex method to get the Node at the specified index
            Node targetNode = getAtIndex(index);

            // Check if the node is null (invalid index)
            if (targetNode == null) {
                System.out.println("Index out of bounds");
                return false;
            }

            // Update the node's value
            targetNode.value = value;
            return true;
        }

        // insert
        public boolean insert(int index, int value) {
            if (index < 0 || index > length) { // Validate the index
                return false;
            }

            if (index == 0) { // Insert at the beginning
                prepend(value);
                return true;
            }

            if (index == length) { // Insert at the end
                append(value);
                return true;
            }

            // Insert in the middle
            Node newNode = new Node(value);
            Node temp = getAtIndex(index - 1);

            // Adjust pointers to insert the new node
            newNode.next = temp.next;
            temp.next = newNode;

            length++; // Update the length of the list
            return true;
        }

        // remove first
        public Node removeFirst() {
            if (head == null) { // If the list is empty
                return null;
            }

            Node removedNode = head; // The node to be removed

            if (head == tail) { // If there is only one element in the list
                head = null;
                tail = null;
            } else {
                head = head.next; // Update head to the next node
            }

            removedNode.next = null; // Detach the removed node
            length--; // Decrement the size of the list

            return removedNode; // Return the removed node
        }

        // remove last element and return it
        public Node removeLast() {
            if (head == null) { // Empty List
                return null;
            }

            if (head == tail) { // Single element
                Node removedNode = head;
                head = null;
                tail = null;
                length--;
                return removedNode;
            }

            Node current = head;
            Node previous = null;

            // Traverse to find the last and second-to-last nodes
            while (current.next != null) {
                previous = current;
                current = current.next;
            }

            // Update the second-to-last node to be the new tail
            tail = previous;
            tail.next = null;
            length--;

            return current; // Return the removed node
        }

        public void printList() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }

    }
