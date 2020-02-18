package BinarySearchTree;

import Abstract.BinarySearchTree.Traversal;
import Structure.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class TreeTraversal<T> implements Traversal<T> {
    @Override
    public List<T> InOrderTraversal(TreeNode<T> root) {
        List<T> result = new LinkedList<>();
        ArrayDeque<TreeNode<T>> stack = new ArrayDeque<>();

        while (true) {
            while (root != null) {
                stack.push(root);

                root = root.leftChild;
            }

            if (stack.isEmpty())
                break;

            root = stack.pop();

            result.add(root.data);

            root = root.rightChild;
        }
        return result;
    }
}
