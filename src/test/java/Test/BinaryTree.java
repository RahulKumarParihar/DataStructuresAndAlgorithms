package Test;

import Abstract.BinaryTree.DepthFirstTraversal;
import Abstract.BinaryTree.Operation;
import BinaryTree.OperationIterative;
import BinaryTree.DepthFirstTraversalIterative;
import Structure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BinaryTree {
    private final Operation<Integer> operation = new OperationIterative<>();
    private final DepthFirstTraversal<Integer> traversal = new DepthFirstTraversalIterative<>();

    @Test
    public void CreateTreeIterative() {
        TreeNode<Integer> root = null;
        int[] nodeData = {1,2,3};
        boolean leftChild = false;
        for(int node: nodeData){
            root = operation.insert(root, node, leftChild);
            leftChild = !leftChild;
        }
        List<Integer> result = traversal.InOrderTraversal(root);
        List<Integer> requiredResult = new ArrayList<>(Arrays.asList(2,1,3));
        assertThat(result,is(requiredResult));
    }
}
