import java.util.Arrays;

private static void swap(int[] array, int firstIndex, int secondIndex) {
    int temp = array[firstIndex];
    array[firstIndex] = array[secondIndex];
    array[secondIndex] = temp;
}

private static int pivot(int[] array, int pivotIndex, int lastIndex) {
    int swapIndex = pivotIndex;
    for (int i = pivotIndex + 1; i <= lastIndex; i++) {
        if (array[i] < array[pivotIndex]) {
            swapIndex++;
            swap(array, swapIndex, i);
        }
    }
    swap(array, pivotIndex, swapIndex);
    return swapIndex;
}

private static void quickSort(int[] array, int startIndex, int lastIndex) {
    if (startIndex < lastIndex) {
        int pivotIndex = pivot(array, startIndex, lastIndex);
        quickSort(array, startIndex, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, lastIndex);
    }
}