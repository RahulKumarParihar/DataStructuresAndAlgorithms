package LinkedList.Classes;

import LinkedList.Interfaces.Operation;

import java.util.LinkedList;
import java.util.List;

import static LinkedList.LinkedLists.Node;

public class OperationIteration implements Operation {
    /**
     * Traverse the linked list using iterative method
     *
     * @param head head of the linked list
     * @return List containing linked list data
     */
    @Override
    public List<Integer> traverse(Node head) {
        List<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.data);
            head = head.next;
        }
        return list;
    }

    /**
     * Reverse the linked list using iterative method
     *
     * @param head head of the linked list
     * @return head node of the reverse linked list
     */
    @Override
    public Node reverse(Node head) {
        if (head == null)
            return null;

        Node newHead = null;
        while (head != null) {
            Node swap = head.next;
            head.next = newHead;
            newHead = head;
            head = swap;
        }
        return newHead;
    }
}
