package NonLinearDataStructure;

import DataStructures.Abstract.Tree.BinaryTree.Operation;
import DataStructures.Abstract.Tree.TraversalManager.DepthFirstTraversal;
import DataStructures.Structure.TreeNode;
import DataStructures.Tree.BinaryTree.OperationIterative;
import DataStructures.Tree.TraversalManager.DepthFirstTraversalIterative;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BinaryTreeTest {
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
