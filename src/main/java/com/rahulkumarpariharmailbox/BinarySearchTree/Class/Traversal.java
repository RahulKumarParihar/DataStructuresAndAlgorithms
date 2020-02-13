package com.rahulkumarpariharmailbox.BinarySearchTree.Class;

import com.rahulkumarpariharmailbox.BinarySearchTree.BinarySearchTreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class Traversal implements com.rahulkumarpariharmailbox.BinarySearchTree.Interface.Travesal {
    @Override
    public List<Integer> InOrderTraversal(BinarySearchTreeNode root) {
        List<Integer> result = new LinkedList<>();
        ArrayDeque<BinarySearchTreeNode> stack = new ArrayDeque<>();

        while (true) {
            while (root != null) {
                stack.push(root);

                root = root.leftChild;
            }

            if (stack.isEmpty())
                break;

            root = stack.pop();

            result.add(root.data);

            root = root.rightChild;
        }
        return result;
    }
}
