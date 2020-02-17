package Abstract.BinaryTree;

import Structure.BinaryTree;

public interface Searching {

    /**
     * Search for an element in a tree
     *
     * @param root root element of the tree
     * @param data element to search
     * @return true if element is found
     */
    boolean Search(BinaryTree.Node root, int data);
}
