package com.rahulkumarpariharmailbox.BinaryTree;

/**
 * Binary Tree Class
 */
public class BinaryTree {
    /* contains address of the root node */
    public Node root;

    /**
     * Nested Node class
     */
    public class Node {
        /**
         * Contains address of the left child
         */
        Node leftChild;
        /**
         * Contains address of the right child
         */
        Node rightChild;
        /**
         * Contains data of the current node
         */
        int data;

        /**
         * public constructor to initialize value of data
         *
         * @param data contains value of the node
         */
        public Node(int data) {
            this.data = data;
            leftChild = rightChild = null;
        }
    }
}
