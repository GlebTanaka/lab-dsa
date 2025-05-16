void printPairs(int[] arr) {
  for (int i = 0; i < arr.length; i++) {
    for (int j = 0; j < arr.length; j++) {
      System.out.println("Pair: (" + arr[i] + ", " + arr[j] + ")");
    }
  }
}

int[] numbers = {1, 2, 3, 4};
printPairs(numbers);
