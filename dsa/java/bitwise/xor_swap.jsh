    public class VariableSwapping {
        public static void main(String[] args) {
            // Method 1: Using temporary variable
            int a = 5;
            int b = 10;
            System.out.println("Before swap: a = " + a + ", b = " + b);

            // Swapping using temp variable
            int temp = a;
            a = b;
            b = temp;
            System.out.println("After swap with temp: a = " + a + ", b = " + b);

            // Method 2: Using XOR (bitwise) without temp variable
            int x = 5;
            int y = 10;
            System.out.println("\nBefore swap: x = " + x + ", y = " + y);

            // Swapping using XOR
            x = x ^ y;    // x now holds x XOR y
            y = x ^ y;    // y now holds (x XOR y) XOR y = x
            x = x ^ y;    // x now holds (x XOR y) XOR x = y

            System.out.println("After swap with XOR: x = " + x + ", y = " + y);
        }
    }