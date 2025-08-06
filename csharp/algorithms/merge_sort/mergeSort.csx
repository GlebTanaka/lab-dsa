public static int[] merge(int[] arr1, int[] arr2) {
    int[] result = new int[arr1.length + arr2.length];
    int i = 0, j = 0, k = 0;
    
    // Compare elements from both arrays and merge in sorted order
    while (i < arr1.length && j < arr2.length) {
        if (arr1[i] <= arr2[j]) {
            result[k++] = arr1[i++];
        } else {
            result[k++] = arr2[j++];
        }
    }
    
    // Copy remaining elements from arr1 if any
    while (i < arr1.length) {
        result[k++] = arr1[i++];
    }
    
    // Copy remaining elements from arr2 if any
    while (j < arr2.length) {
        result[k++] = arr2[j++];
    }
    
    return result;
}

public static void mergeSort01(int[] arr) {
    // Base case: if array has 1 or fewer elements, it's already sorted
    if (arr == null || arr.length <= 1) {
        return;
    }
    
    // Find the middle point to divide array in two halves
    int mid = arr.length / 2;
    
    // Create left and right subarrays
    int[] left = new int[mid];
    int[] right = new int[arr.length - mid];
    
    // Fill left subarray
    for (int i = 0; i < mid; i++) {
        left[i] = arr[i];
    }
    
    // Fill right subarray
    for (int i = mid; i < arr.length; i++) {
        right[i - mid] = arr[i];
    }
    
    // Recursively sort the two halves
    mergeSort01(left);
    mergeSort01(right);
    
    // Merge the sorted halves using our merge helper function
    int[] merged = merge(left, right);
    
    // Copy the merged result back to original array
    for (int i = 0; i < arr.length; i++) {
        arr[i] = merged[i];
    }
}