package Tree.BinaryTree.BinarySearchTree.AVLTree;

import Abstract.Tree.BinaryTree.BinarySearchTree.AVLTree.AVLTreeSpecificOperations;
import Abstract.Tree.BinaryTree.BinarySearchTree.SearchTreeSpecificOperations;
import Structure.TreeNode;
import Tree.BinaryTree.BinarySearchTree.BinarySearchTreeOperations;

public class AVLTreeOperations<T extends Comparable<T>> implements AVLTreeSpecificOperations<T> {
    private final SearchTreeSpecificOperations<T> searchTreeSpecificOperations = new BinarySearchTreeOperations<>();


    public boolean IsBalanced(TreeNode<T> node) {
        int difference = Math.abs(searchTreeSpecificOperations.height(node.leftChild) - searchTreeSpecificOperations.height(node.rightChild));
        return difference > 1 ? true : false;
    }


}
