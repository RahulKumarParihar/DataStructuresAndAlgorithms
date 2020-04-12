package Abstract.Tree.BinaryTree.BinarySearchTree.AVLTree;

import Structure.TreeNode;

public interface AVLTreeSpecificOperations<T> {
    /**
     * Checks that rotation is required in the avl tree
     *
     * @param node
     * @return
     */
    boolean IsBalanced(TreeNode<T> node);
}
