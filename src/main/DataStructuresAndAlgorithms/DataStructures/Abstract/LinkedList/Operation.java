package DataStructures.Abstract.LinkedList;

import DataStructures.Structure.LinkedLists;

import java.util.List;

public interface Operation {

    /**
     * Traverse the linked list
     *
     * @param head head of the linked list
     * @return List containing the data of linked list
     */
    List<Integer> traverse(LinkedLists.Node head);

    /**
     * Reverse the linked list
     *
     * @param head head of the linked list
     * @return the head node of the reverse linked list
     */
    LinkedLists.Node reverse(LinkedLists.Node head);
}
