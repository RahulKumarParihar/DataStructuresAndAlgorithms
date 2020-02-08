package com.rahulkumarpariharmailbox.BinarySearchTree.Class;

import com.rahulkumarpariharmailbox.BinarySearchTree.BinarySearchTreeNode;

public class BasicOperation implements com.rahulkumarpariharmailbox.BinarySearchTree.Interface.BasicOperation {
    @Override
    public BinarySearchTreeNode insert(BinarySearchTreeNode root, int nodeData) {
        if (root == null) {
            root = new BinarySearchTreeNode(nodeData);
        } else {
            BinarySearchTreeNode position = root;
            position = findInsertPosition(position, nodeData);
            if (position.data > nodeData) {
                position.leftChild = new BinarySearchTreeNode(nodeData);
            } else {
                position.rightChild = new BinarySearchTreeNode(nodeData);
            }
        }
        return root;
    }

    private BinarySearchTreeNode findInsertPosition(BinarySearchTreeNode root, int nodeData) {
        BinarySearchTreeNode previousNode = root;
        while (root != null) {
            if (root.data > nodeData) {
                previousNode = root;
                root = root.leftChild;

            } else {
                previousNode = root;
                root = root.rightChild;
            }
        }
        return previousNode;
    }
}
