import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(this.heap);
    }

    // helper method
    private int leftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int rightChildIndex(int index) {
        return 2 * index + 2;
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    private void swap(int indexOne, int indexTwo) {
        int temp = this.heap.get(indexOne);
        this.heap.set(indexOne, this.heap.get(indexTwo));
        this.heap.set(indexTwo, temp);
    }

    public void insert(int value) {
        this.heap.add(value);
        int index = this.heap.size() - 1;
        while (index > 0 && this.heap.get(this.parentIndex(index)) < this.heap.get(index)) {
            this.swap(this.parentIndex(index), index);
            index = this.parentIndex(index);
        }
    }

    public Integer extractMax() {
        if (this.heap.isEmpty()) {
            return null;
        }
        int max = this.heap.get(0);
        this.heap.set(0, this.heap.get(this.heap.size() - 1));
        this.heap.remove(this.heap.size() - 1);
        int index = 0;
        while (index < this.heap.size()) {
            int leftChild = this.leftChildIndex(index);
        }
        return max;
    }


}