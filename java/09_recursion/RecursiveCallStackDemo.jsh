public class RecursiveCallStackDemo {
    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public static void traverseAndPrint(Node node, int depth) {
        if (node == null) return;

        // Pre-order operations (before recursive calls)
        String indent = "  ".repeat(depth);
        System.out.println(indent + "PRE-ORDER: Entering node " + node.value);
        System.out.println(indent + "Stack depth: " + depth);

        // Recursive calls
        System.out.println(indent + "Going left from " + node.value);
        traverseAndPrint(node.left, depth + 1);

        // In-order operations (between recursive calls)
        System.out.println(indent + "IN-ORDER: Finished left subtree of " + node.value);

        System.out.println(indent + "Going right from " + node.value);
        traverseAndPrint(node.right, depth + 1);

        // Post-order operations (after all recursive calls)
        System.out.println(indent + "POST-ORDER: Exiting node " + node.value);
    }

    public static void main(String[] args) {
        // Create a simple binary tree:
        //       1
        //      / \
        //     2   3
        //    /
        //   4
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        System.out.println("Starting tree traversal...\n");
        traverseAndPrint(root, 0);
    }
}