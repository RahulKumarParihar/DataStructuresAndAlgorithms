package DataStructures.Abstract.Tree.BinaryTree;

import DataStructures.Structure.TreeNode;

public interface Operation<T> {

    /**
     * Adding node to the tree
     *
     * @param root      root of the tree
     * @param data      data to insert
     * @param leftChild true to add left child, false to add right child
     * @return root element of the tree
     */
    TreeNode<T> insert(TreeNode<T> root, T data, boolean leftChild);

    /**
     * Will return the max element in the tree
     *
     * @param root root node of the tree
     * @return max element in the tree
     */
    T FindMax(TreeNode<T> root);

    /**
     * Search for an element in a tree
     *
     * @param root root element of the tree
     * @param data element to search
     * @return true if element is found
     */
    boolean Search(TreeNode<T> root, T data);
}
