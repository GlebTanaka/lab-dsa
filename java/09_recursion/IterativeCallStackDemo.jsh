import java.util.*;

public class IterativeCallStackDemo {
    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    static class StackFrame {
        Node node;
        int depth;
        boolean leftVisited;
        boolean rightVisited;

        StackFrame(Node node, int depth) {
            this.node = node;
            this.depth = depth;
            this.leftVisited = false;
            this.rightVisited = false;
        }
    }

    public static void traverseAndPrintIterative(Node root) {
        if (root == null) return;

        Stack<StackFrame> stack = new Stack<>();
        stack.push(new StackFrame(root, 0));

        while (!stack.isEmpty()) {
            StackFrame current = stack.peek();
            String indent = "  ".repeat(current.depth);

            if (!current.leftVisited && !current.rightVisited) {
                // Pre-order operations
                System.out.println(indent + "PRE-ORDER: Entering node " + current.node.value);
                System.out.println(indent + "Stack depth: " + current.depth);

                // Prepare to visit left subtree
                System.out.println(indent + "Going left from " + current.node.value);
                current.leftVisited = true;

                if (current.node.left != null) {
                    stack.push(new StackFrame(current.node.left, current.depth + 1));
                    continue;
                }
            }

            if (current.leftVisited && !current.rightVisited) {
                // In-order operations
                System.out.println(indent + "IN-ORDER: Finished left subtree of " + current.node.value);

                // Prepare to visit right subtree
                System.out.println(indent + "Going right from " + current.node.value);
                current.rightVisited = true;

                if (current.node.right != null) {
                    stack.push(new StackFrame(current.node.right, current.depth + 1));
                    continue;
                }
            }

            // Post-order operations (after both subtrees are visited)
            if (current.leftVisited && current.rightVisited) {
                System.out.println(indent + "POST-ORDER: Exiting node " + current.node.value);
                stack.pop();
            }
        }
    }
}