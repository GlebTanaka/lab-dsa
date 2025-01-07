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

	// append
	
	// prepend
	
	// insert

}
