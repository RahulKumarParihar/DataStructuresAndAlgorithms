package Tree.BinarySearchTree;

import Abstract.Tree.BinarySearchTree.Operation;
import Structure.TreeNode;

public class BasicOperation<T extends Comparable<T>> implements Operation<T> {
    /**
     * Insert a node to binary search tree
     *
     * @param root     root of the binary search tree
     * @param nodeData data of the node to insert
     * @return root of the binary search tree
     */
    @Override
    public TreeNode<T> insert(TreeNode<T> root, T nodeData) {
        if (root == null) {
            root = new TreeNode(nodeData);
        } else {
            TreeNode<T> position = root;
            position = findInsertPosition(position, nodeData);
            if (position.data.compareTo(nodeData) > 0) {
                position.leftChild = new TreeNode(nodeData);
            } else {
                position.rightChild = new TreeNode(nodeData);
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
    public TreeNode<T> delete(TreeNode<T> root, T nodeDateToDelete) {
        if (root != null) {
            TreeNode<T> previousNode = findDeletePrevious(root, nodeDateToDelete);
            TreeNode<T> deleteNode;
            boolean isLeftChild = false;

            if (previousNode.leftChild != null && previousNode.leftChild.data == nodeDateToDelete) {
                deleteNode = previousNode.leftChild;
                isLeftChild = true;
            } else {
                deleteNode = previousNode.rightChild;
            }

            //If delete node has two childes
            if (deleteNode.leftChild != null && deleteNode.rightChild != null) {
                TreeNode<T> inOrderSuccessor = inOrderSuccessor(root, nodeDateToDelete);
                if (inOrderSuccessor != null) {
                    //inOrderSuccessor of the node is not the leaf node
                    if (inOrderSuccessor.rightChild != null) {
                        if (isLeftChild) {
                            if (previousNode.leftChild.leftChild != null) {
                                inOrderSuccessor.leftChild = previousNode.leftChild.leftChild;
                            }
                            previousNode.leftChild = inOrderSuccessor;
                        } else {
                            previousNode.rightChild = inOrderSuccessor;
                        }
                        //inOrderSuccessor of the node is the leaf node
                    } else {
                        deleteNode.data = inOrderSuccessor.data;
                        TreeNode<T> iterate = deleteNode.rightChild;
                        previousNode = iterate;
                        isLeftChild = false;
                        while (iterate.data != inOrderSuccessor.data) {
                            isLeftChild = true;
                            previousNode = iterate;
                            iterate = iterate.leftChild;
                        }
                        if (isLeftChild)
                            previousNode.leftChild = null;
                        else
                            deleteNode.rightChild = null;
                    }
                }

                //If delete node has one child
            } else if (deleteNode.leftChild != null || deleteNode.rightChild != null) {
                if (isLeftChild) {
                    previousNode.leftChild = deleteNode.leftChild != null ? deleteNode.leftChild : deleteNode.rightChild;
                } else {
                    previousNode.rightChild = deleteNode.leftChild != null ? deleteNode.leftChild : deleteNode.rightChild;
                }

                // if delete node has no child
            } else {
                if (isLeftChild) {
                    previousNode.leftChild = null;
                } else {
                    previousNode.rightChild = null;
                }
            }
        }
        return root;
    }

    /**
     * Find in-order successor of the node
     *
     * @param root     root of the binary search tree
     * @param nodeData data of the node to find in order successor
     * @return in order successor of the node
     */
    @Override
    public TreeNode<T> inOrderSuccessor(TreeNode<T> root, T nodeData) {
        TreeNode<T> successorNode = null;

        // successorNode of a left node
        while (root != null && root.data != nodeData) {
            if (root.data.compareTo(nodeData) > 0) {
                successorNode = root;
                root = root.leftChild;
            } else {
                root = root.rightChild;
            }
        }

        // finding successorNode of a element which doesn't exits
        if (root == null)
            return null;

        if (root.rightChild != null) {
            root = root.rightChild;
            while (root.leftChild != null) {
                root = root.leftChild;
            }
            successorNode = root;
        }

        return successorNode;
    }

    /**
     * Find in-order predecessor of the node
     *
     * @param root     root of the binary search tree
     * @param nodeData data of the node to find in order predecessor
     * @return in order predecessor of the node
     */
    @Override
    public TreeNode<T> inOrderPredecessor(TreeNode<T> root, T nodeData) {
        TreeNode<T> predecessor = null;

        // Predecessor of a leaf node
        while (root != null && root.data != nodeData) {
            if (root.data.compareTo(nodeData) > 0) {
                root = root.leftChild;
            } else {
                predecessor = root;
                root = root.rightChild;
            }
        }

        // Find predecessor of a element which doesn't exists
        if (root == null)
            return null;

        if (root.leftChild != null) {
            root = root.leftChild;

            while (root.rightChild != null) {
                root = root.rightChild;
            }
            predecessor = root;
        }

        return predecessor;
    }

    /**
     * Check if Binary Search tree is valid or not
     *
     * @param root root of the binary search tree
     * @return True if is valid binary search tree else false
     */
    @Override
    public boolean validBST(TreeNode<T> root) {
        return isValidHelper(root, null, null);
    }

    //<editor-fold desc="Private methods">
    private TreeNode<T> findInsertPosition(TreeNode<T> root, T nodeData) {
        TreeNode<T> previousNode = root;
        while (root != null) {
            if (root.data.compareTo(nodeData) > 0) {
                previousNode = root;
                root = root.leftChild;

            } else {
                previousNode = root;
                root = root.rightChild;
            }
        }
        return previousNode;
    }

    private TreeNode<T> findDeletePrevious(TreeNode<T> root, T nodeDataToDelete) {
        TreeNode<T> previousNode = null;
        while (root != null) {
            if (root.data == nodeDataToDelete) {
                return previousNode;
            } else if (root.data.compareTo(nodeDataToDelete) > 0) {
                previousNode = root;
                root = root.leftChild;
            } else {
                previousNode = root;
                root = root.rightChild;
            }
        }
        return null;
    }

    private boolean isValidHelper(TreeNode<T> node, T maxRange, T minRange) {
        if (node == null)
            return true;

        if (maxRange != null && node.data.compareTo(maxRange) >= 0) {
            return false;
        }

        if (minRange != null && minRange.compareTo(node.data) >= 0) {
            return false;
        }

        return isValidHelper(node.leftChild, node.data, minRange) && isValidHelper(node.rightChild, maxRange, node.data);
    }
    //</editor-fold>
}
