def merge_sort01(arr):
    if len(arr) <= 1:
        return arr

    mid = len(arr) // 2
    left = merge_sort01(arr[:mid])
    right = merge_sort01(arr[mid:])
    return merge(left, right)

def merge(left, right):
    result = []
    i, j = 0, 0
    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1

    # append remaining elements of left, if any
    result.extend(left[i:])
    result.extend(right[j:])
    return result

# test
arr = [12, 11, 13, 5, 6, 7]
print(merge_sort01(arr))