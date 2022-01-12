package DataStructures.Graph;

import DataStructures.Structure.GraphNode;

import java.util.ArrayList;
import java.util.List;

public class MatrixTraversal extends Traversal {

    public MatrixTraversal(GraphNode graphNode) {
        super(graphNode);
    }

    @Override
    List<Integer> DFS() {
        visited = new boolean[graphNode.getVertex()];
        List<Integer> list = new ArrayList<>();


        return list;
    }

    @Override
    List<Integer> BFS() {
        visited = new boolean[graphNode.getVertex()];
        List<Integer> list = new ArrayList<>();
        return list;
    }

    private void DFSUtil() {

    }
}
