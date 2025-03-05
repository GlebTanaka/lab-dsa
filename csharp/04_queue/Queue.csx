using System;

public class Queue<T>
{
    // Private fields for storing the queue data
    private Node _head;
    private Node _tail;
    private int _count;
    
    // Inner Node class
    public class Node
    {
        public int Data { get; set; }
        public Node Next { get; set; }
    
        // Constructor that takes only the data
        public Node(int data)
        {
            Data = data;
            Next = null; // Initialize Next as null by default
        }
    }

    // Constructor
    public Queue()
    {
        // Initialize the queue
    }

    // Constructor with initial value
    public Queue(int value)
    {
        _head = new Node(value);
        _tail = _head; // Since it's a single element, head and tail should point to the same node
        _count = 1;    // Initial count is set to 1
    }

    // Adds an element to the end of the queue
    public void Enqueue(int item)
    {
        // Create a new node with the given item
        Node newNode = new Node(item);
    
        // If the queue is empty:
        if (IsEmpty()
        {
            _head = newNode; // New node becomes the head
            _tail = newNode; // And the tail, since it's the only element
        }
        else
        {
            // Otherwise, attach the new node to the end of the queue
            _tail.Next = newNode;
            _tail = newNode; // Update the tail to point to the new last node
        }
    
        // Increment the count of items in the queue
        _count++;
    }

    // Removes and returns the element at the front of the queue
    public Node Dequeue()
    {
        // If the queue is empty, throw an exception
        if (IsEmpty())
        {
            return null;
        }
    
        // Store the current head to return it later
        Node dequeuedNode = _head;
    
        // Update the head to point to the next node
        _head = _head.Next;
    
        // If the head becomes null, the queue is now empty - update tail as well
        if (_head == null)
        {
            _tail = null;
        }
    
        // Decrement the count
        _count--;
        
        // Disconnect the dequeued node from the queue
        dequeuedNode.Next = null;

        // Return the dequeued node
        return dequeuedNode;
    }

    // Returns the element at the front of the queue without removing it
    public int Peek()
    {
        // If the queue is empty, throw an exception
        if (IsEmpty())
        {
            throw new InvalidOperationException("Queue is empty.");
        }
    
        // Return the front node without removing it
        return _head.value;
    }
    
    // Returns the number of elements in the queue
    public int Count
    {
        get
        {
            // Return the current count of items in the queue
            return _count;
        }
    }

    // Returns true if the queue is empty
    public bool IsEmpty()
    {
        // Add logic to check if the queue is empty
        return _count == 0;
    }
}
