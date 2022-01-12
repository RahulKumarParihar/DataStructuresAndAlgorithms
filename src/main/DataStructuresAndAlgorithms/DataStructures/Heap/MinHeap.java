package DataStructures.Heap;

public class MinHeap extends Heap{
    @Override
    protected boolean HeapCondition(int index, int parentIndex) {
        return this.heap[index] < this.heap[parentIndex];
    }
}
