package Abstract.Tree.TraversalManager;

import Structure.TreeNode;

import java.util.List;

public interface DepthFirstTraversal<T> {
    /**
     * PreOrder Traversal of tree
     *
     * @param root contains information of root node of the tree
     * @return List contains node data
     */
    List<T> PreOrderTraversal(TreeNode<T> root);

    /**
     * InOrder Traversal of tree
     *
     * @param root contains information of root node of the tree
     * @return List contains node data
     */
    List<T> InOrderTraversal(TreeNode<T> root);

    /**
     * PostOrder Traversal of tree
     *
     * @param root contains information of root node of the tree
     * @return List contains node data
     */
    List<T> PostOrderTraversal(TreeNode<T> root);
}
