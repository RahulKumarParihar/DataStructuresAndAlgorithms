package DataStructures.Abstract.Tree.BinaryTree.BinarySearchTree;

import DataStructures.Structure.TreeNode;

public interface AbstractOperations<T> {
    /**
     * Add a node to binary search tree
     *
     * @param root     root of the binary search tree
     * @param nodeData data of the node to insert
     * @return root of the binary search tree
     */
    TreeNode<T> insert(TreeNode<T> root, T nodeData);

    /**
     * Removes a node from binary search tree
     *
     * @param root             root of the binary search tree
     * @param nodeDateToDelete data of the node to delete
     * @return root of the binary search tree
     */
    TreeNode<T> delete(TreeNode<T> root, T nodeDateToDelete);
}
