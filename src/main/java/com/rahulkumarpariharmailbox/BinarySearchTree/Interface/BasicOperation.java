package com.rahulkumarpariharmailbox.BinarySearchTree.Interface;

import com.rahulkumarpariharmailbox.BinarySearchTree.BinarySearchTreeNode;

public interface BasicOperation {
    /**
     * Add a node to binary search tree
     *
     * @param root     root of the binary search tree
     * @param nodeData data of the node to insert
     * @return root of the binary search tree
     */
    BinarySearchTreeNode insert(BinarySearchTreeNode root, int nodeData);

    /**
     * Removes a node from binary search tree
     *
     * @param root             root of the binary search tree
     * @param nodeDateToDelete data of the node to delete
     * @return root of the binary search tree
     */
    BinarySearchTreeNode delete(BinarySearchTreeNode root, int nodeDateToDelete);
}
