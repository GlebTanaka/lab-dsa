/**
 * Implements the selection sort algorithm to sort an array in ascending order.
 * Time Complexity: O(n²) in all cases (worst, average, and best)
 * Space Complexity: O(1)
 * @param arr the array to be sorted
 */
public static void selectionSort(int[] arr) {
    int n = arr.length;

    // Iterate through the array
    // After each iteration, one element is placed in its final position
    for (int i = 0; i < n - 1; i++) {
        // Assume the current index has the minimum value
        int minIndex = i;

        // Find the minimum element in the unsorted portion of the array
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }

        // If minimum element is not at current position,
        // swap it with the element at current position
        if (minIndex != i) {
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}