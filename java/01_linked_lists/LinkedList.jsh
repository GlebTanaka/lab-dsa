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
    length = 1;
  }
  
  // append

  // prepend

  // insert

  public void printList() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.value + " -> ");
      temp = temp.next;
    }
    System.out.println("null");
  }

}
