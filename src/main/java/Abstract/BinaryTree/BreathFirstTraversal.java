package Abstract.BinaryTree;

import Structure.TreeNode;

import java.util.List;

public interface BreathFirstTraversal {
    /**
     * Traversal
     *
     * @param root root node of the tree
     * @return List of list
     */
    List<List<Integer>> traversal(TreeNode<Integer> root);
}
