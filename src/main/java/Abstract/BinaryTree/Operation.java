package Abstract.BinaryTree;

import Structure.TreeNode;

public interface Operation {
    /**
     * Will return the max element in the tree
     *
     * @param root root node of the tree
     * @return max element in the tree
     */
    int FindMax(TreeNode<Integer> root);

    /**
     * Search for an element in a tree
     *
     * @param root root element of the tree
     * @param data element to search
     * @return true if element is found
     */
    boolean Search(TreeNode<Integer> root, int data);
}
