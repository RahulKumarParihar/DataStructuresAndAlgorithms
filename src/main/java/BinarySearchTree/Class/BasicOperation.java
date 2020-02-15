package BinarySearchTree.Class;

import Abstract.BinarySearchTree.Operation;
import BinarySearchTree.BinarySearchTreeNode;

public class BasicOperation implements Operation {
    /**
     * Insert a node to binary search tree
     *
     * @param root     root of the binary search tree
     * @param nodeData data of the node to insert
     * @return root of the binary search tree
     */
    @Override
    public BinarySearchTreeNode insert(BinarySearchTreeNode root, int nodeData) {
        if (root == null) {
            root = new BinarySearchTreeNode(nodeData);
        } else {
            BinarySearchTreeNode position = root;
            position = findInsertPosition(position, nodeData);
            if (position.data > nodeData) {
                position.leftChild = new BinarySearchTreeNode(nodeData);
            } else {
                position.rightChild = new BinarySearchTreeNode(nodeData);
            }
        }
        return root;
    }

    /**
     * delete a node from binary search tree
     *
     * @param root             root of the binary search tree
     * @param nodeDateToDelete data of the node to delete
     * @return root of the binary search tree
     */
    @Override
    public BinarySearchTreeNode delete(BinarySearchTreeNode root, int nodeDateToDelete) {
        if (root != null) {
            BinarySearchTreeNode previousNode = findDeletePrevious(root, nodeDateToDelete);
            BinarySearchTreeNode deleteNode;
            boolean isLeftChildPreviousNode = false;

            if (previousNode.leftChild != null && previousNode.leftChild.data == nodeDateToDelete) {
                deleteNode = previousNode.leftChild;
                isLeftChildPreviousNode = true;
            } else {
                deleteNode = previousNode.rightChild;
            }

            //If delete node has two childes
            if (deleteNode.leftChild != null && deleteNode.rightChild != null) {
                //TODO if delete has two childes

                //If delete node has one child
            } else if (deleteNode.leftChild != null || deleteNode.rightChild != null) {
                if (isLeftChildPreviousNode) {
                    previousNode.leftChild = deleteNode.leftChild != null ? deleteNode.leftChild : deleteNode.rightChild;
                } else {
                    previousNode.rightChild = deleteNode.leftChild != null ? deleteNode.leftChild : deleteNode.rightChild;
                }

                // if delete node has no child
            } else {
                if (isLeftChildPreviousNode) {
                    previousNode.leftChild = null;
                } else {
                    previousNode.rightChild = null;
                }
            }
        }
        return root;
    }

    private BinarySearchTreeNode findInsertPosition(BinarySearchTreeNode root, int nodeData) {
        BinarySearchTreeNode previousNode = root;
        while (root != null) {
            if (root.data > nodeData) {
                previousNode = root;
                root = root.leftChild;

            } else {
                previousNode = root;
                root = root.rightChild;
            }
        }
        return previousNode;
    }

    private BinarySearchTreeNode findDeletePrevious(BinarySearchTreeNode root, int nodeDataToDelete) {
        BinarySearchTreeNode previousNode = null;
        while (root != null) {
            if (root.data == nodeDataToDelete) {
                return previousNode;
            } else if (root.data > nodeDataToDelete) {
                previousNode = root;
                root = root.leftChild;
            } else {
                previousNode = root;
                root = root.rightChild;
            }
        }
        return null;
    }
}
