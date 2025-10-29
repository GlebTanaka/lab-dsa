private static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
        // Choose middle element as pivot
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // Move pivot to end
        swap(arr, middle, high);

        int i = low;
        int j = high - 1;

        while (i <= j) {
            // Find element on left that should be on right
            while (i <= j && arr[i] < pivot) {
                i++;
            }

            // Find element on right that should be on left
            while (i <= j && arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        // Put pivot in its final position
        swap(arr, i, high);

        quickSort(arr, low, i - 1);
        quickSort(arr, i + 1, high);
    }
}

private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}