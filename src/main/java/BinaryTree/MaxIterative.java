package BinaryTree;

import Abstract.BinaryTree.Max;

import java.util.Stack;

public class MaxIterative implements Max {
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
}
