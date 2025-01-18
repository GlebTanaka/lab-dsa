public class LinkedList {
    private Node head; // Pointer to the first node
    private Node tail; // Pointer to the last node

    // Constructor to initialize the list with one node
    public LinkedList(int initialData) {
        Node newNode = new Node(initialData);
        head = newNode;
        tail = newNode;
    }

    // Nested Node class
    public class Node {
        public int Data { get; }
        public Node Next { get; set; }

        public Node(int data) {
            Data = data;
            Next = null;
        }
    }

    // Add a new node at the end (using tail pointer for efficiency)
    public void Append(int data) {
        Node newNode = new Node(data);
        if (head == null) { 
            // If the list is empty, set both head and tail to the new node
            head = newNode;
            tail = newNode;
            return;
        }
        tail.Next = newNode; // Point the current tail's Next to the new node
        tail = newNode;      // Update the tail pointer
    }

    // Add a new node at the beginning
    public void Prepend(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            // If the list is empty, set both head and tail to the new node
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.Next = head; // Point new node's Next to the current head
        head = newNode;      // Update the head pointer
    }
    
    public Node GetAtIndex(int index) {
        if (index < 0) {
            Console.WriteLine("Index cannot be negative.");
            return null;
        }
    
        Node current = head;
        int currentIndex = 0;
    
        while (current != null) {
            if (currentIndex == index) {
                return current; // Found the node at the specified index
            }
            current = current.Next; // Move to the next node
            currentIndex++;
        }
    
        Console.WriteLine("Index out of bounds.");
        return null; // If the index exceeds the length of the list
    }
    
    public bool SetAtIndex(int index, int newValue) {
        Node node = GetAtIndex(index); // Use GetAtIndex to find the node
        if (node == null) {
            Console.WriteLine("Unable to set value: Index out of bounds.");
            return false; // Indicate failure to set the value
        }
    
        node.Data = newValue; // Update the data of the found node
        return true; // Indicate success
    }

    // Remove the last element (updating the tail pointer)
    public Node RemoveLast() {
        if (head == null) {
            Console.WriteLine("List is empty; nothing to remove.");
            return null;
        }

        Node removedNode;

        // If the list has only one element
        if (head == tail) {
            removedNode = head;
            head = null;
            tail = null; // Update the tail pointer to null
            return removedNode;
        }

        // Traverse to the second last node
        Node current = head;
        while (current.Next != tail) {
            current = current.Next;
        }

        removedNode = tail;       // Save the current tail node
        current.Next = null;      // Remove the reference to the removed node
        tail = current;           // Update the tail pointer to the new last node

        return removedNode;       // Return the removed node
    }

    // Print the list elements
    public void PrintList() {
        Node current = head;
        while (current != null) {
            Console.Write(current.Data + " -> ");
            current = current.Next;
        }
        Console.WriteLine("null");
    }
}

