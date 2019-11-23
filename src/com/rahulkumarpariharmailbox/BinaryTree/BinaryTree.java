package com.rahulkumarpariharmailbox.BinaryTree;

/**
 * Binary Tree Class
 */
public class BinaryTree {
    /* contains address of the root node */
    Node root;

    /**
     * Nested Node class
     */
    public class Node {
        /**
         * Contains address of the left child
         */
        public Node leftChild;
        /**
         * Contains address of the right child
         */
        public Node rightChild;
        /**
         * Contains data of the current node
         */
        public int data;

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
