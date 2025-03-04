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

    // Adds an element to the end of the queue
    public void Enqueue(int item)
    {
        // Add logic to enqueue an item
    }

    // Removes and returns the element at the front of the queue
    public int Dequeue()
    {
        // Add logic to dequeue an item
        return;
    }

    // Returns the element at the front of the queue without removing it
    public Node Peek()
    {
        // Add logic to peek at the front item
        return ;
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