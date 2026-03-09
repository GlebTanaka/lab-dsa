# C# Data Structures and Algorithms (DSA) Scripting Project

This repository contains my personal implementations and studies of Data Structures and Algorithms (DSA) using C# scripts (`.csx` files). The project follows a script-based approach, which allows for quick testing and experimentation in the terminal.

## How to Test the Files

To run these `.csx` files, you can use the `dotnet-script` tool or the `csi` (C# Interactive) tool.

### Using `dotnet-script` (Recommended)

1.  **Install `dotnet-script`:**
    If you don't have it installed, you can install it as a global .NET tool:
    ```powershell
    dotnet tool install -g dotnet-script
    ```

2.  **Run a script:**
    Navigate to the project root or a specific folder and run:
    ```powershell
    dotnet-script path/to/file.csx
    ```
    For example:
    ```powershell
    dotnet-script 01_linked_lists\TestLinkedList.csx
    ```

### Using `csi` (C# Interactive)

If you have Visual Studio or the .NET SDK build tools installed, you might have `csi` available in your path:

```powershell
csi path/to/file.csx
```

## Topics Already Covered

The project is organized into folders covering various DSA concepts:

-   **00_big_O**: Big O Notation examples including:
    -   Big O of Lists (Accessing, Adding, Removing, Iterating, Resizing)
    -   Constant Time Complexity ($O(1)$)
    -   Logarithmic Time Complexity ($O(\log n)$)
    -   Multiple Input Variables ($O(a + b)$)
    -   $O(n)$ Time Complexity
    -   $O(n^2)$ Time Complexity (Quadratic, Non-Dominant)
-   **01_linked_lists**: Singly Linked List implementation and tests.
-   **02_doubly_linked_list**: Doubly Linked List implementation.
-   **03_stack**: Stack implementation.
-   **04_queue**: Queue implementation.
-   **05_BST**: Binary Search Tree (BST) both recursive and iterative implementations.
-   **06_hash_table**: Hash Table implementations (Chained, Open Addressing).
-   **algorithms\badic_sorts**: Basic sorting algorithms (Bubble Sort, Insertion Sort, Selection Sort).
-   **algorithms\merge_sort**: Advanced sorting (Merge Sort) and benchmarking.
-   **bitwise**: Bitwise operations (e.g., XOR Swap).

## Project Structure

The files are organized into directories based on the topic. Most data structure implementations have a corresponding test script to verify functionality.
