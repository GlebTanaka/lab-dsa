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

    public void printStack() {
        Node current = top;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public void getTop() {
        System.out.println(top.value);
    }

    public void getHeight() {
        System.out.println(height);
    }
}