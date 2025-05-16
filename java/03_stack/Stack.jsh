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
        // Checking for null is not required here because even if 'top' is null
        newNode.next = top; // Link the new node to the current top node
        top = newNode;      // Update the top pointer to the new node
        height++;           // Increment stack height
    }

    public Node pop() {
        if (isEmpty()) {  // Use isEmpty() instead of top == null
            System.out.println("Stack is empty. Cannot pop.");
            return null; // Return null to signify an empty stack
        }
        Node poppedNode = top;  // Store the current top node
        top = top.next;         // Move the top pointer to the next node
        poppedNode.next = null; // Clear the `next` reference of the popped node (sanitization)
        height--;               // Decrement stack height
        return poppedNode;      // Return the removed node
    }

    public void printStack() {
        Node current = top;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public void getTop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println(top.value);
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return top.value;
    }

    public void clear() {
        top = null;
        height = 0;
    }

    public void getHeight() {
        System.out.println(height);
    }
}