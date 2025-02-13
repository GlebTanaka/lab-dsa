public class Stack {
    private Node top;
    private int height;

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Stack(int value) {
        top = new Node(value);
        height = 1;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top; // Link the new node to the current top node
        top = newNode;      // Update the top pointer to the new node
        height++;           // Increment stack height
    }

    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1; // Or throw an exception (e.g., EmptyStackException)
        }
        int poppedValue = top.value; // Store the current top value
        top = top.next;              // Move the top pointer to the next node
        height--;                    // Decrement stack height
        return poppedValue;          // Return the removed value
    }

    public void printStack() {
        Node current = top;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public void getTop() {
        if (top != null) {
            System.out.println(top.value);
        } else {
            System.out.println("Stack is empty.");
        }
    }

    public void getHeight() {
        System.out.println(height);
    }
}