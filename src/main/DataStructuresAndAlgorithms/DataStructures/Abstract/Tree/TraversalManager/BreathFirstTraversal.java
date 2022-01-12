package DataStructures.Abstract.Tree.TraversalManager;

import DataStructures.Structure.TreeNode;

import java.util.List;

public interface BreathFirstTraversal<T> {
    /**
     * Traversal
     *
     * @param root root node of the tree
     * @return List of list
     */
    List<List<T>> traversal(TreeNode<T> root);
}
