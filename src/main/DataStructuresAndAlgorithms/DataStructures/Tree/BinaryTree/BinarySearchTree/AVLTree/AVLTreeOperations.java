package DataStructures.Tree.BinaryTree.BinarySearchTree.AVLTree;

import DataStructures.Abstract.Tree.BinaryTree.BinarySearchTree.AVLTree.AVLTreeSpecificOperations;
import DataStructures.Abstract.Tree.BinaryTree.BinarySearchTree.AbstractOperations;
import DataStructures.Abstract.Tree.BinaryTree.BinarySearchTree.SearchTreeSpecificOperations;
import DataStructures.Structure.TreeNode;
import DataStructures.Tree.BinaryTree.BinarySearchTree.Balanced;
import DataStructures.Tree.BinaryTree.BinarySearchTree.BinarySearchTreeOperations;

public class AVLTreeOperations<T extends Comparable<T>> implements AbstractOperations<T>, AVLTreeSpecificOperations<T> {
    private final AbstractOperations<T> abstractOperations = new BinarySearchTreeOperations<>();
    private final SearchTreeSpecificOperations<T> searchTreeSpecificOperations = new BinarySearchTreeOperations<>();

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
        root = rotationWrapper(root, nodeData, Operation.Add);
        return root;
    }
    //<editor-fold desc="Override methods">

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
        root = rotationWrapper(root, nodeDateToDelete, Operation.Delete);
        return root;
    }

    private TreeNode<T> insertRotationHelper(TreeNode<T> node, T data, Balanced balanced) {
        if (balanced.isLeftHeavy()) {
            node = data.compareTo(node.leftChild.data) < 0
                    // case I
                    ? rightRotation(node)
                    // case III
                    : doubleLeftRotation(node);
        } else {
            node = data.compareTo(node.rightChild.data) > 0
                    // Case II
                    ? leftRotation(node)
                    // Case IV
                    : doubleRightRotation(node);
        }
        return node;
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
        node.rightChild = tempNode.leftChild;//tempNode.leftChild != null ? tempNode.leftChild : null;
        tempNode.leftChild = node;

        return tempNode;
    }

    private TreeNode<T> doubleLeftRotation(TreeNode<T> node) {
        node.leftChild = leftRotation(node.leftChild);
        return rightRotation(node);
    }

    private TreeNode<T> doubleRightRotation(TreeNode<T> node) {
        node.rightChild = rightRotation(node.rightChild);
        return leftRotation(node);
    }

    private TreeNode<T> deleteRotationHelper(TreeNode<T> node, T data, Balanced balanced) {
        if (balanced.isLeftHeavy()) {
            node = !IsBalanced(node.leftChild).isLeftHeavy() ? doubleLeftRotation(node) : rightRotation(node);
        } else {
            node = IsBalanced(node.rightChild).isLeftHeavy() ? doubleRightRotation(node) : leftRotation(node);
        }
        return node;
    }

    private TreeNode<T> rotationWrapper(TreeNode<T> node, T data, Operation operation) {
        Balanced balanced = IsBalanced(node);
        if (balanced.isBalance()) {
            switch (operation) {
                case Add:
                    node = insertRotationHelper(node, data, balanced);
                    break;
                case Delete:
                    node = deleteRotationHelper(node, data, balanced);
                    break;
            }

        }
        return node;
    }

    enum Operation {
        Add,
        Delete
    }
    //</editor-fold>

}
