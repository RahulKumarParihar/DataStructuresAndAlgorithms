package NonLinearDataStructure;

import Abstract.Tree.BinaryTree.BinarySearchTree.AbstractOperations;
import Abstract.Tree.BinaryTree.BinarySearchTree.SearchTreeSpecificOperations;
import Abstract.Tree.TraversalManager.DepthFirstTraversal;
import Structure.TreeNode;
import Tree.BinaryTree.BinarySearchTree.BinarySearchTreeOperations;
import Tree.TraversalManager.DepthFirstTraversalIterative;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BinarySearchTreeTest {
    private final AbstractOperations<Integer> binarySearchTreeOperation = new BinarySearchTreeOperations<>();
    private final DepthFirstTraversal<Integer> traversal = new DepthFirstTraversalIterative<>();
    private final SearchTreeSpecificOperations<Integer> searchTreeSpecificOperations = new BinarySearchTreeOperations<>();

    //<editor-fold desc="Create Test Cases">
    @Test
    public void InsertionTest() {
        int[] nodeValues = {10, 6, 13, 14, 18, 3, 7};
        TreeNode<Integer> root = CreateBinarySearchTree(nodeValues);
        List<Integer> result = traversal.InOrderTraversal(root);
        List<Integer> requiredResult = new ArrayList<>(Arrays.asList(3, 6, 7, 10, 13, 14, 18));
        assertThat(requiredResult, is(result));
    }
    //</editor-fold>

    //<editor-fold desc="Successor Test Cases">
    @Test
    public void SuccessorIsLastLeftChild() {
        int[] nodeValues = {20, 22, 8, 12, 14, 4};
        TreeNode<Integer> root = CreateBinarySearchTree(nodeValues);
        TreeNode<Integer> successor = searchTreeSpecificOperations.inOrderSuccessor(root, 4);
        assertThat(successor.data, is(8));
    }

    @Test
    public void SuccessorNodeDoesNotExist() {
        int[] nodeValues = {20};
        TreeNode<Integer> root = CreateBinarySearchTree(nodeValues);
        TreeNode<Integer> successor = searchTreeSpecificOperations.inOrderSuccessor(root, 20);
        assertThat(successor, is((TreeNode<Integer>) null));
    }

    @Test
    public void SuccessorIsRightChild() {
        int[] nodeValues = {20, 22, 8, 12, 4, 14, 6};
        TreeNode<Integer> root = CreateBinarySearchTree(nodeValues);
        TreeNode<Integer> successor = searchTreeSpecificOperations.inOrderSuccessor(root, 8);
        assertThat(successor.data, is(12));
    }

    @Test
    public void SuccessorIsLeftChild() {
        int[] nodeValues = {20, 22, 8, 12, 4, 14, 10, 6};
        TreeNode<Integer> root = CreateBinarySearchTree(nodeValues);
        TreeNode<Integer> successor = searchTreeSpecificOperations.inOrderSuccessor(root, 8);
        assertThat(successor.data, is(10));
    }
    //</editor-fold>

    //<editor-fold desc="Delete Test Cases">
    @Test
    public void DeleteWithNoChild() {
        int[] nodeValues = {13, 10, 19, 11, 7, 8, 9, 3, 14, 21, 23};
        TreeNode<Integer> root = CreateBinarySearchTree(nodeValues);
        root = binarySearchTreeOperation.delete(root, 9);
        List<Integer> result = traversal.InOrderTraversal(root);
        List<Integer> requiredResult = new ArrayList<>(Arrays.asList(3, 7, 8, 10, 11, 13, 14, 19, 21, 23));
        assertThat(requiredResult, is(result));
    }

    @Test
    public void DeleteWithOneChild() {
        int[] nodeValues = {13, 10, 19, 11, 7, 8, 9, 3, 14, 21, 23};
        TreeNode<Integer> root = CreateBinarySearchTree(nodeValues);
        root = binarySearchTreeOperation.delete(root, 8);
        List<Integer> result = traversal.InOrderTraversal(root);
        List<Integer> requiredResult = new ArrayList<>(Arrays.asList(3, 7, 9, 10, 11, 13, 14, 19, 21, 23));
        assertThat(requiredResult, is(result));
    }

    @Test
    public void DeleteWithTwoChildSuccessorNotLeafNode() {
        int[] nodeValues = {20, 8, 22, 4, 12, 21, 24, 6, 14};
        TreeNode<Integer> root = CreateBinarySearchTree(nodeValues);
        root = binarySearchTreeOperation.delete(root, 22);
        List<Integer> result = traversal.InOrderTraversal(root);
        List<Integer> requiredResult = new ArrayList<>(Arrays.asList(4, 6, 8, 12, 14, 20, 21, 24));
        assertThat(result, is(requiredResult));
    }

    @Test
    public void DeleteWithTwoChildSuccessorNotLeafNodeHasRightChild() {
        int[] nodeValues = {13, 10, 19, 7, 11, 14, 21, 3, 8, 23, 9};
        TreeNode<Integer> root = CreateBinarySearchTree(nodeValues);
        root = binarySearchTreeOperation.delete(root, 7);
        List<Integer> result = traversal.InOrderTraversal(root);
        List<Integer> requiredResult = new ArrayList<>(Arrays.asList(3, 8, 9, 10, 11, 13, 14, 19, 21, 23));
        assertThat(result, is(requiredResult));
    }

    @Test
    public void DeleteWithTwoChildSuccessorNotLeafNodeHasRightChildIsRightChild() {
        int[] nodeValues = {20, 10, 25, 5, 15, 12, 17, 18, 19};
        TreeNode<Integer> root = CreateBinarySearchTree(nodeValues);
        root = binarySearchTreeOperation.delete(root, 15);
        List<Integer> result = traversal.InOrderTraversal(root);
        List<Integer> requiredResult = new ArrayList<>(Arrays.asList(5, 10, 17, 18, 19, 20, 25));
        assertThat(result, is(requiredResult));
    }

    @Test
    public void DeleteWithTwoChildSuccessorLeftNode() {
        int[] nodeValues = {20, 8, 22, 4, 12, 21, 24, 6, 14, 23};
        TreeNode<Integer> root = CreateBinarySearchTree(nodeValues);
        root = binarySearchTreeOperation.delete(root, 22);
        List<Integer> result = traversal.InOrderTraversal(root);
        List<Integer> requiredResult = new ArrayList<>(Arrays.asList(4, 6, 8, 12, 14, 20, 21, 23, 24));
        assertThat(result, is(requiredResult));
    }
    //</editor-fold>

    //<editor-fold desc="Predecessor test cases">
    @Test
    public void PredecessorLeafNode() {
        int[] nodeValues = {8, 3, 10, 1, 6, 4, 7};
        TreeNode<Integer> root = CreateBinarySearchTree(nodeValues);
        TreeNode<Integer> predecessor = searchTreeSpecificOperations.inOrderPredecessor(root, 7);
        assertThat(predecessor.data, is(6));
    }

    @Test
    public void PredecessorLeftChild() {
        int[] nodeValues = {8, 3, 10, 1, 6, 4, 7};
        TreeNode<Integer> root = CreateBinarySearchTree(nodeValues);
        TreeNode<Integer> predecessor = searchTreeSpecificOperations.inOrderPredecessor(root, 6);
        assertThat(predecessor.data, is(4));
    }

    @Test
    public void PredecessorLeftChildRightChild() {
        int[] nodeValues = {8, 3, 10, 1, 6, 4, 7, 5};
        TreeNode<Integer> root = CreateBinarySearchTree(nodeValues);
        TreeNode<Integer> predecessor = searchTreeSpecificOperations.inOrderPredecessor(root, 6);
        assertThat(predecessor.data, is(5));
    }

    @Test
    public void PredecessorNull() {
        int[] nodeValues = {8, 3, 10, 1, 6, 4, 7, 5};
        TreeNode<Integer> root = CreateBinarySearchTree(nodeValues);
        TreeNode<Integer> predecessor = searchTreeSpecificOperations.inOrderPredecessor(root, 15);
        assertThat(predecessor, is((TreeNode<Integer>) null));
    }
    //</editor-fold>

    //<editor-fold desc="ValidBST test cases">
    @Test
    public void ValidBSTSingleNode() {
        int[] nodeValues = {8};
        TreeNode<Integer> root = CreateBinarySearchTree(nodeValues);
        boolean isValid = searchTreeSpecificOperations.validBST(root);
        assertThat(isValid, is(true));
    }

    @Test
    public void ValidBSTCreate() {
        int[] nodeValues = {8, 9, 4, 5, 6, 7};
        TreeNode<Integer> root = CreateBinarySearchTree(nodeValues);
        boolean isValid = searchTreeSpecificOperations.validBST(root);
        assertThat(isValid, is(true));
    }

    @Test
    public void ValidBSTSingleRepeatingNode() {
        int[] nodeValues = {8, 8, 6};
        TreeNode<Integer> root = CreateBinarySearchTree(nodeValues);
        boolean isValid = searchTreeSpecificOperations.validBST(root);
        assertThat(isValid, is(false));
    }

    @Test
    public void ValidBSTRepeatingNode() {
        int[] nodeValues = {8, 8, 8};
        TreeNode<Integer> root = CreateBinarySearchTree(nodeValues);
        boolean isValid = searchTreeSpecificOperations.validBST(root);
        assertThat(isValid, is(false));
    }

    @Test
    public void ValidBSTEmpty() {
        TreeNode<Integer> root = null;
        boolean isValid = searchTreeSpecificOperations.validBST(root);
        assertThat(isValid, is(true));
    }

    @Test
    public void Height() {
        int[] nodeValues = {8, 6, 5};
        TreeNode<Integer> root = CreateBinarySearchTree(nodeValues);
        int height = searchTreeSpecificOperations.height(root);
        assertThat(height, is(3));
    }
    //</editor-fold>

    //<editor-fold desc="Private method">
    private TreeNode<Integer> CreateBinarySearchTree(int[] nodes) {
        TreeNode<Integer> root = null;
        for (int node : nodes) {
            root = binarySearchTreeOperation.insert(root, node);
        }
        return root;
    }
    //</editor-fold>
}
