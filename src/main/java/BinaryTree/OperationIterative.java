package BinaryTree;

import Abstract.BinaryTree.Operation;
import Structure.TreeNode;

import java.util.Stack;

public class OperationIterative implements Operation {

    /**
     * Adding node to the tree
     *
     * @param root      root of the tree
     * @param data      data to insert
     * @param leftChild true to add left child, false to add right child
     * @return root element of the tree
     */
    @Override
    public TreeNode<Integer> insert(TreeNode<Integer> root, int data, boolean leftChild) {
        if (root == null) {
            root = new TreeNode<>(data);
        }

        TreeNode<Integer> previousNode = null;
        TreeNode<Integer> iterateRoot = root;

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
    public int FindMax(TreeNode<Integer> root) {
        int max = -1;
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> previous = null;
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
    public boolean Search(TreeNode<Integer> root, int data) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
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
