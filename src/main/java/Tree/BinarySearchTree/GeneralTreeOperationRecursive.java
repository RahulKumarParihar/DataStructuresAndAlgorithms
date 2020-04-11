package Tree.BinarySearchTree;

import Abstract.Tree.BinarySearchTree.GeneralTreeOperation;
import Structure.TreeNode;

public class GeneralTreeOperationRecursive<T> implements GeneralTreeOperation<T> {
    public int height(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }

        return Math.max(height(node.leftChild), height(node.rightChild)) + 1;
    }
}
