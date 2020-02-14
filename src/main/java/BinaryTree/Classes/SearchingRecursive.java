package BinaryTree.Classes;

import BinaryTree.BinaryTree;
import BinaryTree.Interfaces.Searching;

public class SearchingRecursive implements Searching {
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
