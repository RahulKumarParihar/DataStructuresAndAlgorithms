package Test;

import LinkedList.Classes.Insert;
import LinkedList.Classes.OperationIteration;
import LinkedList.Classes.OperationRecursively;
import LinkedList.Interfaces.Operation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static LinkedList.LinkedLists.Node;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LinkedList {
    private Insert insert = new Insert();
    private Operation operationIteration = new OperationIteration();
    private Operation operationRecursively = new OperationRecursively();

    private Node CreateLinkedList() {
        Node head = null;
        for (int i = 1; i <= 5; i++) {
            head = insert.AddNodeAtEnd(i, head);
        }
        return head;
    }

    private List<Integer> reverseResult() {
        return new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));
    }

    private List<Integer> traverseResult() {
        return new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    public void traverseIteratively() {
        List<Integer> actual = traverseResult();
        Node head = CreateLinkedList();
        List<Integer> result = operationIteration.traverse(head);
        assertThat(actual, is(result));
    }

    @Test
    public void traverseRecursively() {
        List<Integer> actual = traverseResult();
        Node head = CreateLinkedList();
        List<Integer> result = operationRecursively.traverse(head);
        assertThat(actual, is(result));
    }

    @Test
    public void addNewNodeAtEndOnEmptyLinkedList() {
        List<Integer> actual = Arrays.asList(1, 2);
        Node head = null;
        head = insert.AddNodeAtEnd(1, head);
        head = insert.AddNodeAtEnd(2, head);
        List<Integer> result = operationIteration.traverse(head);
        assertThat(actual, is(result));
    }

    @Test
    public void addNewNodeAtEndOfLinkedList() {
        List<Integer> actual = traverseResult();
        actual.add(6);
        Node head = CreateLinkedList();
        head = insert.AddNodeAtEnd(6, head);
        List<Integer> result = operationIteration.traverse(head);
        assertThat(actual, is(result));
    }

    @Test
    public void addNewNodeAtStartOnEmptyLinkedList() {
        List<Integer> actual = Collections.singletonList(1);
        Node head = null;
        head = insert.AddNodeAtHead(1, head);
        List<Integer> result = operationIteration.traverse(head);
        assertThat(actual, is(result));
    }

    @Test
    public void addNewNodeAtStartOfLinkedList() {
        List<Integer> actual = traverseResult();
        actual.add(0, 6);
        Node head = CreateLinkedList();
        head = insert.AddNodeAtHead(6, head);
        List<Integer> result = operationIteration.traverse(head);
        assertThat(actual, is(result));
    }

    @Test
    public void reverseLinkedListIteratively() {
        List<Integer> actual = reverseResult();
        Node head = CreateLinkedList();
        head = operationIteration.reverse(head);
        List<Integer> result = operationIteration.traverse(head);
        assertThat(actual, is(result));
    }

    @Test
    public void reverseLinkedListRecursively() {
        List<Integer> reverse = reverseResult();
        Node head = CreateLinkedList();
        head = operationRecursively.reverse(head);
        List<Integer> result = operationRecursively.traverse(head);
        assertThat(reverse, is(result));
    }
}
