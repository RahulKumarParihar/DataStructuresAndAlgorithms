package com.rahulkumarpariharmailbox.BinaryTree;

import java.util.List;

public class Execute {
    public void Run() {
        BinaryTree tree = CreateBinaryTree();
        ExecuteTraversal(tree);
    }

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
}
