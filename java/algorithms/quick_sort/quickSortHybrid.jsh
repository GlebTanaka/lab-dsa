int INSERTION_SORT_THRESHOLD = 10;

private static void quickSort(int[] arr, int low, int high) {
    // Use insertion sort for small subarrays
    if (high - low <= INSERTION_SORT_THRESHOLD) {
        insertionSort(arr, low, high);
        return;
    }

    if (low < high) {
        // Use median-of-three for pivot selection
        int pivot = medianOfThree(arr, low, low + (high - low)/2, high);
        int partition = partition(arr, low, high, pivot);

        quickSort(arr, low, partition - 1);
        quickSort(arr, partition + 1, high);
    }
}

private static void insertionSort(int[] arr, int low, int high) {
    for (int i = low + 1; i <= high; i++) {
        int key = arr[i];
        int j = i - 1;

        while (j >= low && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}

private static int medianOfThree(int[] arr, int low, int mid, int high) {
    int a = arr[low];
    int b = arr[mid];
    int c = arr[high];

    // Return the index of the median value
    if (a < b) {
        if (b < c) return mid;
        if (a < c) return high;
        return low;
    } else {
        if (a < c) return low;
        if (b < c) return high;
        return mid;
    }
}

private static int partition(int[] arr, int low, int high, int pivotIndex) {
    int pivotValue = arr[pivotIndex];
    swap(arr, pivotIndex, high);
    int storeIndex = low;

    for (int i = low; i < high; i++) {
        if (arr[i] < pivotValue) {
            swap(arr, i, storeIndex);
            storeIndex++;
        }
    }

    swap(arr, storeIndex, high);
    return storeIndex;
}

private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}