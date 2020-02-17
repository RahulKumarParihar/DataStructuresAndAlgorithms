package BinarySearchTree;

import Abstract.BinarySearchTree.Travesal;
import Structure.BinarySearchTreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class Traversal implements Travesal {
    @Override
    public List<Integer> InOrderTraversal(BinarySearchTreeNode root) {
        List<Integer> result = new LinkedList<>();
        ArrayDeque<BinarySearchTreeNode> stack = new ArrayDeque<>();

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
