package Abstract.BinarySearchTree;

import Structure.TreeNode;

public interface Operation {
    /**
     * Add a node to binary search tree
     *
     * @param root     root of the binary search tree
     * @param nodeData data of the node to insert
     * @return root of the binary search tree
     */
    TreeNode insert(TreeNode root, int nodeData);

    /**
     * Removes a node from binary search tree
     *
     * @param root             root of the binary search tree
     * @param nodeDateToDelete data of the node to delete
     * @return root of the binary search tree
     */
    TreeNode delete(TreeNode root, int nodeDateToDelete);

    /**
     * Find in-order successor of the node
     *
     * @param root     root of the binary search tree
     * @param nodeData data of the node to find in order successor
     * @return in order successor of the node
     */
    TreeNode inOrderSuccessor(TreeNode root, int nodeData);

    /**
     * Find in-order predecessor of the node
     *
     * @param root     root of the binary search tree
     * @param nodeData data of the node to find in order predecessor
     * @return in order predecessor of the node
     */
    TreeNode inOrderPredecessor(TreeNode root, int nodeData);

    /**
     * Check if Binary Search tree is valid or not
     *
     * @param root root of the binary search tree
     * @return True if is valid binary search tree else false
     */
    boolean validBST(TreeNode root);
}
