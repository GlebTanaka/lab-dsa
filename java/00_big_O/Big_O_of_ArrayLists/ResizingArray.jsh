import java.util.ArrayList;

ArrayList<Integer> list = new ArrayList<>(2); // Initial capacity is 2
list.add(10);
list.add(20);
list.add(30); // causes resize to accommodate more elements => O(n)

System.out.println("List after resizing: " + list); // Output: [10, 20, 30]
