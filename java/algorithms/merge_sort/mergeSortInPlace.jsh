    public static void mergeSortInPlace(int[] array) {
        // Create auxiliary array only once
        int[] aux = new int[array.length];
        mergeSortHelper(array, aux, 0, array.length - 1);
    }

        private static void mergeSortHelper(int[] array, int[] aux, int low, int high) {
            if (low < high) {
                int mid = low + (high - low) / 2;

                // Recursive calls
                mergeSortHelper(array, aux, low, mid);
                mergeSortHelper(array, aux, mid + 1, high);

                // Merge the sorted halves
                mergeInPlace(array, aux, low, mid, high);
            }
        }

        private static void mergeInPlace(int[] array, int[] aux, int low, int mid, int high) {
            // Copy to auxiliary array
            for (int k = low; k <= high; k++) {
                aux[k] = array[k];
            }

            int i = low;     // Index for left half
            int j = mid + 1; // Index for right half
            int k = low;     // Index for merged array

            // Merge back to original array
            while (i <= mid && j <= high) {
                if (aux[i] <= aux[j]) {
                    array[k++] = aux[i++];
                } else {
                    array[k++] = aux[j++];
                }
            }

            // Copy remaining elements from left half
            while (i <= mid) {
                array[k++] = aux[i++];
            }
            // No need to copy remaining right half as it's already in place
        }