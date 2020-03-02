package BinaryTree;

import Abstract.BinaryTree.DepthFirstTraversal;
import Structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstTraversalRecusive implements DepthFirstTraversal {
    /**
     * PreOrder Traversal of tree using Recursive method
     *
     * @param root contains information of root node of the tree
     * @return List contains node data
     */
    @Override
    public List<Integer> PreOrderTraversal(TreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        PreOrderHelper(root, result);
        return result;
    }

    /**
     * InOrder Traversal of tree using Recursive method
     *
     * @param root contains information of root node of the tree
     * @return List contains node data
     */
    @Override
    public List<Integer> InOrderTraversal(TreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        InOrderHelper(root, result);
        return result;
    }

    /**
     * PostOrder Traversal of tree using Recursive method
     *
     * @param root contains information of root node of the tree
     * @return List contains node data
     */
    @Override
    public List<Integer> PostOrderTraversal(TreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        PostOrderHelper(root, result);
        return result;
    }

    private void PreOrderHelper(TreeNode<Integer> root, List<Integer> result) {
        if (root == null)
            return;

        result.add(root.data);

        PreOrderHelper(root.leftChild, result);

        PreOrderHelper(root.rightChild, result);
    }

    private void InOrderHelper(TreeNode<Integer> root, List<Integer> result) {
        if (root == null)
            return;

        InOrderHelper(root.leftChild, result);

        result.add(root.data);

        InOrderHelper(root.rightChild, result);
    }

    private void PostOrderHelper(TreeNode<Integer> root, List<Integer> result) {
        if (root == null)
            return;

        PostOrderHelper(root.leftChild, result);

        PostOrderHelper(root.rightChild, result);

        result.add(root.data);
    }
}
