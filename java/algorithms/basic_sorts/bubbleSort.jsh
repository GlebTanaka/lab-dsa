
/**
 * Implements the bubble sort algorithm to sort an array in ascending order.
 * Time Complexity: O(n²) in worst and average cases
 * Space Complexity: O(1)
 * @param arr the array to be sorted
 */
public static void bubbleSort(int[] arr) {
    // Get the length of array
    int n = arr.length;

    // Flag to optimize the algorithm - if no swaps occur in a pass,
    // the array is already sorted
    boolean swapped;

    // Outer loop for passes
    for (int i = 0; i < n - 1; i++) {
        swapped = false;

        // Inner loop for comparing adjacent elements
        // With each pass, the largest unsorted element "bubbles up" to its correct position
        for (int j = 0; j < n - i - 1; j++) {
            // Compare adjacent elements
            if (arr[j] > arr[j + 1]) {
                // Swap if they are in wrong order
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swapped = true;
            }
        }

        // If no swapping occurred in this pass,
        // array is already sorted, so break
        if (!swapped) {
            break;
        }
    }
}