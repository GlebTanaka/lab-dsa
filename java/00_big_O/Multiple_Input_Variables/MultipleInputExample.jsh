import java.util.ArrayList;
import java.util.List;

void findCommonElements(int[] list1, int[] list2) {
  List<Integer> common = new ArrayList<>();

  for (int i = 0; i < list1.length; i++) {
    for (int j = 0; j < list2.length; j++) {
      if (list1[i] == list2[j]) {
        common.add(list1[i]);
      }
    }
  }
  System.out.println("Common Elements: " + common);
}

int[] list1 = {1, 2, 3, 4};
int[] list2 = {3, 4, 5, 6};

findCommonElements(list1, list2);
