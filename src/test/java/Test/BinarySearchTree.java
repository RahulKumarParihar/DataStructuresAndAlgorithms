package Test;

import Abstract.BinarySearchTree.Operation;
import Abstract.BinarySearchTree.Travesal;
import BinarySearchTree.BasicOperation;
import BinarySearchTree.BinarySearchTreeNode;
import BinarySearchTree.Traversal;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BinarySearchTree {
    private final Operation operation = new BasicOperation();
    private final Travesal traversal = new Traversal();

    //<editor-fold desc="Create Test Cases">
    @Test
    public void InsertionTest() {
        int[] nodeValues = {10, 6, 13, 14, 18, 3, 7};
        BinarySearchTreeNode root = CreateBinarySearchTree(nodeValues);
        List<Integer> result = traversal.InOrderTraversal(root);
        List<Integer> requiredResult = new ArrayList<>(Arrays.asList(3, 6, 7, 10, 13, 14, 18));
        assertThat(requiredResult, is(result));
    }
    //</editor-fold>

    //<editor-fold desc="Successor Test Cases">
    @Test
    public void SuccessorIsLastLeftChild() {
        int[] nodeValues = {20, 22, 8, 12, 14, 4};
        BinarySearchTreeNode root = CreateBinarySearchTree(nodeValues);
        BinarySearchTreeNode successor = operation.inOrderSuccessor(root, 4);
        assertThat(successor.data, is(8));
    }

    @Test
    public void SuccessorNodeDoesNotExist() {
        int[] nodeValues = {20};
        BinarySearchTreeNode root = CreateBinarySearchTree(nodeValues);
        BinarySearchTreeNode successor = operation.inOrderSuccessor(root, 20);
        assertThat(successor, is((BinarySearchTreeNode) null));
    }

    @Test
    public void SuccessorIsRightChild() {
        int[] nodeValues = {20, 22, 8, 12, 4, 14, 6};
        BinarySearchTreeNode root = CreateBinarySearchTree(nodeValues);
        BinarySearchTreeNode successor = operation.inOrderSuccessor(root, 8);
        assertThat(successor.data, is(12));
    }

    @Test
    public void SuccessorIsLeftChild() {
        int[] nodeValues = {20, 22, 8, 12, 4, 14, 10, 6};
        BinarySearchTreeNode root = CreateBinarySearchTree(nodeValues);
        BinarySearchTreeNode successor = operation.inOrderSuccessor(root, 8);
        assertThat(successor.data, is(10));
    }
    //</editor-fold>

    //<editor-fold desc="Delete Test Cases">
    @Test
    public void DeleteWithNoChild() {
        int[] nodeValues = {13, 10, 19, 11, 7, 8, 9, 3, 14, 21, 23};
        BinarySearchTreeNode root = CreateBinarySearchTree(nodeValues);
        root = operation.delete(root, 9);
        List<Integer> result = traversal.InOrderTraversal(root);
        List<Integer> requiredResult = new ArrayList<>(Arrays.asList(3, 7, 8, 10, 11, 13, 14, 19, 21, 23));
        assertThat(requiredResult, is(result));
    }

    @Test
    public void DeleteWithOneChild() {
        int[] nodeValues = {13, 10, 19, 11, 7, 8, 9, 3, 14, 21, 23};
        BinarySearchTreeNode root = CreateBinarySearchTree(nodeValues);
        root = operation.delete(root, 8);
        List<Integer> result = traversal.InOrderTraversal(root);
        List<Integer> requiredResult = new ArrayList<>(Arrays.asList(3, 7, 9, 10, 11, 13, 14, 19, 21, 23));
        assertThat(requiredResult, is(result));
    }

    @Test
    public void DeleteWithTwoChildSuccessorNotLeafNode() {
        int[] nodeValues = {20, 8, 22, 4, 12, 21, 24, 6, 14};
        BinarySearchTreeNode root = CreateBinarySearchTree(nodeValues);
        root = operation.delete(root, 22);
        List<Integer> result = traversal.InOrderTraversal(root);
        List<Integer> requiredResult = new ArrayList<>(Arrays.asList(4, 6, 8, 12, 14, 20, 21, 24));
        assertThat(result, is(requiredResult));
    }

    @Test
    public void DeleteWithTwoChildSuccessorNotLeafNodeHasRightChild() {
        int[] nodeValues = {13, 10, 19, 7, 11, 14, 21, 3, 8, 23, 9};
        BinarySearchTreeNode root = CreateBinarySearchTree(nodeValues);
        root = operation.delete(root, 7);
        List<Integer> result = traversal.InOrderTraversal(root);
        List<Integer> requiredResult = new ArrayList<>(Arrays.asList(3, 8, 9, 10, 11, 13, 14, 19, 21, 23));
        assertThat(result, is(requiredResult));
    }

    @Test
    public void DeleteWithTwoChildSuccessorNotLeafNodeHasRightChildIsRightChild() {
        int[] nodeValues = {20, 10, 25, 5, 15, 12, 17, 18, 19};
        BinarySearchTreeNode root = CreateBinarySearchTree(nodeValues);
        root = operation.delete(root, 15);
        List<Integer> result = traversal.InOrderTraversal(root);
        List<Integer> requiredResult = new ArrayList<>(Arrays.asList(5, 10, 17, 18, 19, 20, 25));
        assertThat(result, is(requiredResult));
    }

    @Test
    public void DeleteWithTwoChildSuccessorLeftNode() {
        int[] nodeValues = {20, 8, 22, 4, 12, 21, 24, 6, 14, 23};
        BinarySearchTreeNode root = CreateBinarySearchTree(nodeValues);
        root = operation.delete(root, 22);
        List<Integer> result = traversal.InOrderTraversal(root);
        List<Integer> requiredResult = new ArrayList<>(Arrays.asList(4, 6, 8, 12, 14, 20, 21, 23, 24));
        assertThat(result, is(requiredResult));
    }
    //</editor-fold>

    //<editor-fold desc="Predecessor test cases">
    @Test
    public void PredecessorLeafNode() {
        int[] nodeValues = {8, 3, 10, 1, 6, 4, 7};
        BinarySearchTreeNode root = CreateBinarySearchTree(nodeValues);
        BinarySearchTreeNode predecessor = operation.inOrderPredecessor(root, 7);
        assertThat(predecessor.data, is(6));
    }

    @Test
    public void PredecessorLeftChild() {
        int[] nodeValues = {8, 3, 10, 1, 6, 4, 7};
        BinarySearchTreeNode root = CreateBinarySearchTree(nodeValues);
        BinarySearchTreeNode predecessor = operation.inOrderPredecessor(root, 6);
        assertThat(predecessor.data, is(4));
    }

    @Test
    public void PredecessorLeftChildRightChild() {
        int[] nodeValues = {8, 3, 10, 1, 6, 4, 7, 5};
        BinarySearchTreeNode root = CreateBinarySearchTree(nodeValues);
        BinarySearchTreeNode predecessor = operation.inOrderPredecessor(root, 6);
        assertThat(predecessor.data, is(5));
    }

    @Test
    public void PredecessorNull() {
        int[] nodeValues = {8, 3, 10, 1, 6, 4, 7, 5};
        BinarySearchTreeNode root = CreateBinarySearchTree(nodeValues);
        BinarySearchTreeNode predecessor = operation.inOrderPredecessor(root, 15);
        assertThat(predecessor, is((BinarySearchTreeNode) null));
    }
    //</editor-fold>

    //<editor-fold desc="ValidBST test cases">
    @Test
    public void ValidBSTSingleNode() {
        int[] nodeValues = {8};
        BinarySearchTreeNode root = CreateBinarySearchTree(nodeValues);
        boolean isValid = operation.validBST(root);
        assertThat(isValid, is(true));
    }

    @Test
    public void ValidBSTCreate() {
        int[] nodeValues = {8, 9, 4, 5, 6, 7};
        BinarySearchTreeNode root = CreateBinarySearchTree(nodeValues);
        boolean isValid = operation.validBST(root);
        assertThat(isValid, is(true));
    }

    @Test
    public void ValidBSTSingleRepeatingNode() {
        int[] nodeValues = {8, 8, 6};
        BinarySearchTreeNode root = CreateBinarySearchTree(nodeValues);
        boolean isValid = operation.validBST(root);
        assertThat(isValid, is(false));
    }

    @Test
    public void ValidBSTRepeatingNode() {
        int[] nodeValues = {8, 8, 8};
        BinarySearchTreeNode root = CreateBinarySearchTree(nodeValues);
        boolean isValid = operation.validBST(root);
        assertThat(isValid, is(false));
    }

    @Test
    public void ValidBSTEmpty() {
        BinarySearchTreeNode root = null;
        boolean isValid = operation.validBST(root);
        assertThat(isValid, is(true));
    }
    //</editor-fold>

    //<editor-fold desc="Private method">
    private BinarySearchTreeNode CreateBinarySearchTree(int[] nodes) {
        BinarySearchTreeNode root = null;
        for (int node : nodes) {
            root = operation.insert(root, node);
        }
        return root;
    }
    //</editor-fold>
}
