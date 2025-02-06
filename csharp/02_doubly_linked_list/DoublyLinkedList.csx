using System;

public class DoublyLinkedList
{
    private Node head;
    private Node tail;
    private int length;
    
    // Nested Node class
    private class Node
    {
        public int Data { get; set; }
        public Node Next { get; set; }
        public Node Prev { get; set; }

        public Node(int data)
        {
            Data = data;
            Next = null;
            Prev = null;
        }
    }

    // Default constructor (no value)
    public DoublyLinkedList()
    {
        head = null;
        tail = null;
        length = 0;
    }
    
    // Constructor with an initial value
    public DoublyLinkedList(int value)
    {
        Node newNode = new Node(value); // Create the first node with the given value
        head = newNode;                // Set head to the new node
        tail = newNode;                // Set tail to the same node as head
        length = 1;                    // Initial length of the list is 1
    }

    // Property to get the size of the list
    public int Length => length;

    // Check if the list is empty
    public bool IsEmpty => length == 0;

    // Add a value to the front of the list
    public void Append(int value)
    {
        Node newNode = new Node(value);
        if (head == null) // If list is empty
        {
            head = tail = newNode;
        }
        else
        {
            newNode.Next = head;
            head.Prev = newNode;
            head = newNode;
        }
        length++;
    }

    // Add a value to the end of the list
    public void Prepend(int value)
    {
        Node newNode = new Node(value); // Create a new node with the given value
        if (head == null) // If the list is empty
        {
            head = tail = newNode; // Set both head and tail to the new node
        }
        else
        {
            newNode.Next = head;   // Link the new node's "Next" to the head
            head.Prev = newNode;   // Link the current head's "Prev" to the new node
            head = newNode;        // Update head to point to the new node
        }
        length++; // Increment the length of the list
    }


    // Remove a value from the front of the list and return the removed node
    public Node RemoveFirst()
    {
        if (head == null) // The list is empty
        {
            Console.WriteLine("The list is already empty.");
            return null; // Indicate that there was no node to remove
        }
    
        Node removedNode = head; // Save the reference to the current head
    
        if (head == tail) // The list has only one node
        {
            head = null;
            tail = null;
        }
        else // The list has more than one node
        {
            head = head.Next;    // Move head to the next node
            head.Prev = null;    // Dereference the old head
        }
    
        length--; // Decrement the length of the list
        removedNode.Next = null; // Clean up the removed node's references
        removedNode.Prev = null;
    
        return removedNode; // Return the removed node
    }

    // Remove a value from the back of the list and return the removed node
    public Node RemoveLast()
    {
        if (tail == null) // The list is empty
        {
            Console.WriteLine("The list is already empty.");
            return null; // Indicate that there was no node to remove
        }
    
        Node removedNode = tail; // Save the reference to the current tail
    
        if (head == tail) // The list has only one node
        {
            head = null;
            tail = null;
        }
        else // The list has more than one node
        {
            tail = tail.Prev;    // Move tail to the previous node
            tail.Next = null;    // Dereference the old tail
        }
    
        length--; // Decrement the length of the list
        removedNode.Next = null; // Clean up the removed node's references
        removedNode.Prev = null;
    
        return removedNode; // Return the removed node
    }
    
    // removing at index using two pointer
    
    // removing at index using only one pointer

    // Clear the entire list
    
    // get an element at a specific index
    
    // set an element at a specific index


    // Print the list forwards
    public void PrintForward()
    {
        Node current = head;
        while (current != null)
        {
            Console.Write(current.Data + " -> ");
            current = current.Next;
        }
        Console.WriteLine("null");
    }

    // Print the list backwards
    public void PrintBackward()
    {
        Node current = tail;
        while (current != null)
        {
            Console.Write(current.Data + " ");
            current = current.Prev;
        }
        Console.WriteLine();
    }
}

