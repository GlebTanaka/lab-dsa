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