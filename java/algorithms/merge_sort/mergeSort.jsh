// helper method

import java.util.Arrays;public static int[] merge(int[] arr1, int[] arr2) {
    int[] result = new int[arr1.length + arr2.length];
    int i = 0, j = 0, k = 0;

    // Compare and merge elements from both arrays
    while (i < arr1.length && j < arr2.length) {
        if (arr1[i] <= arr2[j]) {
            result[k++] = arr1[i++];
        } else {
            result[k++] = arr2[j++];
        }
    }

    // Copy remaining elements from arr1, if any
    while (i < arr1.length) {
        result[k++] = arr1[i++];
    }

    // Copy remaining elements from arr2, if any
    while (j < arr2.length) {
        result[k++] = arr2[j++];
    }

    return result;
}

// manually creating arrays and copying elements
public static int[] mergeSort01(int[] arr) {
    // Base case: array of length 0 or 1 is already sorted
    if (arr.length <= 1) {
        return arr;
    }

    // Find the middle point
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

    // Recursively sort both halves
    left = mergeSort01(left);
    right = mergeSort01(right);

    // Merge the sorted halves
    return merge(left, right);
}

//  using the built-in method
public static int[] mergeSort02(int[] array) {
    if (array.length <= 1) {
        return array;
    }

    int mid = array.length / 2;
    int[] left = mergeSort02(Arrays.copyOfRange(array, 0, mid));
    int[] right = mergeSort02(Arrays.copyOfRange(array, mid, array.length));

    return merge(left, right);
}

// using lower-level method
public static int[] mergeSort(int[] array) {
    if (array.length <= 1) {
        return array;
    }

    int mid = array.length / 2;

    int[] left = new int[mid];
    int[] right = new int[array.length - mid];

    // Copy elements to left and right arrays
    System.arraycopy(array, 0, left, 0, mid);
    System.arraycopy(array, mid, right, 0, array.length - mid);

    left = mergeSort(left);
    right = mergeSort(right);

    return merge(left, right);
}