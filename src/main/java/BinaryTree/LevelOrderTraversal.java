package BinaryTree;

import Abstract.BinaryTree.BreathFirstTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal implements BreathFirstTraversal {
    /**
     * Level order traversal
     *
     * @param root root node of the tree
     * @return List of list of integers
     */
    public List<List<Integer>> traversal(BinaryTree.Node root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        List<Integer> row;
        Queue<BinaryTree.Node> queue = new ArrayDeque<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            row = new ArrayList<>();
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                root = queue.poll();
                if (root == null)
                    return result;

                row.add(root.data);

                if (root.leftChild != null)
                    queue.offer(root.leftChild);

                if (root.rightChild != null)
                    queue.offer(root.rightChild);
            }
            result.add(row);
        }

        return result;
    }
}
