import java.util.HashMap;

// exponential time complexity O(2^n)
public static int fibRecursive(int n) {
        if (n <= 1) {
            return n; // Base case: fib(0) = 0, fib(1) = 1
        }
        return fibRecursive(n - 1) + fibRecursive(n - 2); // Recursive case
}

// linear time complexity O(n)
public static int fib(int n) {
    return fibHelper(n, new HashMap<>()); // Pass a new HashMap to every function call
}

private static int fibHelper(int n, HashMap<Integer, Integer> memo) {
    if (n <= 1) {
        return n; // Base case: fib(0) = 0, fib(1) = 1
    }

    // If the result is already in the cache, return it
    if (memo.containsKey(n)) {
        return memo.get(n);
    }

    // Otherwise, calculate and store the result in the cache
    int result = fibHelper(n - 1, memo) + fibHelper(n - 2, memo);
    memo.put(n, result);

    return result;
}


