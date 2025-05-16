import java.util.ArrayList;
import java.util.List;

List<Integer> mergeSorted(int[] list1, int[] list2) {
  List<Integer> merged = new ArrayList<>();
  int i = 0, j = 0;

  while (i < list1.length && j < list2.length) {
    if (list1[i] < list2[j]) {
      merged.add(list1[i++]);
    } else {
      merged.add(list2[j++]);
    }
  }

  // add remaining elements
  while (i < list1.length) {
    merged.add(list1[i++]);
  }
  while (j < list2.length) {
    merged.add(list2[j++]);
  }
  return merged;
}

int[] list1 = {1, 3, 5};
int[] list2 = {2, 4, 6};

System.out.println(mergeSorted(list1, list2));
