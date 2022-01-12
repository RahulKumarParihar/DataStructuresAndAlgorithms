package Queue;

import Structure.LinkedListNode;

import java.util.ArrayList;
import java.util.List;

public class QueueLinkedListImplementation<T> extends Queue<T> {
    LinkedListNode<T> head;

    public QueueLinkedListImplementation(int capacity) {
        super(capacity);
        head = null;
    }

    @Override
    public void offer(T element) {
        if(isFull()){
            throw new RuntimeException("Queue Overflow!");
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
    public T poll() {
        if(isEmpty()){
            throw new RuntimeException("Queue Underflow!");
        }

        T data = head.getData();

        if(this.head.getNext() != null){
            this.head = this.head.getNext();
        } else {
            this.head = null;
        }

        setSize(getSize() - 1);

        return data;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            throw new RuntimeException("Queue Underflow!");
        }

        return this.head.getData();
    }

    @Override
    public List<T> getAllElements() {
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
}
