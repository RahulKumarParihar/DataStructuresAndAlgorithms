package DataStructures.Tree.TraversalManager;

import DataStructures.Abstract.Tree.TraversalManager.BreathFirstTraversal;
import DataStructures.Structure.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DiagonalTraversal<T> implements BreathFirstTraversal<T> {
    /**
     * Printing traversal in diagonal order
     *
     * @param root root node of the tree
     * @return diagonal order traversal with different list
     */
    public List<List<T>> traversal(TreeNode<T> root) {
        List<List<T>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        List<T> diagonal = new LinkedList<>();
        Queue<TreeNode<T>> queue = new ArrayDeque<>();
        TreeNode<T> breakNode = new TreeNode<>(null);
        queue.offer(root);
        queue.offer(breakNode);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root == breakNode) {
                result.add(diagonal);
                diagonal = new LinkedList<>();
                queue.offer(breakNode);
                root = queue.poll();
                if (root == breakNode)
                    break;
            }

            while (root != null) {
                diagonal.add(root.data);

                if (root.leftChild != null)
                    queue.offer(root.leftChild);

                root = root.rightChild;
            }
        }
        return result;
    }
}
