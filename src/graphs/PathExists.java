package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathExists {


    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1},{0,2},{1,3},{3,4}};
        int src = 0;
        int dest = 4;

        System.out.println(pathExists(n, edges, src, dest));
    }

    public static boolean pathExists(int n, int[][] edges, int src, int dest) {
        if (n == 0) return false;
        if (src == dest) return true;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], element -> new ArrayList<>()).add(edge[1]);
        }
        boolean[] visited  = new boolean[n];
        return dfs(graph, src, dest, visited);
    }

    private static boolean dfs(Map<Integer, List<Integer>> graph, int start, int destination, boolean[] visited) {

        if( start ==  destination ) return true;
        if(visited[start]) return false;

        for(int neighbour : graph.get(start)) {
            if(dfs(graph, neighbour, destination, visited)) return true;
        }
        return false;

    }




}
