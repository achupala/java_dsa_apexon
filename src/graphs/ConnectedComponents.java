package graphs;

import java.util.*;

public class ConnectedComponents {

    public static int countComponents(int n, int[][] edges) {
        if (n == 0) return 0;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], ele -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], ele -> new ArrayList<>()).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited);
                components++;
            }
        }

        return components;
    }

    private static void dfs(Map<Integer, List<Integer>> graph, int node, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1},{1,2},{3,4}};
        System.out.println(countComponents(n, edges));

        int[][] edges2 = {};
        System.out.println(countComponents(n, edges2));

        int[][] edges3 = {{0,1},{1,2},{2,3},{3,4}};
        System.out.println(countComponents(n, edges3));
    }
}
