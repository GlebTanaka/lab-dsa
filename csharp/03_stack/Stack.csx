public class Stack
{
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


    private Node top; // Represents the top of the stack
    private int size; // Tracks the number of elements in the stack

    public Stack()
    {
        top = null;
        size = 0;
    }
    
    // Constructor with an initial value
    public Stack(int initialValue)
    {
        top = new Node(initialValue);
        size = 1; // Initial size is 1
    }

    // Push an element onto the stack
    public void Push(int value)
    {
        Node newNode = new Node(value); // Create a new node with the given value
        newNode.Next = top;            // Set the current top as the next node
        top = newNode;                 // Update the top to the new node
        size++;                        // Increase the size of the stack
    }

    // Pop an element off the stack and return the popped Node
    public Node Pop()
    {
        if (IsEmpty())
        {
            throw new InvalidOperationException("Stack is empty. Cannot pop an element.");
        }
    
        Node poppedNode = top;    // Store the current top node
        top = top.Next;           // Update the top to the next node
        size--;                   // Decrease the size of the stack
        poppedNode.Next = null;   // Set Next of the popped node to null (disconnection)
        return poppedNode;        // Return the popped node
    }

    // Peek the top element of the stack
    public int Peek()
    {
        if (IsEmpty())
        {
            throw new InvalidOperationException("Stack is empty. Cannot peek.");
        }

        return top.Data;
    }
    
    // Print all elements in the stack
    public void PrintStack()
    {
        if (IsEmpty())
        {
            Console.WriteLine("Stack is empty.");
            return;
        }
    
        Node current = top; // Start from the top of the stack
        Console.WriteLine("Stack elements (from top to bottom):");
        while (current != null)
        {
            Console.WriteLine(current.Data); // Print the data of the current node
            current = current.Next;         // Move to the next node
        }
    }

    // Check if the stack is empty
    public bool IsEmpty()
    {
        return top == null;
    }

    // Get the size of the stack
    public int Size()
    {
        return size;
    }
}
