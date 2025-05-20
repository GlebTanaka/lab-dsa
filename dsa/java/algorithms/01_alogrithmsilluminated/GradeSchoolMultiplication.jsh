public class GradeSchoolMultiplication {
    public static String multiply(String num1, String num2) {
        // Handle edge cases
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        // Convert strings to char arrays for easier digit manipulation
        char[] first = num1.toCharArray();
        char[] second = num2.toCharArray();

        // Result array will have maximum length of num1.length + num2.length
        int[] result = new int[first.length + second.length];

        // Iterate from right to left for both numbers
        for (int i = first.length - 1; i >= 0; i--) {
            for (int j = second.length - 1; j >= 0; j--) {
                // Convert chars to integers and multiply
                int digit1 = first[i] - '0';
                int digit2 = second[j] - '0';

                // Add to existing value at position
                int product = digit1 * digit2;
                int pos1 = i + j;
                int pos2 = i + j + 1;

                // Add product to result
                int sum = product + result[pos2];

                // Update current position
                result[pos2] = sum % 10;
                // Add carry to previous position
                result[pos1] += sum / 10;
            }
        }

        // Convert result array to string, removing leading zeros
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for (int digit : result) {
            if (digit != 0) {
                leadingZero = false;
            }
            if (!leadingZero) {
                sb.append(digit);
            }
        }

        return sb.isEmpty() ? "0" : sb.toString();
    }
}