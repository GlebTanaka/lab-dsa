import java.util.ArrayList;

ArrayList<Integer> list = new ArrayList<>();
list.add(10);
list.add(30);
list.add(1, 20); // Adding 20 at index 1 => 0(n)

System.out.println("List after addition: " + list); // Output: [10, 20, 30]
