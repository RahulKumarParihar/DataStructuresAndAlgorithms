package DataStructures.Stack;

import java.util.List;

public abstract class Stack<T> {
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

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public boolean isFull(){
        return this.size == this.capacity;
    }

    public abstract void push(T element);
    public abstract T pop();
    public abstract T seek();
    public abstract List<T> getAllElements();
}
