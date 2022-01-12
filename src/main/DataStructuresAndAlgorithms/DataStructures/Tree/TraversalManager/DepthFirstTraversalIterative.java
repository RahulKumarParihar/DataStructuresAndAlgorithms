package DataStructures.Tree.TraversalManager;

import DataStructures.Abstract.Tree.TraversalManager.DepthFirstTraversal;
import DataStructures.Structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstTraversalIterative<T> implements DepthFirstTraversal<T> {
    /**
     * PreOrder Traversal of tree using iterative method
     *
     * @param root contains information of root node of the tree
     * @return List contains node data
     */
    @Override
    public List<T> PreOrderTraversal(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        Stack<TreeNode<T>> stack = new Stack<>();
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
    public List<T> InOrderTraversal(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        Stack<TreeNode<T>> stack = new Stack<>();
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
    public List<T> PostOrderTraversal(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> previous = null;

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
