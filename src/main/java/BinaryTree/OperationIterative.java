package BinaryTree;

import Abstract.BinaryTree.Operation;
import Structure.BinaryTree;

import java.util.Stack;

public class OperationIterative implements Operation {
    /**
     * Will return the max element in the tree
     *
     * @param root root node of the tree
     * @return max element in the tree
     */
    @Override
    public int FindMax(BinaryTree.Node root) {
        int max = -1;
        Stack<BinaryTree.Node> stack = new Stack<>();
        BinaryTree.Node previous = null;
        do {
            while (root != null) {
                stack.add(root);

                root = root.leftChild;
            }

            while (root == null && !stack.empty()) {
                root = stack.peek();

                if (root.rightChild == null || root.rightChild == previous) {
                    if (max < root.data)
                        max = root.data;
                    stack.pop();
                    previous = root;
                    root = null;
                } else {
                    root = root.rightChild;
                }
            }
        } while (!stack.empty());
        return max;
    }

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
