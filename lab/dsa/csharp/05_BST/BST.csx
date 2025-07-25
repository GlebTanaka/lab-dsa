using System;
using System.Text;

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
    
    // Method to find the parent node of a given node
    public Node ParentOf(Node current, Node searchNode)
    {
        return ParentOfRecursive(root, null, searchNode);
    }

    private Node ParentOfRecursive(Node current, Node parent, Node searchNode)
    {
        // Base case: if the current node is null, return null
        if (current == null)
        {
            return null;
        }

        // If the current node matches the searchNode, return the parent
        if (current == searchNode)
        {
            return parent;
        }

        // Recursively search in the left subtree
        Node leftResult = ParentOfRecursive(current.Left, current, searchNode);
        if (leftResult != null)
        {
            return leftResult;
        }

        // Recursively search in the right subtree
        return ParentOfRecursive(current.Right, current, searchNode);
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
    
    // Overriding ToString to provide tree visualization
    public override string ToString()
    {
        // Convert the string representation into a system-specific line-separated format
        return string.Join(Environment.NewLine, ToStringTree("", root, false).Split('\n'));
    }

    private string ToStringTree(string prefix, Node node, bool isRightChild)
    {
        if (node == null)
        {
            return "";
        }

        var result = new StringBuilder();

        // Process the right subtree
        if (node.HasRight())
        {
            if (string.IsNullOrEmpty(prefix))
            {
                result.Append(ToStringTree("      ", node.Right, true));
            }
            else
            {
                result.Append(ToStringTree(prefix + (isRightChild ? "      " : "|     "), node.Right, true));
            }
        }

        // Process current node
        result.Append(prefix)
              .Append("[")
              .Append($"{node.Data:00}") // Format value as 2-digits
              .Append("]");

        if (node.HasChildren())
        {
            if (node.HasLeft() && node.HasRight())
            {
                result.Append("--|");
            }
            else if (node.HasLeft())
            {
                result.Append("--,");
            }
            else
            {
                result.Append("--'");
            }
        }

        result.Append(Environment.NewLine);

        // Process the left subtree
        if (node.HasLeft())
        {
            result.Append(ToStringTree(prefix + (isRightChild ? "|     " : "      "), node.Left, false));
        }

        return result.ToString();
    }

}