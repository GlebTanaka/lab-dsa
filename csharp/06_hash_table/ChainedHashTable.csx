using System;

public class ChainedHashTable
{
    // Private Node class for linked list
    private class Node
    {
        public string Key { get; set; }
        public int Value { get; set; }
        public Node Next { get; set; }

        public Node(string key, int value)
        {
            Key = key;
            Value = value;
            Next = null;
        }
    }

    // Array to hold the buckets
    private Node[] buckets;

    // Number of buckets in the hash table
    private int size;

    public ChainedHashTable(int initialSize)
    {
        size = initialSize;
        buckets = new Node[size];
    }

    // Hash function to compute the bucket index
    private int GetBucketIndex(string key)
    {
        int hashCode = key.GetHashCode();
        return Math.Abs(hashCode % size);
    }

    // Add a new key-value pair
    public void Add(string key, int value)
    {
        int index = GetBucketIndex(key);
        Node current = buckets[index];

        // Check if the key already exists and update the value
        while (current != null)
        {
            if (current.Key == key)
            {
                throw new ArgumentException($"Key '{key}' already exists in the hash table.");
            }
            current = current.Next;
        }

        // Insert new node at the start of the chain
        Node newNode = new Node(key, value)
        {
            Next = buckets[index]
        };
        buckets[index] = newNode;
    }

    // Retrieve the value associated with a key
    public int Get(string key)
    {
        int index = GetBucketIndex(key);
        Node current = buckets[index];

        // Search the linked list in the bucket
        while (current != null)
        {
            if (current.Key == key)
            {
                return current.Value;
            }
            current = current.Next;
        }

        throw new KeyNotFoundException($"Key '{key}' not found in the hash table.");
    }

    // Remove a key-value pair
    public bool Remove(string key)
    {
        int index = GetBucketIndex(key);
        Node current = buckets[index];
        Node previous = null;

        // Traverse the linked list to find the key
        while (current != null)
        {
            if (current.Key == key)
            {
                // Remove the node
                if (previous == null)
                {
                    // If it's the first node in the bucket
                    buckets[index] = current.Next;
                }
                else
                {
                    previous.Next = current.Next;
                }
                return true;
            }

            previous = current;
            current = current.Next;
        }

        return false;
    }

    // Check if a key exists in the hash table
    public bool ContainsKey(string key)
    {
        int index = GetBucketIndex(key);
        Node current = buckets[index];

        // Search the linked list
        while (current != null)
        {
            if (current.Key == key)
            {
                return true;
            }
            current = current.Next;
        }

        return false;
    }

    // Print the hash table for debugging purposes
    public void Print()
    {
        for (int i = 0; i < size; i++)
        {
            Console.Write($"Bucket {i}: ");
            Node current = buckets[i];
            while (current != null)
            {
                Console.Write($"[{current.Key}, {current.Value}] -> ");
                current = current.Next;
            }
            Console.WriteLine("null");
        }
    }
}