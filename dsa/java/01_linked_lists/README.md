# LinkedList Implementation in Java
This project contains a custom implementation of a singly linked list in Java. The `LinkedList` class supports common operations such as appending, prepending, inserting, removing, reversing, and more. It is designed to provide a basic understanding of how linked lists work and can be expanded upon for more advanced use cases.
## How to Run the File in `jshell`
You can run the `LinkedList` class in the `jshell` REPL environment using the following steps:
1. **Open a Terminal/Command Prompt**: Ensure `jshell` is installed and available on your system. If Java is properly installed (Java 11+), `jshell` should be included.
2. **Launch `jshell`**: Run the following command to start the `jshell` environment:
``` bash
   jshell
```
1. **Load the File**: Execute the following command in `jshell` to load your `LinkedList` file:
``` bash
   /open <path-to-your-file>/LinkedList.jsh
```
Replace `<path-to-your-file>` with the actual path where the file is stored.
1. **Create a New Instance of the LinkedList**: After the file is loaded, you can directly create and manipulate an instance of the `LinkedList` class:
``` java
   LinkedList list = new LinkedList(10); // Creates a LinkedList with an initial value of 10
```
1. **Test Methods**: Once the object is created, you can call various methods:
``` java
   list.append(20); // Appends '20' to the list
   list.prepend(5); // Prepends '5' to the list
   list.printList(); // Prints the list
```
## Features
The `LinkedList` class provides the following functionalities:
### **Core Methods**
- **`append(int value)`**
  Appends a node with the specified value to the end of the linked list.
- **`prepend(int value)`**
  Prepends a node with the specified value to the beginning of the linked list.
- **`getLength()`**
  Returns the total number of nodes in the linked list.
- **`getAtIndex(int index)`**
  Retrieves the node at the specified index.
- **`setAtIndex(int index, int value)`**
  Sets the value of a node at a specific index.
- **`insert(int index, int value)`**
  Inserts a node with the specified value at the given index.

### **Removal Methods**
- **`removeAtIndex(int index)`**
  Removes and returns the node at the specified index.
- **`removeFirst()`**
  Removes and returns the node at the beginning of the list.
- **`removeLast()`**
  Removes and returns the node at the end of the list.

### **Utility Methods**
- **`reverse()`**
  Reverses the order of the linked list in-place.
- **`printList()`**
  Prints the entire linked list in a readable format (e.g., `5 -> 10 -> 20 -> null`).

## Examples of Usage
Here are some examples to demonstrate how the `LinkedList` class can be used:
### Creating a New Linked List
``` java
LinkedList list = new LinkedList(10); // Creates a linked list with an initial value of 10
list.printList(); // Output: 10 -> null
```
### Appending and Prepending Nodes
``` java
list.append(20);   // Adds '20' to the end
list.prepend(5);   // Adds '5' to the beginning
list.printList();  // Output: 5 -> 10 -> 20 -> null
```
### Inserting and Setting Values
``` java
list.insert(1, 15);  // Inserts '15' at index 1
list.printList();    // Output: 5 -> 15 -> 10 -> 20 -> null

list.setAtIndex(2, 25); // Changes the value at index 2 to '25'
list.printList();       // Output: 5 -> 15 -> 25 -> 20 -> null
```
### Removing Nodes
``` java
list.removeAtIndex(1); // Removes the node at index 1
list.printList();      // Output: 5 -> 25 -> 20 -> null

list.removeFirst();    // Removes the first node
list.printList();      // Output: 25 -> 20 -> null

list.removeLast();     // Removes the last node
list.printList();      // Output: 25 -> null
```
### Reversing the List
``` java
list.append(40);
list.append(60);
list.printList(); // Output: 25 -> 40 -> 60 -> null

list.reverse(); 
list.printList(); // Output: 60 -> 40 -> 25 -> null
```
## How to Contribute
If you'd like to contribute:
1. Fork the repository.
2. Create a new feature branch.
3. Submit a pull request.

## Credits
Developed as part of an effort to demonstrate a custom linked list implementation in Java.
