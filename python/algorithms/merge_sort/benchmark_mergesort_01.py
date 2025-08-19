# benchmark_mergesort_01.py
import random
import time

def merge_sort02(arr):
    if len(arr) <= 1:
        return arr

    mid = len(arr) // 2
    left = merge_sort02(arr[:mid])
    right = merge_sort02(arr[mid:])

    return merge(left, right)

def merge(left, right):
    result = []
    i = j = 0

    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1

    result.extend(left[i:])
    result.extend(right[j:])
    return result

# Generate the same dataset
random.seed(42)  # ensure the same numbers every run
data = [random.randint(0, 100000) for _ in range(10000)]

# Benchmark
start_time = time.perf_counter()
sorted_data = merge_sort02(data)
elapsed_time = time.perf_counter() - start_time

print(f"Sorted: {sorted_data[:10]} ...")  # preview first 10
print(f"Time taken: {elapsed_time:.6f} seconds")