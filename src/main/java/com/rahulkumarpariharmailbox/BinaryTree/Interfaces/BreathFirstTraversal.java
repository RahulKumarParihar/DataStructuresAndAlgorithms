package com.rahulkumarpariharmailbox.BinaryTree.Interfaces;

import com.rahulkumarpariharmailbox.BinaryTree.BinaryTree;

import java.util.List;

public interface BreathFirstTraversal {
    /**
     * Traversal
     *
     * @param root root node of the tree
     * @return List of list
     */
    List<List<Integer>> traversal(BinaryTree.Node root);
}
