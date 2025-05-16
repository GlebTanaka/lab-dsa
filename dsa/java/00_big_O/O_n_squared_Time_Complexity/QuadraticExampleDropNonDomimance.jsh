void printItems(int n) {
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      System.out.println(i + " " + j); // O(n^2)
    }
  }

  for (int k = 0; k < n; k++) { 
    System.out.println(k);             // O(n)
  }
}

printItems(10);
