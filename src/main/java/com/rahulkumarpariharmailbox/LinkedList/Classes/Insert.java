package com.rahulkumarpariharmailbox.LinkedList.Classes;

import static com.rahulkumarpariharmailbox.LinkedList.LinkedLists.Node;

public class Insert {
    /**
     * Add node to the end of the linked list
     *
     * @param data data of the node
     * @param head head of the node
     */
    public Node AddNodeAtEnd(int data, Node head) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node iterator = head;
            while (iterator.next != null) {
                iterator = iterator.next;
            }

            iterator.next = new Node(data);
        }

        return head;
    }

    /**
     * Add new node to the head of the linked list
     *
     * @param data data of the new head
     * @param head old head of the linked list
     */
    public Node AddNodeAtHead(int data, Node head) {
        Node newHead = new Node(data);
        if (head == null)
            head = newHead;
        else {
            Node swap = head;
            head = newHead;
            newHead.next = swap;
        }
        return head;
    }
}
