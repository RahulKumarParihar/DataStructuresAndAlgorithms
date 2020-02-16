package BinaryTree;

import Abstract.BinaryTree.Max;

public class MaxRecursive implements Max {
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
}
