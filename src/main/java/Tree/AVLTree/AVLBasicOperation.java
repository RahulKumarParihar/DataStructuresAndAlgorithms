package Tree.AVLTree;

import Abstract.Tree.BinarySearchTree.GeneralTreeOperation;
import Structure.TreeNode;
import Tree.BinarySearchTree.GeneralTreeOperationRecursive;

public class AVLBasicOperation<T> implements Abstract.Tree.AVLTree.AVLBasicOperation<T> {
    private final GeneralTreeOperation<T> generalTreeOperation = new GeneralTreeOperationRecursive<>();

    public boolean IsBalanced(TreeNode<T> node) {
        int difference = Math.abs(generalTreeOperation.height(node.leftChild) - generalTreeOperation.height(node.rightChild));
        return difference > 1 ? true : false;
    }
}
