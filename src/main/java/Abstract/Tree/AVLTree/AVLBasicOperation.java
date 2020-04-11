package Abstract.Tree.AVLTree;

import Structure.TreeNode;

public interface AVLBasicOperation<T> {
    /**
     * Checks that rotation is required in the avl tree
     *
     * @param node
     * @return
     */
    boolean IsRotationRequired(TreeNode<T> node);
}
