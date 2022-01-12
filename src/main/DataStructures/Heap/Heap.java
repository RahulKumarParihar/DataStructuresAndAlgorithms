package Heap;

public abstract class Heap {
    protected final int CAPACITY = 100;
    protected int size;
    protected int[] heap;

    public int[] getHeap() {
        return heap;
    }

    public Heap() {
        this.heap = new int[CAPACITY];
        this.size = 0;
    }

    protected abstract boolean HeapCondition(int index, int parentIndex);

    public void push(int element) {
        if(this.isFull()){
            throw new RuntimeException("Heap Capacity Full");
        }

        this.heap[this.size] = element;
        this.size++;

        this.percolationUp(this.size -1);
    }

    public int pop(){
        var firstElement = this.getFirstElement();

        swap(0, size - 1);
        size--;

        this.percolationDown(0);

        return firstElement;
    }



    public boolean isFull() {
        return this.size == this.CAPACITY;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getFirstElement(){
        return this.heap[0];
    }

    public int sort(){
        int length = this.size;

        for(int i = length - 1; i > 0; i--){
            int temp = this.pop();
            this.heap[i] = temp;
        }

        return length;
    }

    protected int getParentIndex(int i) {
        return (i -1) / 2;
    }

    protected int getLeftChildIndex(int i){
        return 2*i + 1;
    }

    protected int getRightChildIndex(int i){
        return 2*i + 2;
    }

    protected void percolationUp(int index){
        var parentIndex = getParentIndex(index);

        if (index > 0 && HeapCondition(index,parentIndex)) {
            this.swap(index, parentIndex);
            this.percolationUp(parentIndex);
        }
    }

    protected void percolationDown(int index){
        int leftChild = getLeftChildIndex(index);
        int rightChild = getRightChildIndex(index);

        int maxIndex = index;
        if(leftChild < size && HeapCondition(leftChild, maxIndex)) {
            maxIndex = leftChild;
        }

        if(rightChild < size && HeapCondition(rightChild, maxIndex)) {
            maxIndex = rightChild;
        }

        if(index != maxIndex){
            this.swap(maxIndex, index);
            percolationDown(maxIndex);
        }
    }

    protected void swap(int index1, int index2){
        int temp = this.heap[index1];
        this.heap[index1] = this.heap[index2];
        this.heap[index2] = temp;
    }
}
