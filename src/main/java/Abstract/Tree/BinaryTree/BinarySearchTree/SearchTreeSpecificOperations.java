package Abstract.Tree.BinaryTree.BinarySearchTree;

import Structure.TreeNode;

public interface SearchTreeSpecificOperations<T> {
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

    /**
     * Get the height of the node
     *
     * @param node node
     * @return height of the node
     */
    int height(TreeNode<T> node);
}
