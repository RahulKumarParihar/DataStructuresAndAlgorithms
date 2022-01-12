package NonLinearDataStructure;

import DataStructures.Abstract.Tree.BinaryTree.BinarySearchTree.AbstractOperations;
import DataStructures.Structure.TreeNode;
import DataStructures.Tree.BinaryTree.BinarySearchTree.AVLTree.AVLTreeOperations;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AVLTreeTest {
    AbstractOperations<Integer> avlTreeOperations = new AVLTreeOperations<>();


    @Test
    public void TestRotationCaseI() {
        int[] nodes = {20, 10, 5};
        TreeNode<Integer> root = CreateAVLTree(nodes);
        assertThat(root.rightChild.data, is(20));
    }

    @Test
    public void TestRotationCaseII() {
        int[] nodes = {5, 10, 20};
        TreeNode<Integer> root = CreateAVLTree(nodes);
        assertThat(root.leftChild.data, is(5));
    }

    @Test
    public void TestRotationCaseIII() {
        int[] nodes = {20, 10, 15};
        TreeNode<Integer> root = CreateAVLTree(nodes);
        assertThat(root.leftChild.data, is(10));
    }

    @Test
    public void TestRotationCaseIV() {
        int[] nodes = {10, 20, 15};
        TreeNode<Integer> root = CreateAVLTree(nodes);
        assertThat(root.rightChild.data, is(20));
    }

    //<editor-fold desc="Private method">
    private TreeNode<Integer> CreateAVLTree(int[] nodes) {
        TreeNode<Integer> root = null;
        for (int node : nodes) {
            root = avlTreeOperations.insert(root, node);
        }
        return root;
    }
    //</editor-fold>
}
