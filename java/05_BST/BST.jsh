public class BinarySearchTree {

    private Node root;

    private class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

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

    //************ searching Parent Node of a Node *****************

    // recursive
    public Node parentOf(Node searchNode) {
        if (searchNode == root) {
            return null; // or throw an exception
        }
        return parentOf(root, searchNode);
    }

    // helper method with Short-Circuiting
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

    // iterative:
    public Node parentOfIter(Node searchNode) {
        if (searchNode == null) {
            throw new IllegalArgumentException("Search node cannot be null");
        }
        if (searchNode == root) {
            return null; // Root node has no parent
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
        return null; // Node not found
    }

    public String toStringTree() {
        if (root == null) {
            return "Tree is empty.";
        }
        return toStringTree("", root, false);
    }

    private String toStringTree(String prefix, Node node, boolean isRightChild) {
        if (node == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        // Process right subtree
        if (hasRight(node)) {
            result.append(toStringTree(prefix + (isRightChild ? "      " : "│     "), node.right, true));
        }

        // Process current node
        result.append(prefix)
                .append("[")
                .append(String.format("%02d", node.value))
                .append("]");

        if (hasChildren(node)) {
            if (hasLeft(node) && hasRight(node)) {
                result.append("──┤");
            } else if (hasLeft(node)) {
                result.append("──┐");
            } else {
                result.append("──┘");
            }
        }
        result.append(System.lineSeparator());

        // Process left subtree
        if (hasLeft(node)) {
            result.append(toStringTree(prefix + (isRightChild ? "│     " : "      "), node.left, false));
        }

        return result.toString();
    }

    public boolean insert(int value) {
        /*
        create newNode
        if root == null then root = newNode
        temp = root
        while loop
            if newNode == temp return false
            if < left else > right
            if null insert newNode else move to next
         */
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
        /*
        if root == null return false <- optional step
        tempt = root
        while temp != null
            if < left
            else if > right
            else == return true
        return false
         */
        // if (root == null) {return false;} // optional step
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

}