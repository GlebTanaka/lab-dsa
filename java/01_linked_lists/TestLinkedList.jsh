// Import the LinkedList class (if it's in a package, adjust the import accordingly)

// Instantiate the LinkedList class with an initial value
    LinkedList list = new LinkedList(10); // Creates a linked list with 10 as the first node

// Test appending values
    System.out.println("Testing append:");
    list.append(20);
    list.append(30);
    list.printList(); // Should print: 10 -> 20 -> 30 -> null

    // Test prepending values
    System.out.println("Testing prepend:");
    list.prepend(5);
    list.printList(); // Should print: 5 -> 10 -> 20 -> 30 -> null

    // Test inserting values
    System.out.println("Testing insert:");
    list.insert(2, 15); // Insert 15 at index 2
    list.printList(); // Should print: 5 -> 10 -> 15 -> 20 -> 30 -> null

    // Test removing a node
    System.out.println("Testing removeAtIndex:");
    list.removeAtIndex(3); // Remove the node at index 3 (value 20)
    list.printList(); // Should print: 5 -> 10 -> 15 -> 30 -> null

    // Test removing the first node
    System.out.println("Testing removeFirst:");
    list.removeFirst(); // Removes first node (value 5)
    list.printList(); // Should print: 10 -> 15 -> 30 -> null

    // Test removing the last node
    System.out.println("Testing removeLast:");
    list.removeLast(); // Removes last node (value 30)
    list.printList(); // Should print: 10 -> 15 -> null

    // Test list length
    System.out.println("Testing getLength:");
    System.out.println("Current length of the list: " + list.getLength()); // Should print: Current length of the list: 2

    // Test for empty list edge cases (optional)
    System.out.println("Testing edge cases for empty list:");
    list.removeFirst(); // Removes first node (value 10)
    list.removeFirst(); // Removes last node (value 15)
    list.printList(); // Should print: null
    System.out.println("Length after all removals: " + list.getLength()); // Should print: Length after all removals: 0