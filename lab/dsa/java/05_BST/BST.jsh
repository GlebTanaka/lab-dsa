import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class BinarySearchTree {

    //region Node Structure
    private Node root;

    private class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    //endregion

    //region Helper Methods
    public boolean hasLeft(Node node) {
        return node.left != null;
    }

    public boolean hasRight(Node node) {
        return node.right != null;
    }

    public boolean hasChildren(Node node) {
        return hasLeft(node) || hasRight(node);
    }

    public boolean isLeaf(Node node) {
        return !hasLeft(node) && !hasRight(node);
    }

    public boolean isRoot(Node node) {
        return node == root;
    }
    //endregion

    //region Parent Node Operations

    /**
     * Finds the parent of a given node using recursion
     */
    public Node parentOf(Node searchNode) {
        if (searchNode == root) {
            return null;
        }
        return parentOf(root, searchNode);
    }

    private Node parentOf(Node currentNode, Node searchNode) {
        if (currentNode == null || currentNode.left == searchNode || currentNode.right == searchNode) {
            return currentNode;
        }
        if (searchNode.value < currentNode.value) {
            Node leftParent = parentOf(currentNode.left, searchNode);
            if (leftParent != null) {
                return leftParent;
            }
        } else {
            Node rightParent = parentOf(currentNode.right, searchNode);
            if (rightParent != null) {
                return rightParent;
            }
        }
        return null;
    }

    /**
     * Finds the parent of a given node using iteration
     */
    public Node parentOfIter(Node searchNode) {
        if (searchNode == null) {
            throw new IllegalArgumentException("Search node cannot be null");
        }
        if (searchNode == root) {
            return null;
        }

        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.left == searchNode || currentNode.right == searchNode) {
                return currentNode;
            }
            if (searchNode.value < currentNode.value) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        return null;
    }
    //endregion

    //region Tree Visualization
    @Override
    public String toString() {
        return Arrays.stream(toStringTree("", root, false).split("\n"))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String toStringTree(String prefix, Node node, boolean isRightChild) {
        if (node == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        // Process right subtree
        if (hasRight(node)) {
            result.append(toStringTree(
                    prefix + (prefix.isEmpty() ? "      " : (isRightChild ? "      " : "|     ")),
                    node.right,
                    true
            ));
        }

        // Process current node
        result.append(prefix)
                .append("[")
                .append(String.format("%02d", node.value))
                .append("]");

        if (hasChildren(node)) {
            result.append(hasLeft(node) && hasRight(node) ? "--|" :
                    hasLeft(node) ? "--," : "--'");
        }
        result.append(System.lineSeparator());

        // Process left subtree
        if (hasLeft(node)) {
            result.append(toStringTree(
                    prefix + (isRightChild ? "|     " : "      "),
                    node.left,
                    false
            ));
        }

        return result.toString();
    }
    //endregion

    //region Basic Operations
    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }

        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) {
                return false;
            }
            if (newNode.value < temp.value) {
                if (!hasLeft(temp)) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (!hasRight(temp)) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        Node temp = root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }
    //endregion

    //region Recursive Operations
    public boolean rContains(int value) {
        return rContains(root, value);
    }

    private boolean rContains(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (node.value == value) {
            return true;
        }
        return rContains(node.value < value ? node.right : node.left, value);
    }

    public void rInsert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        rInsert(root, value);
    }

    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null) {
            return new Node(value);
        }
        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }

    public void deleteNode(int value) {
        root = deleteNode(root, value);
    }

    private Node deleteNode(Node currentNode, int value) {
        if (currentNode == null) {
            return null;
        }
        if (value < currentNode.value) {
            currentNode.left = deleteNode(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = deleteNode(currentNode.right, value);
        } else {
            if (isLeaf(currentNode)) {
                return null;
            } else if (!hasLeft(currentNode)) {
                currentNode = currentNode.right;
            } else if (!hasRight(currentNode)) {
                currentNode = currentNode.left;
            } else {
                int minValue = minValue(currentNode.right);
                currentNode.value = minValue;
                currentNode.right = deleteNode(currentNode.right, minValue);
            }
        }
        return currentNode;
    }

    private int minValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }
    //endregion

    //region Tree Traversal

    /**
     * Breadth-First Search traversal
     */
    public ArrayList<Integer> bfs() {
        Node current = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(current);

        while (!queue.isEmpty()) {
            current = queue.remove();
            result.add(current.value);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return result;
    }

    /**
     * Depth-First Search - Preorder traversal (Root -> Left -> Right)
     */
    public ArrayList<Integer> dfsPreorder() {
        ArrayList<Integer> result = new ArrayList<>();
        traversePreorder(root, result);
        return result;
    }

    private void traversePreorder(Node current, ArrayList<Integer> result) {
        if (current == null) return;
        result.add(current.value);
        traversePreorder(current.left, result);
        traversePreorder(current.right, result);
    }

    /**
     * Depth-First Search - Postorder traversal (Left -> Right -> Root)
     */
    public ArrayList<Integer> dfsPostorder() {
        ArrayList<Integer> result = new ArrayList<>();
        traversePostorder(root, result);
        return result;
    }

    private void traversePostorder(Node current, ArrayList<Integer> result) {
        if (current == null) return;
        traversePostorder(current.left, result);
        traversePostorder(current.right, result);
        result.add(current.value);
    }

    /**
     * Depth-First Search - Inorder traversal (Left -> Root -> Right)
     */
    public ArrayList<Integer> dfsInorder() {
        ArrayList<Integer> result = new ArrayList<>();
        traverseInorder(root, result);
        return result;
    }

    private void traverseInorder(Node current, ArrayList<Integer> result) {
        if (current == null) return;
        traverseInorder(current.left, result);
        result.add(current.value);
        traverseInorder(current.right, result);
    }
    //endregion
}