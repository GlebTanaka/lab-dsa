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

    public Integer peek() {
        return heap.isEmpty() ? null : heap.get(0);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void swap(int indexOne, int indexTwo) {
        int temp = this.heap.get(indexOne);
        this.heap.set(indexOne, this.heap.get(indexTwo));
        this.heap.set(indexTwo, temp);
    }

    public void insert(int value) {
        if (size() >= Integer.MAX_VALUE - 1) {
            throw new IllegalStateException("Heap is full");
        }
        this.heap.add(value);
        int index = this.heap.size() - 1;
        while (index > 0 && this.heap.get(this.parentIndex(index)) < this.heap.get(index)) {
            this.swap(this.parentIndex(index), index);
            index = this.parentIndex(index);
        }
    }

    public Integer extractMax() {
        if (isEmpty()) {
            return null;
        }
        int max = peek();
        this.heap.set(0, this.heap.getLast());
        // this.heap.removeLast(); is better for java 21 +
        this.heap.removeLast();
        if (!isEmpty()) {
            sinkDown(0);
        }
        return max;
    }

    private void sinkDown(int index) {
        int maxIndex = index;
        while (true) {
            int leftChildIndex = this.leftChildIndex(index);
            int rightChildIndex = this.rightChildIndex(index);

            if (leftChildIndex < size() && heap.get(leftChildIndex) > heap.get(maxIndex)) {
                maxIndex = leftChildIndex;
            }
            if (rightChildIndex < size() && heap.get(rightChildIndex) > heap.get(maxIndex)) {
                maxIndex = rightChildIndex;
            }

            if (maxIndex != index) {
                swap(index, maxIndex);
                index = maxIndex;
            } else {
                return;
            }
        }
    }


}