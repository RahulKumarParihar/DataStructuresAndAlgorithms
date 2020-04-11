package Abstract.Tree.BinarySearchTree;

import Structure.TreeNode;

public interface Operation<T> {
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

    /**
     * Find in-order successor of the node
     *
     * @param root     root of the binary search tree
     * @param nodeData data of the node to find in order successor
     * @return in order successor of the node
     */
    TreeNode<T> inOrderSuccessor(TreeNode<T> root, T nodeData);

    /**
     * Find in-order predecessor of the node
     *
     * @param root     root of the binary search tree
     * @param nodeData data of the node to find in order predecessor
     * @return in order predecessor of the node
     */
    TreeNode<T> inOrderPredecessor(TreeNode<T> root, T nodeData);

    /**
     * Check if Binary Search tree is valid or not
     *
     * @param root root of the binary search tree
     * @return True if is valid binary search tree else false
     */
    boolean validBST(TreeNode<T> root);
}
