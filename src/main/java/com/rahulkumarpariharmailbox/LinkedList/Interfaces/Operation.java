package com.rahulkumarpariharmailbox.LinkedList.Interfaces;

import java.util.List;

import static com.rahulkumarpariharmailbox.LinkedList.LinkedLists.Node;

public interface Operation {

    /**
     * Traverse the linked list
     *
     * @param head head of the linked list
     * @return List containing the data of linked list
     */
    List<Integer> traverse(Node head);

    /**
     * Reverse the linked list
     *
     * @param head head of the linked list
     * @return the head node of the reverse linked list
     */
    Node reverse(Node head);
}
