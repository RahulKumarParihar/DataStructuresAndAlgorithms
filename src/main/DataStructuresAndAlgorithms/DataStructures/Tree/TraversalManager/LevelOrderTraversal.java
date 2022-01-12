package DataStructures.Tree.TraversalManager;

import DataStructures.Abstract.Tree.TraversalManager.BreathFirstTraversal;
import DataStructures.Structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal<T> implements BreathFirstTraversal<T> {
    /**
     * Level order traversal
     *
     * @param root root node of the tree
     * @return List of list of integers
     */
    public List<List<T>> traversal(TreeNode<T> root) {
        List<List<T>> result = new ArrayList<>();

        if (root == null)
            return result;

        List<T> row;
        Queue<TreeNode<T>> queue = new ArrayDeque<>();

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
