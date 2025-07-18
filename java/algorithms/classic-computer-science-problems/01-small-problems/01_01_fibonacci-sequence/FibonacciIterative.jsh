public class Fib4 {

    private static int fib4(int n) {
        int last = 0, next = 1;      // Initialize with F(0) and F(1)
        for (int i = 0; i < n; i++) {
            int oldLast = last;       // Store F(n-2)
            last = next;              // F(n-1) becomes the last number
            next = oldLast + next;    // Calculate F(n) = F(n-2) + F(n-1)
        }
        return last;
    }


    public static void main(String[] args) {
        System.out.println(fib4(20));
        System.out.println(fib4(40));
    }
}