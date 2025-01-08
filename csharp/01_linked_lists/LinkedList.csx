public class LinkedList {
	private Node head;

	public LinkedList(int initialData) {
		head = new Node(initialData);
	}

	// Nested Node class
	private class Node {
		public int Data { get; }
		public Node Next { get; set; }

		public Node(int data) {
			Data = data;
			Next = null;
		}
	}

	// Add a new node at the end
	public void Append(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		Node current = head;
		while (current.Next != null) {
			current = current.Next;
		}
		current.Next = newNode;
	}

	
	// prepend
	
	// insert
	
	// Print the list elements
	public void PrintList() {
		Node current = head;
		while (current != null) {
			Console.Write(current.Data + " -> ");
			current = current.Next;
		}
		Console.WriteLine("null");
	}

}
