package Abstract.BinarySearchTree;

import Structure.TreeNode;

import java.util.List;

public interface Traversal<T> {
    List<T> InOrderTraversal(TreeNode<T> root);
}
