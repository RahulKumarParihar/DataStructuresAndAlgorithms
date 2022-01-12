package DataStructures.LinkedList;

import DataStructures.Abstract.LinkedList.Operation;
import DataStructures.Structure.LinkedLists;

import java.util.LinkedList;
import java.util.List;

public class OperationRecursively implements Operation {
    /**
     * Traverse the linked list
     *
     * @param head head of the linked list
     */
    @Override
    public List<Integer> traverse(LinkedLists.Node head) {
        List<Integer> nodeDate = new LinkedList<>();
        traverHelper(head, nodeDate);
        return nodeDate;
    }

    private void traverHelper(LinkedLists.Node head, List<Integer> nodeData) {
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
    public LinkedLists.Node reverse(LinkedLists.Node head) {
        if (head == null || head.next == null)
            return head;

        LinkedLists.Node swap = head.next;
        head.next = null;
        LinkedLists.Node reverse = reverse(swap);
        swap.next = head;

        return reverse;
    }
}
