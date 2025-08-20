import java.util.*;

int[] mergeSort02(int[] array) {
    if (array.length <= 1) return array;

    int mid = array.length / 2;
    int[] left = mergeSort02(Arrays.copyOfRange(array, 0, mid));
    int[] right = mergeSort02(Arrays.copyOfRange(array, mid, array.length));

    return merge(left, right);
}

int[] merge(int[] left, int[] right) {
    int[] result = new int[left.length + right.length];
    int i = 0, j = 0, k = 0;

    while (i < left.length && j < right.length) {
        if (left[i] <= right[j]) result[k++] = left[i++];
        else result[k++] = right[j++];
    }

    while (i < left.length) result[k++] = left[i++];
    while (j < right.length) result[k++] = right[j++];
    return result;
}

// Benchmark
var rand = new Random(42);
int[] data = new int[10000];
for (int i = 0; i < data.length; i++) data[i] = rand.nextInt(100000);

long start = System.nanoTime();
var sorted = mergeSort02(data);
long elapsed = System.nanoTime() - start;

System.out.println("First 10: " + Arrays.toString(Arrays.copyOf(sorted, 10)) + " ...");
System.out.printf("Time taken: %.6f ms%n", elapsed / 1_000_000.0);