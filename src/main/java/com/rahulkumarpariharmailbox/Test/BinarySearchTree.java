package com.rahulkumarpariharmailbox.Test;

import com.rahulkumarpariharmailbox.BinarySearchTree.BinarySearchTreeNode;
import com.rahulkumarpariharmailbox.BinarySearchTree.Class.Traversal;
import com.rahulkumarpariharmailbox.BinarySearchTree.Interface.BasicOperation;
import com.rahulkumarpariharmailbox.BinarySearchTree.Interface.Travesal;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BinarySearchTree {
    private BasicOperation operation = new com.rahulkumarpariharmailbox.BinarySearchTree.Class.BasicOperation();
    private Travesal traversal = new Traversal();

    @Test
    public void InsertionTest() {
        BinarySearchTreeNode root = null;
        int[] nodeValues = {10, 6, 13, 14, 18, 3, 7};
        for (int i : nodeValues) {
            root = operation.insert(root, i);
        }
        List<Integer> result = traversal.InOrderTraversal(root);
        List<Integer> requiredResult = new ArrayList<>(Arrays.asList(3, 6, 7, 10, 13, 14, 18));
        assertThat(requiredResult, is(result));
    }

    @Test
    public void DeleteWithNoChild() {
        BinarySearchTreeNode root = null;
        int[] nodeValues = {13, 10, 19, 11, 7, 8, 9, 3, 14, 21, 23};
        for (int i : nodeValues) {
            root = operation.insert(root, i);
        }
        root = operation.delete(root, 9);
        List<Integer> result = traversal.InOrderTraversal(root);
        List<Integer> requiredResult = new ArrayList<>(Arrays.asList(3, 7, 8, 10, 11, 13, 14, 19, 21, 23));
        assertThat(requiredResult, is(result));
    }

    @Test
    public void DeleteWithOneChild() {
        BinarySearchTreeNode root = null;
        int[] nodeValues = {13, 10, 19, 11, 7, 8, 9, 3, 14, 21, 23};
        for (int i : nodeValues) {
            root = operation.insert(root, i);
        }
        root = operation.delete(root, 8);
        List<Integer> result = traversal.InOrderTraversal(root);
        List<Integer> requiredResult = new ArrayList<>(Arrays.asList(3, 7, 9, 10, 11, 13, 14, 19, 21, 23));
        assertThat(requiredResult, is(result));
    }
}
