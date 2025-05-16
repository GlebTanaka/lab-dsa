import java.util.ArrayList;
import java.util.Arrays
import java.util.List;

List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30));

list.remove(1); // removes element at index 1 (20) => O(n)

System.out.println("List after removal: " + list); // Output: [10, 30]
