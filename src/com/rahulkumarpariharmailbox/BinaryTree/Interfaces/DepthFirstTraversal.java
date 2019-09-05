package com.rahulkumarpariharmailbox.BinaryTree.Interfaces;

import com.rahulkumarpariharmailbox.BinaryTree.BinaryTree;

import java.util.List;

public interface DepthFirstTraversal {
    /**
     * PreOrder Traversal of tree
     *
     * @param root contains information of root node of the tree
     * @return List contains node data
     */
    List<Integer> PreOrderTraversal(BinaryTree.Node root);

    /**
     * InOrder Traversal of tree
     *
     * @param root contains information of root node of the tree
     * @return List contains node data
     */
    List<Integer> InOrderTraversal(BinaryTree.Node root);

    /**
     * PostOrder Traversal of tree
     *
     * @param root contains information of root node of the tree
     * @return List contains node data
     */
    List<Integer> PostOrderTraversal(BinaryTree.Node root);
}
