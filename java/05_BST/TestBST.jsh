// First, create a BST instance and perform some insertions
    BinarySearchTree bst = new BinarySearchTree();
    System.out.println("Inserting values: 47, 21, 76, 18, 27, 52, 82");

    bst.insert(47);  // root
    bst.insert(21);  // left subtree
    bst.insert(76);  // right subtree
    bst.insert(18);  // left.left
    bst.insert(27);  // left.right
    bst.insert(52);  // right.left
    bst.insert(82);  // right.right

    // Print the tree structure
    System.out.println("\nTree visualization:");
    System.out.println(bst);

    // Test search operations
    System.out.println("\nSearch operations:");
    System.out.println("Contains 27? " + bst.contains(27));  // true
    System.out.println("Contains 13? " + bst.contains(13));  // false
    System.out.println("Recursive contains 52? " + bst.rContains(52));  // true

    // Test traversal operations
    System.out.println("\nTraversal Results:");
    System.out.println("BFS: " + bst.bfs());  // [47, 21, 76, 18, 27, 52, 82]
    System.out.println("DFS Preorder: " + bst.dfsPreorder());   // [47, 21, 18, 27, 76, 52, 82]
    System.out.println("DFS Inorder: " + bst.dfsInorder());     // [18, 21, 27, 47, 52, 76, 82]
    System.out.println("DFS Postorder: " + bst.dfsPostorder()); // [18, 27, 21, 52, 82, 76, 47]

    // Test deletion
    System.out.println("\nDeleting node 21...");
    bst.deleteNode(21);
    System.out.println("Tree after deletion:");
    System.out.println(bst);

    // Test recursive insertion
    System.out.println("\nInserting 35 recursively...");
    bst.rInsert(35);
    System.out.println("Tree after recursive insertion:");
    System.out.println(bst);

    // Final traversal to verify structure
    System.out.println("\nFinal inorder traversal (should be sorted):");
    System.out.println(bst.dfsInorder());