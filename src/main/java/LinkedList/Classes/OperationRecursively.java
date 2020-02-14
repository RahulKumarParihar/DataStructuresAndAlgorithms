package LinkedList.Classes;

import LinkedList.Interfaces.Operation;

import java.util.LinkedList;
import java.util.List;

import static LinkedList.LinkedLists.Node;

public class OperationRecursively implements Operation {
    /**
     * Traverse the linked list
     *
     * @param head head of the linked list
     */
    @Override
    public List<Integer> traverse(Node head) {
        List<Integer> nodeDate = new LinkedList<>();
        traverHelper(head, nodeDate);
        return nodeDate;
    }

    private void traverHelper(Node head, List<Integer> nodeData) {
        if (head == null)
            return;

        nodeData.add(head.data);
        traverHelper(head.next, nodeData);
    }

    /**
     * Reverse the linked list
     *
     * @param head head of the linked list
     */
    @Override
    public Node reverse(Node head) {
        if (head == null || head.next == null)
            return head;

        Node swap = head.next;
        head.next = null;
        Node reverse = reverse(swap);
        swap.next = head;

        return reverse;
    }
}
