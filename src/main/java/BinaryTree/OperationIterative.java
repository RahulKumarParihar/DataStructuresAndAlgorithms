package BinaryTree;

import Abstract.BinaryTree.Operation;
import Structure.TreeNode;

import java.util.Stack;

public class OperationIterative<T extends Comparable<T>> implements Operation<T> {

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
        if (root == null) {
            root = new TreeNode<>(data);
        }

        TreeNode<T> previousNode = null;
        TreeNode<T> iterateRoot = root;

        while (iterateRoot != null) {
            previousNode = root;
            iterateRoot = leftChild ? iterateRoot.leftChild : iterateRoot.rightChild;
        }

        if (leftChild) {
            previousNode.leftChild = new TreeNode<>(data);
        } else {
            previousNode.rightChild = new TreeNode<>(data);
        }

        return root;
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
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> previous = null;
        do {
            while (root != null) {
                if (max == null) {
                    max = root.data;
                }
                stack.add(root);

                root = root.leftChild;
            }

            while (root == null && !stack.empty()) {
                root = stack.peek();

                if (root.rightChild == null || root.rightChild == previous) {
                    if (root.data.compareTo(max) > 0)
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
    public boolean Search(TreeNode<T> root, T data) {
        Stack<TreeNode<T>> stack = new Stack<>();
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
