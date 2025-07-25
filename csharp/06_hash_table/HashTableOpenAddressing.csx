using System;

public class HashTableOpenAddressing
{
    // Entry structure to represent a single key-value pair in a table
    private class HashEntry
    {
        public string Key { get; set; }
        public int Value { get; set; }
        public bool IsDeleted { get; set; }

        public HashEntry(string key, int value)
        {
            Key = key;
            Value = value;
            IsDeleted = false;
        }
    }

    private const int TABLE_SIZE = 10; // Default size of hash table
    private HashEntry[] table;        // Array to store hash entries

    public HashTableOpenAddressing()
    {
        table = new HashEntry[TABLE_SIZE];
    }

    // Hash function to generate an index
    private int HashFunction(string key)
    {
        int hash = 0;
        foreach (char ch in key)
        {
            hash = (hash * 31 + ch) % TABLE_SIZE;
        }
        return hash;
    }

    // Insert a key-value pair into the hash table
    public void Insert(string key, int value)
    {
        int index = HashFunction(key);
        int originalIndex = index; // To detect if we circle back to the same position
        int probeCount = 0;

        while (table[index] != null && !table[index].IsDeleted)
        {
            if (table[index].Key == key)
            {
                // If the key already exists, update the value
                table[index].Value = value;
                Console.WriteLine($"Updated key \"{key}\" with value {value}");
                return;
            }

            // Move to the next slot (linear probing)
            index = (index + 1) % TABLE_SIZE;
            probeCount++;

            if (index == originalIndex)
            {
                // If we've come full circle, the table is full
                Console.WriteLine($"Table is full! Unable to insert key \"{key}\".");
                return;
            }
        }

        // Insert the new entry
        table[index] = new HashEntry(key, value);
        Console.WriteLine($"Inserted key \"{key}\" with value {value} at index {index}");
    }

    // Search for a value by its key
    public bool Search(string key, out int value)
    {
        int index = HashFunction(key);
        int originalIndex = index;
        value = 0;

        while (table[index] != null)
        {
            if (!table[index].IsDeleted && table[index].Key == key)
            {
                value = table[index].Value;
                return true;
            }

            // Move to the next slot (linear probing)
            index = (index + 1) % TABLE_SIZE;

            if (index == originalIndex)
            {
                // If we've come full circle, the key doesn't exist
                break;
            }
        }

        return false;
    }

    // Remove a key-value pair from the hash table
    public bool Remove(string key)
    {
        int index = HashFunction(key);
        int originalIndex = index;

        while (table[index] != null)
        {
            if (!table[index].IsDeleted && table[index].Key == key)
            {
                // Mark the entry as deleted
                table[index].IsDeleted = true;
                Console.WriteLine($"Removed key \"{key}\" at index {index}");
                return true;
            }

            // Move to the next slot (linear probing)
            index = (index + 1) % TABLE_SIZE;

            if (index == originalIndex)
            {
                // If we've come full circle, the key doesn't exist
                break;
            }
        }

        Console.WriteLine($"Key \"{key}\" not found for removal.");
        return false;
    }

    // Display the hash table
    public void Display()
    {
        for (int i = 0; i < TABLE_SIZE; i++)
        {
            if (table[i] == null || table[i].IsDeleted)
            {
                Console.WriteLine($"[{i}] Empty");
            }
            else
            {
                Console.WriteLine($"[{i}] Key: {table[i].Key}, Value: {table[i].Value}");
            }
        }
    }
}

// Demonstration
// class Program
// {
//     static void Main(string[] args)
//     {
//         HashTableOpenAddressing hashTable = new HashTableOpenAddressing();
// 
//         // Insert some key-value pairs
//         hashTable.Insert("apple", 100);
//         hashTable.Insert("banana", 200);
//         hashTable.Insert("cherry", 300);
//         hashTable.Insert("date", 400);
// 
//         // Display the hash table
//         Console.WriteLine("\nHash Table:");
//         hashTable.Display();
// 
//         // Search for a key
//         if (hashTable.Search("banana", out int value))
//         {
//             Console.WriteLine($"\nKey \"banana\" found with value: {value}");
//         }
//         else
//         {
//             Console.WriteLine("\nKey \"banana\" not found.");
//         }
// 
//         // Remove a key
//         hashTable.Remove("banana");
// 
//         // Display the hash table after removal
//         Console.WriteLine("\nHash Table after removing \"banana\":");
//         hashTable.Display();
//     }
}