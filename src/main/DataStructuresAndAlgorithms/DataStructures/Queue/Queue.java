package DataStructures.Queue;

import java.util.List;

public abstract class Queue<T> {
    private int capacity = 0;
    private int size = 0;

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    protected void setSize(int size) {
        this.size = size;
    }

    public Queue(int capacity) {
        this.capacity = capacity;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public boolean isFull(){
        return this.size == this.capacity;
    }

    public void printQueue(){
        var allElements = this.getAllElements();

        for (T element : allElements) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public abstract void offer(T element);
    public abstract T poll();
    public abstract T peek();
    public abstract List<T> getAllElements();
}
