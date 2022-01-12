package DataStructures.LinkedList;

import DataStructures.Abstract.LinkedList.Operation;
import DataStructures.Structure.LinkedLists.Node;

import java.util.List;

public class Execute {
    private Insert insert = new Insert();
    private Operation operationIteration = new OperationIteration();

    public void Run() {
        Node head = CreateLinkedList();
        head = operationIteration.reverse(head);
        List<Integer> result = operationIteration.traverse(head);
        for (int r : result) {
            System.out.println(r);
        }
    }

    private Node CreateLinkedList() {
        Node head = null;
        head = insert.AddNodeAtEnd(1, head);
        head = insert.AddNodeAtEnd(2, head);
        head = insert.AddNodeAtEnd(3, head);
        head = insert.AddNodeAtEnd(4, head);
        head = insert.AddNodeAtEnd(5, head);
        return head;
    }
}

