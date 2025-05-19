public class SimpleGradeSchoolMultiplication {
        // Helper method to add zero at the end of string
        private static String addZeroAtEnd(String num, int count) {
            return num + "0".repeat(Math.max(0, count));
    }

        // Helper method to add two numbers represented as strings
        private static String addNumbers(String num1, String num2) {
        // Pad shorter number with leading zeros to make lengths equal
        int maxLength = Math.max(num1.length(), num2.length());
        num1 = "0".repeat(maxLength - num1.length()) + num1;
        num2 = "0".repeat(maxLength - num2.length()) + num2;

        StringBuilder result = new StringBuilder();
        int carry = 0;

        // Add digits from right to left
        for (int i = maxLength - 1; i >= 0; i--) {
        int digit1 = num1.charAt(i) - '0';
        int digit2 = num2.charAt(i) - '0';
        int sum = digit1 + digit2 + carry;
        carry = sum / 10;
        result.insert(0, (char)(sum % 10 + '0'));
    }

        // Add remaining carry if exists
        if (carry > 0) {
        result.insert(0, carry);
    }

        return result.toString();
    }

        // Helper method to multiply a number by a single digit
        private static String multiplySingleDigit(String num, char digit) {
        if (digit == '0') return "0";

        int carry = 0;
        StringBuilder result = new StringBuilder();
        int multiplier = digit - '0';

        // Multiply each digit from right to left
        for (int i = num.length() - 1; i >= 0; i--) {
        int product = (num.charAt(i) - '0') * multiplier + carry;
        carry = product / 10;
        result.insert(0, (char)(product % 10 + '0'));
    }

        // Add remaining carry if exists
        if (carry > 0) {
        result.insert(0, carry);
    }

        return result.toString();
    }

        public static String multiply(String num1, String num2) {
        // Handle edge cases
        if (num1.equals("0") || num2.equals("0")) {
        return "0";
    }

        String result = "0";

        // Multiply each digit of second number with first number
        for (int i = num2.length() - 1; i >= 0; i--) {
        // 1. Multiply single digit
        String partial = multiplySingleDigit(num1, num2.charAt(i));

        // 2. Add zeros at end based on position
        partial = addZeroAtEnd(partial, num2.length() - 1 - i);

        // 3. Add to result
        result = addNumbers(result, partial);
    }

        return result;
    }
}