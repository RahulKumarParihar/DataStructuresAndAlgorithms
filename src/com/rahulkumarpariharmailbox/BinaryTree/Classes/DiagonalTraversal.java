package com.rahulkumarpariharmailbox.BinaryTree.Classes;

import com.rahulkumarpariharmailbox.BinaryTree.BinaryTree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DiagonalTraversal {
    public List<List<Integer>> diagonalTraversal(BinaryTree.Node root) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> diagonal = new LinkedList<>();
        Queue<BinaryTree.Node> queue = new ArrayDeque<>();

        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root == null) {
                result.add(diagonal);
                diagonal.clear();
                queue.offer(null);
                root = queue.poll();
                if (root == null)
                    break;
            }

            while (root != null) {
                diagonal.add(root.data);

                if (root.leftChild != null)
                    queue.offer(root.leftChild);

                root = root.rightChild;
            }
        }

        return result;
    }
}
