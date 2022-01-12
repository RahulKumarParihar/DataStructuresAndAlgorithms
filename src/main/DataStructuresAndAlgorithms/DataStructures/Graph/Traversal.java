package DataStructures.Graph;

import DataStructures.Structure.GraphNode;
import DataStructures.Enums.GraphRepresentation;

import java.util.List;

public abstract class Traversal {
    protected boolean[] visited;
    protected GraphNode graphNode;

    public Traversal(GraphNode graphNode) {
        this.graphNode = graphNode;
    }

    abstract List<Integer> DFS();
    abstract List<Integer> BFS();

    public Traversal getTraversalObject(GraphRepresentation representation){
        if(representation == GraphRepresentation.AdjacentList){
            return new ListTraversal(graphNode);
        }
        return new MatrixTraversal(graphNode);
    }
}
