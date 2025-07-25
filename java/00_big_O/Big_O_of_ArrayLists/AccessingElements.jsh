import java.util.ArrayList;

ArrayList<Integer> list = new ArrayList<>();
list.add(10); // O(1)
list.add(20); // O(1)
list.add(30); // O(1)
// O(1 + 1 + 1) => O(3) => O(1)

// Accessing element by index => O(1)
System.out.println("Element ad index 1: " + list.get(1)); // Output: 20
