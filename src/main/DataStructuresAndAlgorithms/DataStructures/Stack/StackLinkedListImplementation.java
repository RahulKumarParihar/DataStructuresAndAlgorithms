package DataStructures.Stack;

import DataStructures.Structure.LinkedListNode;

import java.util.ArrayList;
import java.util.List;

public class StackLinkedListImplementation<T> extends Stack<T> {
    LinkedListNode<T> head;

    public StackLinkedListImplementation(int capacity) {
        super(capacity);
        head = null;
    }

    @Override
    public void push(T element) {
        if(isFull()){
            throw new RuntimeException("Stack Overflow!");
        }

        var node = GetLastNode(this.head);
        if(node == null){
            var headNode = new LinkedListNode<>(element);
            this.head = headNode;
        } else {
            node.setNext(new LinkedListNode<>(element));
        }
        setSize(getSize() + 1);
    }

    @Override
    public T pop() {
        if(isEmpty()){
            throw new RuntimeException("Stack Underflow!");
        }
        var node = GetSecondLastNode(this.head);
        T data;
        if(node.getNext() == null) {
            data = node.getData();
            this.head = null;
        } else {
            data = node.getNext().getData();
            node.setNext(null);
        }
        setSize(getSize() - 1);

        return data;
    }

    @Override
    public T seek() {
        if(isEmpty()){
            throw new RuntimeException("Stack Underflow!");
        }
        var node = GetLastNode(this.head);
        return node.getData();
    }

    @Override
    public List<T> getAllElements(){
        List<T> list = new ArrayList<>();
        LinkedListNode<T> iterate = this.head;
        while (iterate != null){
            list.add(iterate.getData());
            iterate = iterate.getNext();
        }
        return list;
    }

    private LinkedListNode<T> GetLastNode(LinkedListNode<T> head){
        if(head == null)
            return null;

        LinkedListNode<T> iterate = head;
        while (iterate.getNext() != null){
            iterate = iterate.getNext();
        }
        return iterate;
    }

    private LinkedListNode<T> GetSecondLastNode(LinkedListNode<T> head){
        if(head == null)
            return null;

        LinkedListNode<T> iterate = head;
        while (iterate.getNext() != null && iterate.getNext().getNext() != null){
            iterate = iterate.getNext();
        }
        return iterate;
    }
}
