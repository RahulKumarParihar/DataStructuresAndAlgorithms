package Stack;

import java.util.ArrayList;
import java.util.List;

public class StackArrayImplementation<T> extends Stack<T>{
    private T[] stack;
    public StackArrayImplementation(int capacity) {
        super(capacity);
        stack = (T[]) new Object[capacity];
    }

    @Override
    public void push(T element) {
        if(isFull()){
            throw new RuntimeException("Stack Overflow!");
        }
        int index = getSize();
        stack[index] = element;
        setSize(index + 1);
    }

    @Override
    public T pop() {
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        int index = getSize() - 1;
        setSize(index);
        return stack[index];
    }

    @Override
    public T seek() {
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        return stack[getSize() - 1];
    }

    @Override
    public List<T> getAllElements(){
        List<T> list = new ArrayList<>();
        for(int i = 0; i < getSize(); i++){
            list.add(stack[i]);
        }
        return list;
    }
}
