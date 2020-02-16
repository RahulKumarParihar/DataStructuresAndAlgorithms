package BinaryTree;

import Abstract.BinaryTree.BreathFirstTraversal;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DiagonalTraversal implements BreathFirstTraversal {
    /**
     * Printing traversal in diagonal order
     *
     * @param root root node of the tree
     * @return diagonal order traversal with different list
     */
    public List<List<Integer>> traversal(BinaryTree.Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        List<Integer> diagonal = new LinkedList<>();
        Queue<BinaryTree.Node> queue = new ArrayDeque<>();
        BinaryTree.Node breakNode = new BinaryTree().new Node(Integer.MIN_VALUE);
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
