import java.util.stream.IntStream;

public class Fib5 {
    private int last = 0, next = 1;  // Instance variables for state

    public IntStream stream() {
        return IntStream.generate(() -> {
            int oldLast = last;       // Save current number
            last = next;              // Move to next number
            next = oldLast + next;    // Calculate new next
            return oldLast;           // Return saved number
        });
    }

    public static void main(String[] args) {
        Fib5 fib5 = new Fib5();
        fib5.stream()                                   // Create infinite stream
                .limit(41)                      // Take only first 41 numbers
                .forEachOrdered(System.out::println);   // Process in order
    }
}