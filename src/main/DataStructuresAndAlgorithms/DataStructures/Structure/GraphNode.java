package DataStructures.Structure;

import DataStructures.Enums.GraphRepresentation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphNode {
    private int vertex;
    private GraphRepresentation representation;
    private int[][] matrix = null;
    private List<Map<Integer, Integer>> list = null;

    public int edges;

    public int getVertex() {
        return vertex;
    }

    public GraphRepresentation getRepresentation() {
        return representation;
    }

    public GraphNode(int vertex, GraphRepresentation representation) {
        this.vertex = vertex;
        this.representation = representation;
    }

    public int[][] getMatrix() {
        if(representation != GraphRepresentation.AdjacentMatrix){
            throw new RuntimeException("Change Representation in Constructor");
        }
        if(vertex <= 0){
            throw new RuntimeException("Node must be a positive integer.");
        }
        if(matrix == null){
            matrix = new int[vertex][vertex];
        }
        return matrix;
    }

    public List<Map<Integer, Integer>> getList() {
        if(representation != GraphRepresentation.AdjacentList){
            throw new RuntimeException("Change Representation in Constructor");
        }
        if(vertex <= 0){
            throw new RuntimeException("Node must be a positive integer.");
        }
        if(list == null){
            list = new ArrayList<>(vertex);
            for(int i = 0; i < vertex; i++){
                list.add(new HashMap<>());
            }
        }
        return list;
    }
}
