package Abstract.BinaryTree;

import Structure.TreeNode;

import java.util.List;

public interface DepthFirstTraversal {
    /**
     * PreOrder Traversal of tree
     *
     * @param root contains information of root node of the tree
     * @return List contains node data
     */
    List<Integer> PreOrderTraversal(TreeNode<Integer> root);

    /**
     * InOrder Traversal of tree
     *
     * @param root contains information of root node of the tree
     * @return List contains node data
     */
    List<Integer> InOrderTraversal(TreeNode<Integer> root);

    /**
     * PostOrder Traversal of tree
     *
     * @param root contains information of root node of the tree
     * @return List contains node data
     */
    List<Integer> PostOrderTraversal(TreeNode<Integer> root);
}
