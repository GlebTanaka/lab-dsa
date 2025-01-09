// LinkedList.jsh

public class LinkedList {
  
  private Node head;
  private Node tail;
  private int length;
  
  // Nested Node class
  private class Node {
    int value;
    Node next;

    Node(int value) {
      this.value = value;
    }
  }

  public LinkedList(int value) {
    Node newNode = new Node(value);
    head = newNode;
    tail = newNode;
    length = 1;
  }
  
  // append a new node at the end of the list
  public void append(int data) {
    Node newNode = new Node(data);
    if (head == null) { // if the list is empty
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode; // update the next pointer to the current tail
      tail = newNode; // update the tail to the new node
    }
    length++; // increment the length
  }

  // prepend

  // insert

  // remove last element and return it
  public Node removeLast() {
    if (head == null) { // Empty List
        return null;
    }
    
    if (head == tail) { // Single element
        Node removedNode = head;
        head = null;
        tail = null;
        length--;
        return removedNode;
    }

    Node current = head;
    Node previous = null;

    // Traverse to find the last and second-to-last nodes
    while (current.next != null) {
        previous = current;
        current = current.next;
    }

    // Update the second-to-last node to be the new tail
    tail = previous;
    tail.next = null;
    length--;

    return current; // Return the removed node
  }

  public void printList() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.value + " -> ");
      temp = temp.next;
    }
    System.out.println("null");
  }

}
