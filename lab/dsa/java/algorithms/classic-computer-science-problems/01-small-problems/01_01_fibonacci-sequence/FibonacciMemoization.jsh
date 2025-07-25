import java.util.HashMap;
import java.util.Map;

    public class FibonacciMemoization {
        // Initialize the memoization cache with base cases
        // Map.of(0, 0, 1, 1) creates an immutable map with initial values
        // We then create a new HashMap from it to make it mutable
        static Map<Integer, Integer> memo = new HashMap<>(Map.of(0, 0, 1, 1));

        public static int fib(int n) {
            // Check if we have already calculated this value
            // This is the key to memoization - we only calculate each value once
            if (!memo.containsKey(n)) {
                // If we haven't calculated it before, calculate it using the Fibonacci formula
                // and store it in our memo map
                // Note: This will recursively call fib() for (n-1) and (n-2),
                // but those values will be retrieved from memo if already calculated
                memo.put(n, fib(n - 1) + fib(n - 2));
            }
            // Return the memoized value
            return memo.get(n);
        }

        // Example usage in main method
        // To call from jshell: FibonacciMemoization.main(new String[]{})
        public static void main(String[] args) {
            System.out.println(fib(10));
        }
    }
