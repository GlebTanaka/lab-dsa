public class LinkedList {
    private Node head;  // Pointer to the first node
    private Node tail;  // Pointer to the last node
    private int length; // Variable to track the size of the list

    // Constructor to initialize the list
    public LinkedList(int initialData) {
        Node newNode = new Node(initialData);
        head = newNode;
        tail = newNode;
        length = 1; // Start with one element
    }

    public int Length { 
        get { return length; } // Accessor to get the list length
    }

    // Nested Node class
    public class Node {
        public int Data { get; set; } // Changed to allow modification
        public Node Next { get; set; }

        public Node(int data) {
            Data = data;
            Next = null;
        }
    }

    // Add new node at the end
    public void Append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.Next = newNode;
            tail = newNode;
        }
        length++; // Increment on adding a node
    }

    // Add new node at the beginning
    public void Prepend(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.Next = head;
            head = newNode;
        }
        length++; // Increment on adding a node
    }
    
    public Node GetAtIndex(int index) {
        if (index < 0 || index >= length) {
            Console.WriteLine("Index out of bounds.");
            return null; // Return null if the specified index is invalid
        }
    
        Node current = head; // Start at the head of the list
        int currentIndex = 0;
    
        while (currentIndex < index) {
            current = current.Next; // Move to the next node
            currentIndex++;
        }
    
        return current; // Return the node at the specified index
    }
    
    public void SetAtIndex(int index, int newData) {
        // Use GetAtIndex to retrieve the node at the specified index
        Node nodeToSet = GetAtIndex(index);
    
        // Check if the node exists (GetAtIndex will return null if the index is invalid)
        if (nodeToSet == null) {
            Console.WriteLine("Cannot set data: Index out of bounds.");
            return;
        }
    
        // Update the data in the node
        nodeToSet.Data = newData;
    }
    
    public void Insert(int index, int value) {
        // Validate the index
        if (index < 0 || index > length) {
            Console.WriteLine("Index out of bounds.");
            return;
        }
    
        // Handle insertion at the beginning
        if (index == 0) {
            Prepend(value);
            return;
        }
    
        // Handle insertion at the end
        if (index == length) {
            Append(value);
            return;
        }
    
        // Insertion in the middle
        Node newNode = new Node(value);
        Node previousNode = GetAtIndex(index - 1); // Get the node before the specified index
        newNode.Next = previousNode.Next; // Point the new node to the next node
        previousNode.Next = newNode; // Update the previous node's next pointer to point to the new node
    
        length++; // Increment the list size
    }

    // Remove the first element and update length
    public Node RemoveFirst() {
        if (head == null) {
            Console.WriteLine("List is empty; nothing to remove.");
            return null;
        }

        Node removedNode = head;
        head = head.Next;

        if (head == null) {
            tail = null;
        }

        length--; // Decrement on removing a node
        return removedNode;
    }

    // Remove the last element and update length
    public Node RemoveLast() {
        if (head == null) {
            Console.WriteLine("List is empty; nothing to remove.");
            return null;
        }

        Node removedNode;

        if (head == tail) {
            removedNode = head;
            head = null;
            tail = null;
        } else {
            Node current = head;
            while (current.Next != tail) {
                current = current.Next;
            }

            removedNode = tail;
            current.Next = null;
            tail = current;
        }

        length--; // Decrement on removing a node
        return removedNode;
    }

    // Remove node at a specific index and update length
    public Node RemoveAtIndex(int index) {
        if (head == null) {
            Console.WriteLine("List is empty; nothing to remove.");
            return null;
        }

        if (index < 0) {
            Console.WriteLine("Index cannot be negative.");
            return null;
        }

        if (index == 0) {
            return RemoveFirst();
        }

        Node current = head;
        int currentIndex = 0;

        while (current.Next != null && currentIndex < index - 1) {
            current = current.Next;
            currentIndex++;
        }

        if (current.Next == null) {
            Console.WriteLine("Index out of bounds.");
            return null;
        }

        Node removedNode = current.Next;
        current.Next = current.Next.Next;

        if (removedNode == tail) {
            tail = current;
        }

        length--; // Decrement on removing a node
        return removedNode;
    }
    
    public void PrintList() {
        if (head == null) {
            Console.WriteLine("The list is empty.");
            return;
        }
    
        Node current = head; // Start at the head of the list
        while (current != null) {
            Console.Write(current.Data + " -> "); // Print the current node's data
            current = current.Next; // Move to the next node
        }
    
        Console.WriteLine("null"); // Indicate the end of the list
    }
}