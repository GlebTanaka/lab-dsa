import java.util.HashMap;
import java.util.function.Predicate;
import java.util.Arrays;

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

public int lenLongestFibSubseq(int[] arr) {
    // Define the Predicateas a lambda expression
    Predicate<Long> isPerfectSquare = num -> {
        long sqrt = (long) Math.sqrt(num);
	return sqrt * sqrt == num;
    };

    // use a stream to count Fibonacci numbers
    int count = (int) Arrays.stream(arr).
        filter(n -> n > 0). // only precess positive numbers
	filter(n -> {
	    //check if the number is a Fibonacci number
	    long n1 = 5L * n * n + 4;
	    long n2 = 5L * n * n - 4;
	    return isPerfectSquare.test(n1) || isPerfectSquare.test(n2);
    }).count(); // Terminal operation to count the resuls

    return count;
}

// longest Fibonacci-like subsequence in an in array

   public int lenLongestFibSubseq(int[] arr) {

        if (arr.length < 3) {
            return 0; // No Fibonacci-like subsequence possible with fewer than 3 elements
        }

        // Store all array elements into a HashSet for O(1) lookups
        Set<Integer> arraySet = new HashSet<>();
        for (int num : arr) {
            arraySet.add(num);
        }

        // Map to store the longest subsequence ending with (x, y)
        Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
        int maxLength = 0;

         // Traverse all pairs of numbers in the array
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                int x = arr[j]; // First number in the pair
                int y = arr[i]; // Second number in the pair
                int z = x + y;  // The expected third number

                // Only update dp and maxLength if the third number z exists in the array
                if (arraySet.contains(z)) {
                    // Get the length of the sequence ending at (x, y), defaulting to 2
                    int length = dp.getOrDefault(x, new HashMap<>()).getOrDefault(y, 2);

                    // Update dp for the current pair (y, z)
                    dp.computeIfAbsent(y, k -> new HashMap<>()).put(z, length + 1);

                    // Update maxLength with the new length
                    maxLength = Math.max(maxLength, length + 1);
                }
            }
        }

        // A valid Fibonacci-like sequence must have at least 3 elements
        return maxLength >= 3 ? maxLength : 0;
    }

