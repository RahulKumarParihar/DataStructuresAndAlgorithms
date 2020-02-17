package Abstract.BinaryTree;

import Structure.BinaryTree;

import java.util.List;

public interface BreathFirstTraversal {
    /**
     * Traversal
     *
     * @param root root node of the tree
     * @return List of list
     */
    List<List<Integer>> traversal(BinaryTree.Node root);
}
