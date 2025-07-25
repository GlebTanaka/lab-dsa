    public class ChainedHashTable {
        private static final int DEFAULT_CAPACITY = 7; // Default capacity for the hash table
        private Node[] table; // Array of Nodes (for the chained buckets)
        private int size;     // Number of key-value pairs in the table

        // Custom Node class representing a Linked List Node
        class Node {
            String key;
            int value;
            Node next;

            public Node(String key, int value) {
                this.key = key;
                this.value = value;
                this.next = null;
            }
        }

        // Default Constructor (Uses Default Capacity)
        public ChainedHashTable() {
            this(DEFAULT_CAPACITY);
        }

        // Constructor with Custom Initial Capacity
        public ChainedHashTable(int initialCapacity) {
            this.table = new Node[initialCapacity];
            this.size = 0;
        }

        // Hash Function
        private int hash(String key) {
            return (key.hashCode() & Integer.MAX_VALUE) % table.length;
        }

        // Add or Update a Key-Value Pair
        public void put(String key, int value) {
            int index = hash(key);

            Node head = table[index];
            Node current = head;

            // Check if the key already exists in the chain
            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value; // Overwrite the value
                    return;
                }
                current = current.next;
            }

            // If the key does not exist, add a new Node at the beginning of the chain
            Node newNode = new Node(key, value);
            newNode.next = head;
            table[index] = newNode;

            size++;
        }

        // Retrieve a Value by Key
        public int get(String key) {
            int index = hash(key);

            Node current = table[index];

            // Traverse the chain to find the key
            while (current != null) {
                if (current.key.equals(key)) {
                    return current.value; // Key found
                }
                current = current.next;
            }

            return -1; // Key not found
        }

        // Remove a Key-Value Pair
        public boolean remove(String key) {
            int index = hash(key);

            Node current = table[index];
            Node prev = null;

            // Traverse the chain to find and remove the key
            while (current != null) {
                if (current.key.equals(key)) {
                    if (prev == null) {
                        table[index] = current.next; // Remove the first node
                    } else {
                        prev.next = current.next; // Bypass the node to be removed
                    }
                    size--;
                    return true;
                }
                prev = current;
                current = current.next;
            }

            return false; // Key not found
        }

        // Get the Number of Key-Value Pairs in the Table
        public int size() {
            return size;
        }

        // Check if the Table is Empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Print the Hash Table for Debugging
        public void printTable() {
            System.out.println("Hash Table:");
            for (int i = 0; i < table.length; i++) {
                System.out.print("Index " + i + ":");
                Node current = table[i];
                if (current == null) {
                    System.out.println(" Empty");
                } else {
                    while (current != null) {
                        System.out.print(" -> [Key=" + current.key + ", Value=" + current.value + "]");
                        current = current.next;
                    }
                    System.out.println();
                }
            }
        }
    }