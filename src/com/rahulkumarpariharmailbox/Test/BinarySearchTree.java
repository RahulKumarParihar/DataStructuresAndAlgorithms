package com.rahulkumarpariharmailbox.Test;

import com.rahulkumarpariharmailbox.BinarySearchTree.BinarySearchTreeNode;
import com.rahulkumarpariharmailbox.BinarySearchTree.Interface.Insertion;
import com.rahulkumarpariharmailbox.BinarySearchTree.Interface.Travesal;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BinarySearchTree {
    private Insertion insertion = new com.rahulkumarpariharmailbox.BinarySearchTree.Class.Insertion();
    private Travesal traversal = new com.rahulkumarpariharmailbox.BinarySearchTree.Class.Travesal();

    @Test
    public void InsertionTest() {
        BinarySearchTreeNode root = null;
        int[] nodeValues = {10, 6, 13, 14, 18, 3, 7};
        for (int i : nodeValues) {
            root = insertion.insert(root, i);
        }
        List<Integer> result = traversal.InOrderTraversal(root);
        List<Integer> requiredResult = new ArrayList<>(Arrays.asList(3, 6, 7, 10, 13, 14, 18));
        assertThat(requiredResult, is(result));
    }
}
