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


