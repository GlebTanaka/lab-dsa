public class HashTable {
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