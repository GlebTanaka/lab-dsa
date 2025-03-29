using System;

public class BinarySearchTree
{
    // Inner Node class
    public class Node
    {
        public int Data { get; set; }
        public Node Left { get; set; }
        public Node Right { get; set; }
        private Node Root { get; } // Reference to the root node (used for IsRoot)

        // Constructor to initialize the node
        public Node(int data, Node root = null)
        {
            Data = data;
            Left = null;
            Right = null;
            Root = root;
        }

        // Helper method: Check if the node has a left child
        public bool HasLeft()
        {
            return Left != null;
        }

        // Helper method: Check if the node has a right child
        public bool HasRight()
        {
            return Right != null;
        }

        // Helper method: Check if the node is a leaf (has no children)
        public bool IsLeaf()
        {
            return Left == null && Right == null;
        }

        // Helper method: Check if the node has any children
        public bool HasChildren()
        {
            return Left != null || Right != null;
        }

        // Helper method: Check if the node is the root of the BST
        public bool IsRoot()
        {
            return this == Root;
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
        if (root == null)
        {
            root = new Node(value, root); // Initialize root reference
        }
        else
        {
            InsertRecursively(root, value);
        }
    }

    private Node InsertRecursively(Node node, int value)
    {
        // If the tree is empty, create a new node
        if (node == null)
        {
            return new Node(value, root); // Pass root reference when creating a new node
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

    // Public accessor for the root to use for testing purposes
    public Node GetRoot()
    {
        return root;
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

        // Example for using helper methods
        BinarySearchTree.Node root = bst.GetRoot();

        if (root.IsRoot())
        {
            Console.WriteLine($"Node {root.Data} is the root of the tree.");
        }

        if (root.HasChildren())
        {
            Console.WriteLine($"Root node {root.Data} has children.");
        }

        if (root.Left != null && root.Left.IsLeaf())
        {
            Console.WriteLine($"Node {root.Left.Data} is a leaf node.");
        }
    }
}