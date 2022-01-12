package DataStructures.Abstract.Tree.BinaryTree.BinarySearchTree.AVLTree;

import DataStructures.Structure.TreeNode;
import DataStructures.Tree.BinaryTree.BinarySearchTree.Balanced;

public interface AVLTreeSpecificOperations<T> {
    /**
     * Checks that rotation is required in the avl tree
     *
     * @param node
     * @return Balanced class object
     */
    Balanced IsBalanced(TreeNode<T> node);
}
