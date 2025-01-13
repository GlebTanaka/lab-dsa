public class LinkedList {
	private Node head;

	public LinkedList(int initialData) {
		head = new Node(initialData);
	}

	// Nested Node class
	public class Node {
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
    
    // Remove Element at the end
    public Node RemoveLast() {
        // Declare the removed node variable just once at the top
        Node removedNode = null;
    
        // Check if the list is empty
        if (head == null) {
            Console.WriteLine("List is empty; nothing to remove.");
            return null;
        }
    
        // Check if the list has only one element
        if (head.Next == null) {
            removedNode = head; // Assign the only node
            head = null; // Set head to null
            return removedNode; // Return the single node
        }
    
        // Traverse to the second last node
        Node current = head;
        while (current.Next.Next != null) {
            current = current.Next;
        }
    
        // Assign the last node to be removed
        removedNode = current.Next;
    
        // Remove the last node by setting the second last node's Next to null
        current.Next = null;
    
        // Return the removed node
        return removedNode;
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
