package Queue;

import java.util.ArrayList;
import java.util.List;

public class QueueArrayImplementation<T> extends Queue<T> {
    private int startIndex = 0;
    private int lastIndex = 0;
    private T[] queue;

    public QueueArrayImplementation(int capacity) {
        super(capacity);
        queue = (T[]) new Object[capacity];
    }

    @Override
    public void offer(T element) {
        if(isFull()){
            throw new RuntimeException("Queue Overflow!");
        }
        lastIndex = lastIndex % getCapacity();
        queue[lastIndex] = element;
        lastIndex++;
        setSize(getSize() + 1);
    }

    @Override
    public T poll() {
        if(isEmpty()){
            throw new RuntimeException("Queue Underflow!");
        }
        startIndex = startIndex % getCapacity();
        T data = queue[startIndex];
        startIndex++;
        setSize(getSize() - 1);
        return data;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            throw new RuntimeException("Queue Underflow!");
        }
        return queue[startIndex % getCapacity()];
    }

    @Override
    public List<T> getAllElements() {
        List<T> list = new ArrayList<>();
        for(int i = 0; i < getSize(); i++){
            list.add(queue[(startIndex + i) % getCapacity()]);
        }
        return list;
    }
}
