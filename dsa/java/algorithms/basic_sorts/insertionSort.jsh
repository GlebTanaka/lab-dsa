
/**
 * Implements the insertion sort algorithm to sort an array in ascending order.
 * Time Complexity: O(n²) worst/average case, O(n) best case
 * Space Complexity: O(1)
 * @param arr the array to be sorted
 */
public static void insertionSort(int[] arr) {
    int n = arr.length;

    // Start from the second element
    // (first element is considered sorted by itself)
    for (int i = 1; i < n; i++) {
        // Store the current element to be inserted
        int key = arr[i];

        // Initialize j as the index right before i
        int j = i - 1;

        // The j >= 0 check MUST come first in the condition
        // due to short-circuit evaluation - if j < 0, the second
        // condition won't be evaluated, preventing array access with negative index
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }

        // Place the key in its correct position
        arr[j + 1] = key;
    }
}