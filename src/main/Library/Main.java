import Heap.Heap;
import Heap.MaxHeap;
import Heap.MinHeap;

public class Main {

    public static void main(String[] args) {
        Heap heap = new MaxHeap();
        heap.push(8);
        heap.push(3);
        heap.push(88);
        heap.push(-9);
        heap.push(-1);

        System.out.println(heap.getFirstElement());

        int length = heap.sort();
        for(int i = 0; i < length; i++){
            System.out.print(heap.getHeap()[i] + " ");
        }
        System.out.println();

        Heap minHeap = new MinHeap();
        minHeap.push(8);
        minHeap.push(3);
        minHeap.push(88);
        minHeap.push(-9);
        minHeap.push(-1);
        length = minHeap.sort();
        System.out.println(minHeap.getFirstElement());
        for(int i = 0; i < length; i++){
            System.out.print(minHeap.getHeap()[i] + " ");
        }
        System.out.println();
    }
}
