
using System;
using System.Diagnostics;

int[] MergeSort02(int[] array) {
    if (array.Length <= 1) return array;

    int mid = array.Length / 2;
    var left = MergeSort02(array[..mid]);
    var right = MergeSort02(array[mid..]);

    return Merge(left, right);
}

int[] Merge(int[] left, int[] right) {
    int[] result = new int[left.Length + right.Length];
    int i = 0, j = 0, k = 0;

    while (i < left.Length && j < right.Length) {
        if (left[i] <= right[j]) result[k++] = left[i++];
        else result[k++] = right[j++];
    }

    while (i < left.Length) result[k++] = left[i++];
    while (j < right.Length) result[k++] = right[j++];
    return result;
}

// Benchmark
var rand = new Random(42);
int[] data = new int[10000];
for (int i = 0; i < data.Length; i++) data[i] = rand.Next(0, 100000);

var sw = Stopwatch.StartNew();
var sorted = MergeSort02(data);
sw.Stop();

Console.WriteLine($"First 10: {string.Join(", ", sorted[..10])} ...");
Console.WriteLine($"Time taken: {sw.Elapsed.TotalMilliseconds} ms");