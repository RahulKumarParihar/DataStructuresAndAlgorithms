package com.rahulkumarpariharmailbox.BinaryTree;

import com.rahulkumarpariharmailbox.BinaryTree.Interfaces.DepthFirstTraversal;

import java.util.List;
import java.util.Stack;

public class Execute {
    /**
     * Run method
     */
    public void Run() {
        BinaryTree tree = CreateBinaryTree();
        ExecuteTraversal(tree);
        System.out.println(FindMax(tree.root));
        System.out.println(FindMaxRecursion(tree.root));
    }

    /**
     * This method is used for creating a Binary Tree
     *
     * @return BinaryTree
     */
    private BinaryTree CreateBinaryTree() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new BinaryTree().new Node(1);
        binaryTree.root.leftChild = new BinaryTree().new Node(2);
        binaryTree.root.rightChild = new BinaryTree().new Node(3);
        binaryTree.root.leftChild.leftChild = new BinaryTree().new Node(4);
        binaryTree.root.leftChild.rightChild = new BinaryTree().new Node(5);
        binaryTree.root.rightChild.leftChild = new BinaryTree().new Node(6);
        binaryTree.root.rightChild.rightChild = new BinaryTree().new Node(7);
        return binaryTree;
    }

    /**
     * Print all the elements of a list in a single row
     *
     * @param list a list
     */
    private void PrintList(List<Integer> list) {
        for (int item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private void ExecuteTraversal(BinaryTree tree) {
        DepthFirstTraversal iterative = new DepthFirstTraversalIterative();
        DepthFirstTraversal recursive = new DepthFirstTraversalRecusive();
        List<Integer> traversalList;
        traversalList = iterative.PreOrderTraversal(tree.root);
        System.out.println("PreOrder Traversal Iterative");
        PrintList(traversalList);
        traversalList = recursive.PreOrderTraversal(tree.root);
        System.out.println("PreOrder Traversal Recursive");
        PrintList(traversalList);
        traversalList = iterative.InOrderTraversal(tree.root);
        System.out.println("InOrder Traversal Iterative");
        PrintList(traversalList);
        traversalList = recursive.InOrderTraversal(tree.root);
        System.out.println("InOrder Traversal Recursive");
        PrintList(traversalList);
        traversalList = iterative.PostOrderTraversal(tree.root);
        System.out.println("PostOrder Traversal Iterative");
        PrintList(traversalList);
        traversalList = recursive.PostOrderTraversal(tree.root);
        System.out.println("PostOrder Traversal Recursive");
        PrintList(traversalList);
    }

    private int FindMax(BinaryTree.Node root) {
        int max = -1;
        Stack<BinaryTree.Node> stack = new Stack<>();
        BinaryTree.Node previous = null;
        do {
            while (root != null) {
                stack.add(root);

                root = root.leftChild;
            }

            while (root == null && !stack.empty()) {
                root = stack.peek();

                if (root.rightChild == null || root.rightChild == previous) {
                    if (max < root.data)
                        max = root.data;
                    stack.pop();
                    previous = root;
                    root = null;
                } else {
                    root = root.rightChild;
                }
            }
        } while (!stack.empty());
        return max;
    }

    private int FindMaxRecursion(BinaryTree.Node root) {
        int max = -1;
        if (root != null) {
            int dataValue = root.data;
            int left = FindMaxRecursion(root.leftChild);
            int right = FindMaxRecursion(root.rightChild);
            max = left > right ? left : right;
            max = dataValue > max ? dataValue : max;
        }
        return max;
    }
}
