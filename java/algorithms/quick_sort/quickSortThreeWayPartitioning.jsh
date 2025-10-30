public static void quickSort3Way(int[] arr, int low, int high) {
    if (high <= low) return;

    int lt = low;      // less than pivot
    int gt = high;     // greater than pivot
    int i = low + 1;   // scanning pointer
    int pivot = arr[low];

    while (i <= gt) {
        if (arr[i] < pivot) {
            swap(arr, lt++, i++);
        }
        else if (arr[i] > pivot) {
            swap(arr, i, gt--);
        }
        else {
            i++;
        }
    }

    // Now arr[low..lt-1] < pivot = arr[lt..gt] < arr[gt+1..high]
    quickSort3Way(arr, low, lt - 1);
    quickSort3Way(arr, gt + 1, high);
}

private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}