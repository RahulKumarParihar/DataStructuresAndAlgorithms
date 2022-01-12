package DataStructures.Tree.BinaryTree;

import DataStructures.Abstract.Tree.BinaryTree.Operation;
import DataStructures.Structure.TreeNode;

public class OperationRecursive<T extends Comparable<T>> implements Operation<T> {
    /**
     * Adding node to the tree
     *
     * @param root      root of the tree
     * @param data      data to insert
     * @param leftChild true to add left child, false to add right child
     * @return root element of the tree
     */
    @Override
    public TreeNode<T> insert(TreeNode<T> root, T data, boolean leftChild) {
        return null;
    }

    /**
     * Will return the max element in the tree
     *
     * @param root root node of the tree
     * @return max element in the tree
     */
    @Override
    public T FindMax(TreeNode<T> root) {
        T max = null;
        if (root != null) {
            max = root.data;
            T dataValue = root.data;
            T left = FindMax(root.leftChild);
            T right = FindMax(root.rightChild);
            max = left.compareTo(right) > 0 ? left : right;
            max = dataValue.compareTo(max) > 0 ? dataValue : max;
        }
        return max;
    }

    /**
     * Search for an element in a tree using Recursive approach
     *
     * @param root root element of the tree
     * @param data element to search
     * @return true if element is found
     */
    @Override
    public boolean Search(TreeNode<T> root, T data) {
        if (root == null)
            return false;
        else {
            if (root.data == data)
                return true;
            else {
                boolean temp = Search(root.leftChild, data);
                if (temp)
                    return true;
                else {
                    return Search(root.rightChild, data);
                }
            }
        }
    }
}
