import java.util.Arrays;

public class KaratsubaMultiplication {
        public static String multiply(String num1, String num2) {
            // Handle edge cases
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }

            // Convert strings to arrays of digits
            int[] first = stringToDigitArray(num1);
            int[] second = stringToDigitArray(num2);

            // Get result using Karatsuba algorithm
            int[] result = karatsubaMultiply(first, second);

            // Convert result back to string
            return digitArrayToString(result);
        }

        private static int[] karatsubaMultiply(int[] x, int[] y) {
            int n = Math.max(x.length, y.length);

            // Pad arrays to equal length
            x = padArray(x, n);
            y = padArray(y, n);

            // Base case for small numbers
            if (n <= 32) {
                return simpleMultiply(x, y);
            }

            // Calculate split point (middle)
            int m = n / 2;
            int m2 = n - m;

            // Split numbers into high and low parts
            int[] xl = Arrays.copyOfRange(x, 0, x.length - m);
            int[] xr = Arrays.copyOfRange(x, x.length - m, x.length);
            int[] yl = Arrays.copyOfRange(y, 0, y.length - m);
            int[] yr = Arrays.copyOfRange(y, y.length - m, y.length);

            // Recursive steps
            int[] p1 = karatsubaMultiply(xl, yl);    // a*c
            int[] p2 = karatsubaMultiply(xr, yr);    // b*d

            // Calculate (a+b)*(c+d)
            int[] xlxr = addArrays(xl, xr);
            int[] ylyr = addArrays(yl, yr);
            int[] p3 = karatsubaMultiply(xlxr, ylyr);

            // p3 = p3 - p1 - p2, giving us (a+b)*(c+d) - ac - bd
            p3 = subtractArrays(p3, p1);
            p3 = subtractArrays(p3, p2);

            // Combine results: p1*10^(2m) + p3*10^m + p2
            int[] result = new int[2 * n];
            addArrays(result, p1, 2 * m);
            addArrays(result, p3, m);
            addArrays(result, p2, 0);

            return result;
        }

        private static int[] simpleMultiply(int[] x, int[] y) {
            int[] result = new int[x.length + y.length];
            for (int i = x.length - 1; i >= 0; i--) {
                for (int j = y.length - 1; j >= 0; j--) {
                    int product = x[i] * y[j];
                    int pos1 = i + j;
                    int pos2 = i + j + 1;

                    int sum = product + result[pos2];
                    result[pos2] = sum % 10;
                    result[pos1] += sum / 10;
                }
            }
            return result;
        }

        private static int[] stringToDigitArray(String num) {
            int[] digits = new int[num.length()];
            for (int i = 0; i < num.length(); i++) {
                digits[i] = num.charAt(i) - '0';
            }
            return digits;
        }

        private static String digitArrayToString(int[] digits) {
            StringBuilder sb = new StringBuilder();
            boolean leadingZero = true;
            for (int digit : digits) {
                if (digit != 0) {
                    leadingZero = false;
                }
                if (!leadingZero) {
                    sb.append(digit);
                }
            }
            return sb.isEmpty() ? "0" : sb.toString();
        }

        private static int[] padArray(int[] arr, int length) {
            if (arr.length >= length) {
                return arr;
            }
            int[] padded = new int[length];
            System.arraycopy(arr, 0, padded, length - arr.length, arr.length);
            return padded;
        }

        private static int[] addArrays(int[] x, int[] y) {
            int maxLen = Math.max(x.length, y.length);
            int[] result = new int[maxLen + 1];
            int carry = 0;

            for (int i = maxLen - 1; i >= 0; i--) {
                int sum = carry;
                if (i < x.length) sum += x[i];
                if (i < y.length) sum += y[i];
                result[i + 1] = sum % 10;
                carry = sum / 10;
            }
            result[0] = carry;
            return result;
        }

        private static void addArrays(int[] result, int[] x, int shift) {
            int carry = 0;
            for (int i = x.length - 1; i >= 0; i--) {
                int pos = i + shift;
                int sum = result[pos] + x[i] + carry;
                result[pos] = sum % 10;
                carry = sum / 10;
            }
            if (carry > 0 && shift > 0) {
                result[shift - 1] += carry;
            }
        }

        private static int[] subtractArrays(int[] x, int[] y) {
            int[] result = Arrays.copyOf(x, x.length);
            int borrow = 0;

            for (int i = result.length - 1; i >= 0; i--) {
                int diff = result[i] - (i < y.length ? y[i] : 0) - borrow;
                if (diff < 0) {
                    diff += 10;
                    borrow = 1;
                } else {
                    borrow = 0;
                }
                result[i] = diff;
            }
            return result;
        }
    }