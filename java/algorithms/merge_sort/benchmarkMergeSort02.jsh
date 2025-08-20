import java.util.*;
import java.time.*;

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

// Warm-up phase
System.out.println("Warming up...");
for (int i = 0; i < 5; i++) {
    int[] warmupData = Arrays.copyOf(data, data.length);
    mergeSort02(warmupData);
}

// Actual benchmark
System.out.println("\nRunning benchmark...");
int runs = 10;
long[] times = new long[runs];

for (int i = 0; i < runs; i++) {
    int[] testData = Arrays.copyOf(data, data.length);

    long start = System.nanoTime();
    var sorted = mergeSort02(testData);
    times[i] = System.nanoTime() - start;

    if (i == 0) {
        System.out.println("First 10: " + Arrays.toString(Arrays.copyOf(sorted, 10)) + " ...");
    }
}

// Calculate statistics
double avgTime = Arrays.stream(times).average().orElse(0) / 1_000_000.0;
double minTime = Arrays.stream(times).min().orElse(0) / 1_000_000.0;
double maxTime = Arrays.stream(times).max().orElse(0) / 1_000_000.0;

System.out.printf("Average time: %.3f ms%n", avgTime);
System.out.printf("Best time: %.3f ms%n", minTime);
System.out.printf("Worst time: %.3f ms%n", maxTime);