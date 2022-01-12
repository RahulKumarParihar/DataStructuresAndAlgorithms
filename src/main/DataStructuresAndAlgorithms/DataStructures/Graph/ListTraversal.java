package DataStructures.Graph;

import DataStructures.Structure.GraphNode;

import java.util.*;

public class ListTraversal extends Traversal {
    List<Map<Integer, Integer>> list = null;
    public ListTraversal(GraphNode graphNode) {
        super(graphNode);
        list = graphNode.getList();
    }

    @Override
    public List<Integer> DFS() {
        visited = new boolean[graphNode.getVertex()];
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < graphNode.getVertex(); i++){
            if(visited[i]){
                continue;
            }
            DFSUtil(i, list);
        }
        return list;
    }

    private void DFSUtil(int node, List<Integer> list ){
        list.add(node);
        visited[node] = true;

        Map<Integer, Integer> vertices = graphNode.getList().get(node);
        for(var vertex: vertices.entrySet()){
            if(visited[vertex.getKey()]){
                continue;
            }
            DFSUtil(vertex.getKey(), list);
        }
    }

    @Override
    public List<Integer> BFS() {
        visited = new boolean[graphNode.getVertex()];
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < graphNode.getVertex(); i++){
            if(visited[i]){
                continue;
            }

            queue.offer(i);
            visited[i] = true;

            while (!queue.isEmpty()){
                int node = queue.poll();
                list.add(node);
                Map<Integer, Integer> vertices = graphNode.getList().get(node);
                for(var vertex: vertices.entrySet()){
                    if(visited[vertex.getKey()]){
                        continue;
                    }
                    queue.offer(vertex.getKey());
                    visited[vertex.getKey()] = true;
                }
            }
        }
        return list;
    }
}
