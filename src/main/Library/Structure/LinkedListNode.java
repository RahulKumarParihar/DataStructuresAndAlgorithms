package Structure;

public class LinkedListNode<T> {
    private T data;
    private LinkedListNode<T> next;

    public T getData() {
        return data;
    }

    public LinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }

    public LinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }
}
