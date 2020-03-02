package BinaryTree;

import Abstract.BinaryTree.Operation;
import Structure.BinaryTree;

public class OperationRecursive implements Operation {
    /**
     * Will return the max element in the tree
     *
     * @param root root node of the tree
     * @return max element in the tree
     */
    @Override
    public int FindMax(BinaryTree.Node root) {
        int max = -1;
        if (root != null) {
            int dataValue = root.data;
            int left = FindMax(root.leftChild);
            int right = FindMax(root.rightChild);
            max = Math.max(left, right);
            max = Math.max(dataValue, max);
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
    public boolean Search(BinaryTree.Node root, int data) {
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
