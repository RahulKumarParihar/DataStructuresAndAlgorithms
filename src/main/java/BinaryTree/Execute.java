package BinaryTree;

import Abstract.BinaryTree.BreathFirstTraversal;
import Abstract.BinaryTree.DepthFirstTraversal;
import Abstract.BinaryTree.Max;
import Abstract.BinaryTree.Searching;
import BinaryTree.Classes.*;

import java.util.List;
import java.util.Scanner;

public class Execute {
    /**
     * Run method
     */
    public void Run() {
        BinaryTree tree = CreateBinaryTree();
        ExecuteTraversal(tree);
        ExecuteMax(tree);
        ExecuteSearch(tree);
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

    /**
     * Will execute both recursive and iterative methods of traversal
     *
     * @param tree tree
     */
    private void ExecuteTraversal(BinaryTree tree) {
        DepthFirstTraversal iterative = new DepthFirstTraversalIterative();
        DepthFirstTraversal recursive = new DepthFirstTraversalRecusive();
        BreathFirstTraversal bft = new LevelOrderTraversal();
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
        System.out.println("LevelOrder Traversal");
        List<List<Integer>> levelOrderTraversal = bft.traversal(tree.root);
        for (List<Integer> list : levelOrderTraversal) {
            PrintList(list);
        }
        System.out.println("Diagonal Traversal");
        bft = new DiagonalTraversal();
        List<List<Integer>> diagonalTraversal = bft.traversal(tree.root);
        for (List<Integer> list : diagonalTraversal) {
            PrintList(list);
        }
    }

    /**
     * Will execute both iterative and recursive method to find max
     *
     * @param tree tree
     */
    private void ExecuteMax(BinaryTree tree) {
        Max iterative = new MaxIterative();
        Max recursive = new MaxRecursive();

        System.out.println(iterative.FindMax(tree.root));
        System.out.println(recursive.FindMax(tree.root));
    }

    private void ExecuteSearch(BinaryTree tree) {
        System.out.print("Enter the data you want to search for ");

        Scanner scan = new Scanner(System.in);
        int data = scan.nextInt();
        scan.close();

        Searching iterative = new SearchingIterative();
        Searching recursive = new SearchingRecursive();

        if (iterative.Search(tree.root, data))
            System.out.println("Data exists in tree");
        else
            System.out.println("Data doesn't exists in tree");

        if (recursive.Search(tree.root, data))
            System.out.println("Data exists in tree");
        else
            System.out.println("Data doesn't exists in tree");
    }
}
