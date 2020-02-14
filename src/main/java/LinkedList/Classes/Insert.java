package LinkedList.Classes;

import LinkedList.LinkedLists;

public class Insert {
    /**
     * Add node to the end of the linked list
     *
     * @param data data of the node
     * @param head head of the node
     */
    public LinkedLists.Node AddNodeAtEnd(int data, LinkedLists.Node head) {
        if (head == null) {
            head = new LinkedLists.Node(data);
        } else {
            LinkedLists.Node iterator = head;
            while (iterator.next != null) {
                iterator = iterator.next;
            }

            iterator.next = new LinkedLists.Node(data);
        }

        return head;
    }

    /**
     * Add new node to the head of the linked list
     *
     * @param data data of the new head
     * @param head old head of the linked list
     */
    public LinkedLists.Node AddNodeAtHead(int data, LinkedLists.Node head) {
        LinkedLists.Node newHead = new LinkedLists.Node(data);
        if (head == null)
            head = newHead;
        else {
            LinkedLists.Node swap = head;
            head = newHead;
            newHead.next = swap;
        }
        return head;
    }
}
