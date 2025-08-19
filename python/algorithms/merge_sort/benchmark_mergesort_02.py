# Python
import gc
import heapq
import random
import statistics
import time
from typing import List, Any, Callable

# 1) Recursive, slice-based merge sort
def merge_sort_recursive(arr: List[int]) -> List[int]:
    if len(arr) <= 1:
        return arr
    mid = len(arr) // 2
    left = merge_sort_recursive(arr[:mid])
    right = merge_sort_recursive(arr[mid:])
    return merge_simple(left, right)

def merge_simple(left: List[int], right: List[int]) -> List[int]:
    result = []
    i = j = 0
    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            result.append(left[i]); i += 1
        else:
            result.append(right[j]); j += 1
    result.extend(left[i:])
    result.extend(right[j:])
    return result

# 2) Bottom-up, buffer-reusing merge sort (iterative, no slicing)
def mergesort_bottom_up(a: List[Any]) -> List[Any]:
    n = len(a)
    if n <= 1:
        return a
    temp = [None] * n
    width = 1
    while width < n:
        for left in range(0, n, 2 * width):
            mid = min(left + width, n)
            right = min(left + 2 * width, n)
            i, j, k = left, mid, left
            while i < mid and j < right:
                if a[i] <= a[j]:
                    temp[k] = a[i]; i += 1
                else:
                    temp[k] = a[j]; j += 1
                k += 1
            while i < mid:
                temp[k] = a[i]; i += 1; k += 1
            while j < right:
                temp[k] = a[j]; j += 1; k += 1
            a[left:right] = temp[left:right]
        width *= 2
    return a

# 3) Recursive merge sort using heapq.merge for merging
def merge_sort_heapq(arr: List[int]) -> List[int]:
    if len(arr) <= 1:
        return arr
    mid = len(arr) // 2
    left = merge_sort_heapq(arr[:mid])
    right = merge_sort_heapq(arr[mid:])
    # heapq.merge returns an iterator over the merged sorted sequence
    return list(heapq.merge(left, right))

# Benchmark helpers
def time_once(fn: Callable, *args, **kwargs) -> float:
    start = time.perf_counter()
    fn(*args, **kwargs)
    return time.perf_counter() - start

def bench(fn: Callable[[List[int]], List[int]], data: List[int], trials: int) -> List[float]:
    times: List[float] = []
    for _ in range(trials):
        times.append(time_once(fn, list(data)))  # pass a fresh copy
    return times

def fmt_stats(name: str, times: List[float]) -> None:
    print(
        f"{name}: "
        f"min={min(times):.6f}s, "
        f"median={statistics.median(times):.6f}s, "
        f"mean={statistics.mean(times):.6f}s, "
        f"stdev={statistics.pstdev(times):.6f}s "
        f"(trials={len(times)})"
    )

def main():
    # Config
    seed = 42
    n = 10000
    trials = 10
    show_preview = True

    random.seed(seed)
    data = [random.randint(0, 100_000) for _ in range(n)]

    # Correctness check against built-in sorted
    expected = sorted(data)
    assert merge_sort_recursive(list(data)) == expected
    assert mergesort_bottom_up(list(data)) == expected
    assert merge_sort_heapq(list(data)) == expected

    if show_preview:
        print(f"Preview (first 10): {expected[:10]}")

    # Warmup
    _ = merge_sort_recursive(list(data))
    _ = mergesort_bottom_up(list(data))
    _ = merge_sort_heapq(list(data))
    _ = sorted(list(data))

    gc_was_enabled = gc.isenabled()
    try:
        gc.disable()
        rec_times = bench(merge_sort_recursive, data, trials)
        bu_times = bench(mergesort_bottom_up, data, trials)
        hq_times = bench(merge_sort_heapq, data, trials)
        py_times = bench(sorted, data, trials)
    finally:
        if gc_was_enabled:
            gc.enable()

    print("\nResults:")
    fmt_stats("merge_sort_recursive   ", rec_times)
    fmt_stats("mergesort_bottom_up    ", bu_times)
    fmt_stats("merge_sort_heapq       ", hq_times)
    fmt_stats("built-in sorted        ", py_times)

    med_rec = statistics.median(rec_times)
    med_bu  = statistics.median(bu_times)
    med_hq  = statistics.median(hq_times)
    med_py  = statistics.median(py_times)

    print("\nRelative (median):")
    print(f"- recursive vs built-in : {med_rec/med_py:.2f}x")
    print(f"- bottom-up vs built-in : {med_bu/med_py:.2f}x")
    print(f"- heapq-merge vs built-in: {med_hq/med_py:.2f}x")
    print(f"- recursive vs bottom-up: {med_rec/med_bu:.2f}x")
    print(f"- heapq vs recursive    : {med_hq/med_rec:.2f}x")
    print("\nNote: heapq.merge can be faster than manual merging in Python loops, "
          "but recursion and slicing still add overhead. Bottom-up with a buffer "
          "often performs best among pure-Python mergesorts, while built-in sorted "
          "remains far faster due to optimized C and adaptivity.")

if __name__ == "__main__":
    main()