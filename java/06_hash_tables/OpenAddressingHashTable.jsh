    public class OpenAddressingHashTable {
        private static final int DEFAULT_CAPACITY = 16;
        private static final double LOAD_FACTOR_THRESHOLD = 0.6;
        private ProbingType probingType; // Enum for selecting probing type

        private Entry[] table;
        private int size;
        private int capacity;

        // Enum for the Probing Type
        public enum ProbingType {
            LINEAR_PROBING,
            QUADRATIC_PROBING,
            DOUBLE_HASHING
        }

        // Entry class to hold key-value pair
        private static class Entry {
            String key;
            int value;
            boolean isDeleted;

            public Entry(String key, int value) {
                this.key = key;
                this.value = value;
                this.isDeleted = false;
            }
        }

        // Constructor with default probing type (Linear Probing)
        public OpenAddressingHashTable() {
            this(DEFAULT_CAPACITY, ProbingType.LINEAR_PROBING);
        }

        // Constructor with custom probing type
        public OpenAddressingHashTable(int initialCapacity, ProbingType probingType) {
            this.capacity = initialCapacity;
            this.table = new Entry[capacity];
            this.size = 0;
            this.probingType = probingType;
        }

        // Hash function
        private int hash(String key) {
            return (key.hashCode() & Integer.MAX_VALUE) % capacity;
        }

        // Secondary hash function (for Double Hashing)
        private int secondaryHash(String key) {
            return 1 + (key.hashCode() & Integer.MAX_VALUE) % (capacity - 1); // Must not return 0
        }

        // Generic probing function
        private int probe(int hash, int step, String key) {
            switch (probingType) {
                case LINEAR_PROBING:
                    return (hash + step) % capacity;
                case QUADRATIC_PROBING:
                    return (hash + step * step) % capacity;
                case DOUBLE_HASHING:
                    return (hash + step * secondaryHash(key)) % capacity;
                default:
                    throw new IllegalStateException("Invalid probing type");
            }
        }

        // Insert method with collision handling using probing
        public void put(String key, int value) {
            if (loadFactor() > LOAD_FACTOR_THRESHOLD) {
                resize();
            }

            int hash = hash(key);
            int step = 0;

            while (true) {
                int index = probe(hash, step, key);
                if (table[index] == null || table[index].isDeleted) {
                    table[index] = new Entry(key, value);
                    size++;
                    return;
                } else if (table[index].key.equals(key)) {
                    table[index].value = value; // Overwrite existing value
                    return;
                }
                step++;
            }
        }

        // Retrieve a value by key
        public int get(String key) {
            int hash = hash(key);
            int step = 0;

            while (true) {
                int index = probe(hash, step, key);
                if (table[index] == null) {
                    break; // Key not found
                }
                if (!table[index].isDeleted && table[index].key.equals(key)) {
                    return table[index].value;
                }
                step++;
            }

            return -1; // Key not found
        }

        // Remove a key-value pair
        public boolean remove(String key) {
            int hash = hash(key);
            int step = 0;

            while (true) {
                int index = probe(hash, step, key);
                if (table[index] == null) {
                    break; // Key not found
                }
                if (!table[index].isDeleted && table[index].key.equals(key)) {
                    table[index].isDeleted = true; // Mark as deleted
                    size--;
                    return true;
                }
                step++;
            }

            return false; // Key not found
        }

        // Load factor calculation
        private double loadFactor() {
            return (double) size / capacity;
        }

        // Resize and rehash the table
        private void resize() {
            int newCapacity = capacity * 2;
            Entry[] oldTable = table;

            table = new Entry[newCapacity];
            capacity = newCapacity;
            size = 0;

            for (Entry entry : oldTable) {
                if (entry != null && !entry.isDeleted) {
                    put(entry.key, entry.value); // Rehash into the new table
                }
            }
        }

        public void printTable() {
            System.out.println("Hash Table:");
            for (int i = 0; i < capacity; i++) {
                if (table[i] == null) {
                    System.out.println("Index " + i + ": Empty");
                } else if (table[i].isDeleted) {
                    System.out.println("Index " + i + ": Deleted");
                } else {
                    System.out.println("Index " + i + ": Key = " + table[i].key + ", Value = " + table[i].value);
                }
            }
        }
    }