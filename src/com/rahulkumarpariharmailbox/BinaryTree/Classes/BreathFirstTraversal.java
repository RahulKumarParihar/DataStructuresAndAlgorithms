package com.rahulkumarpariharmailbox.BinaryTree.Classes;

import com.rahulkumarpariharmailbox.BinaryTree.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BreathFirstTraversal {
    /**
     * Level order traversal
     *
     * @param root root node of the tree
     * @return List of list of integers
     */
    public List<List<Integer>> levelOrderTraversal(BinaryTree.Node root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row;
        Queue<BinaryTree.Node> queue = new ArrayDeque<>();

        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {
            row = new ArrayList<>();
            root = queue.poll();
            row.add(root.data);

            if (root.leftChild != null)
                queue.offer(root.leftChild);

            if (root.rightChild != null)
                queue.offer(root.rightChild);

            result.add(row);
        }

        return result;
    }
}
