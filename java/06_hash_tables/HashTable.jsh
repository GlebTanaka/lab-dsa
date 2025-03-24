import java.util.ArrayList;public class HashTable {
    private int size;
    private Node[] table;

    class Node {
        String key;
        int value;
        Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable(int size) {
        this.size = size;
        this.table = new Node[size];
    }

    private int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            int ascii = key.charAt(i);
            hash = ((hash * 31) + ascii) % table.length;
        }
        // Force positivity using bitwise AND
        return hash & Integer.MAX_VALUE;
    }

    public void put(String key, int value) {
        int hash = hash(key);
        Node newNode = new Node(key,value);
        if (table[hash] == null) {
            table[hash] = newNode;
        } else {
            Node current = table[hash];
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public int get(String key) {
        int index = hash(key);
        Node current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return -1;
    }

    public ArrayList<String> getKeys() {
        ArrayList<String> keys = new ArrayList<>();
        for (int i = 0; i < table.length; i++) {
            Node current = table[i];
            while (current != null) {
                keys.add(current.key);
                current = current.next;
            }
        }
        return keys;

    }

    public boolean remove(String key) {
        int hash = hash(key); // Calculate the hash for the key
        Node current = table[hash];
        Node previous = null;

        while (current != null) {
            if (current.key.equals(key)) {
                // Key found; remove current node
                if (previous == null) {
                    // If it's the first node in the bucket
                    table[hash] = current.next;
                } else {
                    // Adjust the 'next' pointer of the previous node
                    previous.next = current.next;
                }
                return true; // Indicate successful removal
            }
            // Move to the next node in the chain
            previous = current;
            current = current.next;
        }

        return false; // Key not found
    }

    public void printHashTable() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + ":");
            Node current = table[i];
            while (current != null) {
                System.out.println("  {" + current.key + "= " + current.value + "}");
                current = current.next;
            }
        }
    }
}