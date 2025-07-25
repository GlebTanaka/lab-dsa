// Calculate factorial recursively and print the call stack
    void printCallStack(String methodName, int n) {
        // Get the current thread's stack trace
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        // Build indentation based on stack depth
        String indent = "  ".repeat(stackTrace.length - 3);

        System.out.println(indent + methodName + "(" + n + ") called");
    }

    int factorial(int n) {
        printCallStack("factorial", n);

        if (n <= 1) {
            System.out.println("  ".repeat(Thread.currentThread().getStackTrace().length - 2) + "Base case: returning 1");
            return 1;
        }

        int result = n * factorial(n - 1);
        System.out.println("  ".repeat(Thread.currentThread().getStackTrace().length - 2) + "Returning: " + result);
        return result;
    }

// Test the factorial function with a small number to see the call stack
    System.out.println("Computing factorial(4):");
    int result = factorial(4);
    System.out.println("\nFinal result: " + result);