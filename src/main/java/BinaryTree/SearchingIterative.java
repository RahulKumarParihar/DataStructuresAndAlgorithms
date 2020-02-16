package BinaryTree;

import Abstract.BinaryTree.Searching;

import java.util.Stack;

public class SearchingIterative implements Searching {
    /**
     * Search for an element in a tree using Iterative approach
     *
     * @param root root element of the tree
     * @param data element to search
     * @return true if element is found
     */
    @Override
    public boolean Search(BinaryTree.Node root, int data) {
        Stack<BinaryTree.Node> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);

                root = root.leftChild;
            }
            if (stack.empty())
                break;

            root = stack.pop();

            if (root.data == data)
                return true;

            root = root.rightChild;
        }
        return false;
    }
}
