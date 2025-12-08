import java.util.HashMap;
import java.util.Map;

// Dynamic Programming — Fibonacci with Memoization (Top-Down)
//
// How to run in JShell (paths are relative to project root):
//
//   jshell> /open 10_dynamic_programming/FibonacciMemoization.jsh
//   jshell> FibonacciMemoization.main(new String[]{})
//   jshell> FibonacciMemoization.main(new String[]{"45"})
//
// Notes:
// - Memoization caches previously computed results so each F(n) is computed once.
// - Time complexity: O(n). Space complexity: O(n) for the cache and recursion depth.
// - Uses long for larger Fibonacci values than fit in int. Adjust as needed.

public class FibonacciMemoization {
    // Cache base cases: F(0)=0, F(1)=1
    private static final Map<Integer, Long> memo = new HashMap<>(Map.of(0, 0L, 1, 1L));

    public static long fib(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        // computeIfAbsent lazily computes and stores the value if it's missing
        return memo.computeIfAbsent(n, k -> fib(k - 1) + fib(k - 2));
    }

    // Example usage:
    // - No args: computes F(10)
    // - One arg: parses n and computes F(n)
    public static void main(String[] args) {
        int n = 10;
        if (args != null && args.length > 0) {
            n = Integer.parseInt(args[0]);
        }

        long start = System.nanoTime();
        long value = fib(n);
        long durationNs = System.nanoTime() - start;

        System.out.println("F(" + n + ") = " + value);
        System.out.println("Computed with memoization in " + durationNs / 1_000_000.0 + " ms");
    }
}
