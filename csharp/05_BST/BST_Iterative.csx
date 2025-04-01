using System;
using System.Collections.Generic;

public class BinarySearchTree
{
    // Inner Node class
    public class Node
    {
        public int Data { get; set; }
        public Node Left { get; set; }
        public Node Right { get; set; }

        public Node(int data)
        {
            Data = data;
            Left = null;
            Right = null;
        }
    }

    private Node root;

    // Constructor
    public BinarySearchTree()
    {
        root = null;
    }

    // Iterative Insertion
    public void Insert(int value)
    {
        Node newNode = new Node(value);

        // If the tree is empty
        if (root == null)
        {
            root = newNode;
            return;
        }

        Node current = root;
        Node parent = null;

        while (current != null)
        {
            parent = current;
            if (value < current.Data)
            {
                current = current.Left;
            }
            else if (value > current.Data)
            {
                current = current.Right;
            }
            else
            {
                // Value already exists in the BST
                return;
            }
        }

        if (value < parent.Data)
        {
            parent.Left = newNode;
        }
        else
        {
            parent.Right = newNode;
        }
    }

    // Iterative Search
    public bool Search(int value)
    {
        Node current = root;

        while (current != null)
        {
            if (current.Data == value)
            {
                return true;
            }
            else if (value < current.Data)
            {
                current = current.Left;
            }
            else
            {
                current = current.Right;
            }
        }

        return false;
    }

    // Iterative Parent Retrieval
    public Node ParentOf(int value)
    {
        Node current = root;
        Node parent = null;

        while (current != null)
        {
            if (current.Data == value)
            {
                return parent;
            }

            parent = current;
            if (value < current.Data)
            {
                current = current.Left;
            }
            else
            {
                current = current.Right;
            }
        }

        return null; // Value not found
    }

    // In-Order Iterative Traversal
    public void InOrderTraversal()
    {
        if (root == null) return;

        Stack<Node> stack = new Stack<Node>();
        Node current = root;

        while (current != null || stack.Count > 0)
        {
            // Go to the leftmost node
            while (current != null)
            {
                stack.Push(current);
                current = current.Left;
            }

            // Process the current node
            current = stack.Pop();
            Console.Write(current.Data + " ");

            // Visit the right subtree
            current = current.Right;
        }

        Console.WriteLine();
    }
    
    // Clear the tree (Iterative Post-Order Traversal for deletion)
    public void Clear()
    {
        if (root == null) return;

        Stack<Node> stack = new Stack<Node>();
        stack.Push(root);

        while (stack.Count > 0)
        {
            Node current = stack.Pop();

            if (current.Left != null)
            {
                stack.Push(current.Left);
            }
            if (current.Right != null)
            {
                stack.Push(current.Right);
            }

            current = null; // Helps garbage collection by removing references
        }

        root = null;
    }
}

// Example usage
public class Program
{
    public static void Main()
    {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert nodes into the BST
        bst.Insert(50);
        bst.Insert(30);
        bst.Insert(70);
        bst.Insert(20);
        bst.Insert(40);
        bst.Insert(60);
        bst.Insert(80);

        // Search for values
        Console.WriteLine("Search 40: " + (bst.Search(40) ? "Found" : "Not Found"));
        Console.WriteLine("Search 90: " + (bst.Search(90) ? "Found" : "Not Found"));

        // Find the parent of a node
        var parentNode = bst.ParentOf(40);
        Console.WriteLine("Parent of 40: " + (parentNode != null ? parentNode.Data.ToString() : "Not Found"));

        // Perform in-order traversal
        Console.WriteLine("In-order Traversal:");
        bst.InOrderTraversal();

        // Clear the tree
        bst.Clear();
        Console.WriteLine("Tree cleared.");
    }
}