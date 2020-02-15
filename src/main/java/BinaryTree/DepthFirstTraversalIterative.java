package BinaryTree;

import Abstract.BinaryTree.DepthFirstTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstTraversalIterative implements DepthFirstTraversal {
    /**
     * PreOrder Traversal of tree using iterative method
     *
     * @param root contains information of root node of the tree
     * @return List contains node data
     */
    @Override
    public List<Integer> PreOrderTraversal(BinaryTree.Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<BinaryTree.Node> stack = new Stack<>();
        while (true) {
            while (root != null) {
                result.add(root.data);

                stack.push(root);

                root = root.leftChild;
            }

            if (stack.empty())
                break;

            root = stack.pop();

            root = root.rightChild;
        }
        return result;
    }

    /**
     * InOrder Traversal of tree using iterative method
     *
     * @param root contains information of root node of the tree
     * @return List contains node data
     */
    @Override
    public List<Integer> InOrderTraversal(BinaryTree.Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<BinaryTree.Node> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);

                root = root.leftChild;
            }

            if (stack.empty())
                break;

            root = stack.pop();

            result.add(root.data);

            root = root.rightChild;
        }

        return result;
    }

    /**
     * PostOrder Traversal of tree using iterative method
     *
     * @param root contains information of root node of the tree
     * @return List contains node data
     */
    @Override
    public List<Integer> PostOrderTraversal(BinaryTree.Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<BinaryTree.Node> stack = new Stack<>();
        BinaryTree.Node previous = null;

        do {
            while (root != null) {
                stack.push(root);

                root = root.leftChild;
            }
            while (root == null && !stack.empty()) {
                root = stack.peek();

                if (root.rightChild == null || root.rightChild == previous) {
                    result.add(root.data);
                    stack.pop();
                    previous = root;
                    root = null;
                } else {
                    root = root.rightChild;
                }
            }
        } while (!stack.empty());

        return result;
    }
}
