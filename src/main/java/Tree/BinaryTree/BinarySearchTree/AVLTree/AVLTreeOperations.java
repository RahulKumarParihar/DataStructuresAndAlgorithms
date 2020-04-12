package Tree.BinaryTree.BinarySearchTree.AVLTree;

import Abstract.Tree.BinaryTree.BinarySearchTree.AVLTree.AVLTreeSpecificOperations;
import Abstract.Tree.BinaryTree.BinarySearchTree.AbstractOperations;
import Abstract.Tree.BinaryTree.BinarySearchTree.SearchTreeSpecificOperations;
import Structure.TreeNode;
import Tree.BinaryTree.BinarySearchTree.Balanced;
import Tree.BinaryTree.BinarySearchTree.BinarySearchTreeOperations;

public class AVLTreeOperations<T extends Comparable<T>> implements AbstractOperations<T>, AVLTreeSpecificOperations<T> {
    private final AbstractOperations<T> abstractOperations = new BinarySearchTreeOperations<>();
    private final SearchTreeSpecificOperations<T> searchTreeSpecificOperations = new BinarySearchTreeOperations<>();

    //<editor-fold desc="Override methods">

    /**
     * Add a node to binary search tree
     *
     * @param root     root of the binary search tree
     * @param nodeData data of the node to insert
     * @return root of the binary search tree
     */
    @Override
    public TreeNode<T> insert(TreeNode<T> root, T nodeData) {
        root = abstractOperations.insert(root, nodeData);
        root = rotationWrapper(root);
        return root;
    }

    /**
     * Removes a node from binary search tree
     *
     * @param root             root of the binary search tree
     * @param nodeDateToDelete data of the node to delete
     * @return root of the binary search tree
     */
    @Override
    public TreeNode<T> delete(TreeNode<T> root, T nodeDateToDelete) {
        root = abstractOperations.delete(root, nodeDateToDelete);
        root = rotationWrapper(root);
        return root;
    }

    /**
     * Checks that rotation is required in the avl tree
     *
     * @param node
     * @return
     */
    @Override
    public Balanced IsBalanced(TreeNode<T> node) {
        Balanced balanced = new Balanced();
        int difference = searchTreeSpecificOperations.height(node.leftChild) - searchTreeSpecificOperations.height(node.rightChild);
        balanced.setBalance(Math.abs(difference) > 1 ? true : false);
        if (balanced.isBalance()) {
            balanced.setLeftHeavy(difference > 0 ? true : false);
        }
        return balanced;
    }
    //</editor-fold>

    //<editor-fold desc="Private methods">
    private TreeNode<T> rightRotation(TreeNode<T> node) {
        TreeNode<T> tempNode = node.leftChild;
        node.leftChild = tempNode.rightChild != null ? tempNode.rightChild : null;
        tempNode.rightChild = node;

        return tempNode;
    }

    private TreeNode<T> leftRotation(TreeNode<T> node) {
        TreeNode<T> tempNode = node.rightChild;
        node.rightChild = tempNode.leftChild != null ? tempNode.leftChild : null;
        tempNode.leftChild = node;

        return tempNode;
    }

    private TreeNode<T> rotationHelper(TreeNode<T> node, Balanced balanced) {
        do {
            node = balanced.isLeftHeavy() ? rightRotation(node) : leftRotation(node);
            balanced = IsBalanced(node);
        } while (balanced.isBalance());
        return node;
    }

    private TreeNode<T> rotationWrapper(TreeNode<T> node) {
        Balanced balanced = IsBalanced(node);
        if (balanced.isBalance()) {
            node = rotationHelper(node, balanced);
        }
        return node;
    }
    //</editor-fold>

}
