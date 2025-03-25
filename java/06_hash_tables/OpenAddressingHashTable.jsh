    public class OpenAddressingHashTable {
        private static final int DEFAULT_CAPACITY = 16;
        private static final double LOAD_FACTOR_THRESHOLD = 0.6;

        private Entry[] table;  // Array to store entries
        private int size;       // Number of elements in the hash table
        private int capacity;   // Current capacity of the table

        // Entry Class to hold key-value pairs
        private static class Entry {
            String key;
            int value;
            boolean isDeleted;  // Flag to indicate if the entry was deleted

            public Entry(String key, int value) {
                this.key = key;
                this.value = value;
                this.isDeleted = false;
            }
        }

        // Constructor
        public OpenAddressingHashTable() {
            this(DEFAULT_CAPACITY);
        }

        public OpenAddressingHashTable(int initialCapacity) {
            this.capacity = initialCapacity;
            this.table = new Entry[capacity];
            this.size = 0;
        }

        // Hash Function
        private int hash(String key) {
            return (key.hashCode() & Integer.MAX_VALUE) % capacity;
        }

        // Linear Probing Function
        private int probe(int hash, int step) {
            return (hash + step) % capacity;
        }

        // Insert or Update a Key-Value Pair
        public void put(String key, int value) {
            if (loadFactor() > LOAD_FACTOR_THRESHOLD) {
                resize(); // Resize the table if load factor exceeds threshold
            }

            int hash = hash(key);
            int step = 0;

            while (table[hash] != null && !table[hash].isDeleted && !table[hash].key.equals(key)) {
                hash = probe(hash, ++step); // Linear probing to find an empty slot
            }

            if (table[hash] == null || table[hash].isDeleted) {
                // If this is a new insertion
                table[hash] = new Entry(key, value);
                size++;
            } else {
                // If the key already exists, overwrite the value
                table[hash].value = value;
            }
        }

        // Retrieve a Value by Key
        public int get(String key) {
            int hash = hash(key);
            int step = 0;

            while (table[hash] != null) {
                if (!table[hash].isDeleted && table[hash].key.equals(key)) {
                    return table[hash].value; // Key found
                }
                hash = probe(hash, ++step); // Continue probing
            }

            return -1; // Key not found
        }

        // Remove a Key-Value Pair
        public boolean remove(String key) {
            int hash = hash(key);
            int step = 0;

            while (table[hash] != null) {
                if (!table[hash].isDeleted && table[hash].key.equals(key)) {
                    // Mark the entry as deleted and reduce the size
                    table[hash].isDeleted = true;
                    size--;
                    return true;
                }
                hash = probe(hash, ++step);
            }

            return false; // Key not found
        }

        // Load Factor Calculation
        private double loadFactor() {
            return (double) size / capacity;
        }

        // Resize and Rehash the Table
        private void resize() {
            int newCapacity = capacity * 2;
            Entry[] oldTable = table;

            table = new Entry[newCapacity];
            capacity = newCapacity;
            size = 0;

            for (Entry entry : oldTable) {
                if (entry != null && !entry.isDeleted) {
                    put(entry.key, entry.value); // Rehash elements into new table
                }
            }
        }

        // Return the Number of Key-Value Pairs
        public int size() {
            return size;
        }

        // Check if the Table is Empty
        public boolean isEmpty() {
            return size == 0;
        }
    }