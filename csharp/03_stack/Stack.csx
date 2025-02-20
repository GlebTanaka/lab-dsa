public class Stack
{
    // Inner Node class
    public class Node
    {
        public int Data { get; set; }
        public Node Next { get; set; }

        public Node(int data, Node next = null)
        {
            Data = data;
            Next = next;
        }
    }

    private Node top; // Represents the top of the stack
    private int size; // Tracks the number of elements in the stack

    public Stack()
    {
        top = null;
        size = 0;
    }

    // Push an element onto the stack
    public void Push(int value)
    {
        top = new Node(value, top);
        size++;
    }

    // Pop an element off the stack
    public int Pop()
    {
        if (IsEmpty())
        {
            throw new InvalidOperationException("Stack is empty. Cannot pop an element.");
        }

        int value = top.Data; // Get the top value
        top = top.Next;       // Remove the top node
        size--;
        return value;
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
