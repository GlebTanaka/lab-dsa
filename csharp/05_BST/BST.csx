using System;

public class BinarySearchTree
{
    // Inner Node class
    public class Node
    {
        public int Data { get; set; }
        public Node Left { get; set; }
        public Node Right { get; set; }

        // Constructor to initialize the node
        public Node(int data)
        {
            Data = data;
            Left = null;
            Right = null;
        }
    }

    // Root of the BST
    private Node root;

    // Constructor to initialize an empty tree
    public BinarySearchTree()
    {
        root = null;
    }

    // Insert a new value into the BST
    public void Insert(int value)
    {
        root = InsertRecursively(root, value);
    }

    private Node InsertRecursively(Node node, int value)
    {
        // If the tree is empty, create a new node
        if (node == null)
        {
            return new Node(value);
        }

        // Traverse the tree to find the correct position
        if (value < node.Data)
        {
            node.Left = InsertRecursively(node.Left, value);
        }
        else if (value > node.Data)
        {
            node.Right = InsertRecursively(node.Right, value);
        }

        return node;
    }

    // Search for a value in the BST
    public bool Search(int value)
    {
        return SearchRecursively(root, value);
    }

    private bool SearchRecursively(Node node, int value)
    {
        // Base case: if the node is null or the value is found
        if (node == null)
        {
            return false;
        }

        if (node.Data == value)
        {
            return true;
        }

        // Recursively search in the left or right subtree
        if (value < node.Data)
        {
            return SearchRecursively(node.Left, value);
        }
        else
        {
            return SearchRecursively(node.Right, value);
        }
    }

    // Perform in-order traversal and print the nodes
    public void InOrderTraversal()
    {
        Console.WriteLine("In-order Traversal:");
        InOrderTraversalRecursively(root);
        Console.WriteLine();
    }

    private void InOrderTraversalRecursively(Node node)
    {
        if (node != null)
        {
            // Traverse the left subtree
            InOrderTraversalRecursively(node.Left);

            // Visit and print the current node
            Console.Write(node.Data + " ");

            // Traverse the right subtree
            InOrderTraversalRecursively(node.Right);
        }
    }
}

// Example usage
class Program
{
    static void Main(string[] args)
    {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert elements
        bst.Insert(50);
        bst.Insert(30);
        bst.Insert(70);
        bst.Insert(20);
        bst.Insert(40);
        bst.Insert(60);
        bst.Insert(80);

        // Perform in-order traversal (should print: 20 30 40 50 60 70 80)
        bst.InOrderTraversal();

        // Search for elements
        Console.WriteLine("Search 40: " + bst.Search(40)); // True
        Console.WriteLine("Search 90: " + bst.Search(90)); // False
    }
}