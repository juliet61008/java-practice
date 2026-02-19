package algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

public class Solution5 {

    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) {

        int n = 8;

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[1].add(2);
        graph[1].add(3);
        graph[2].add(5);
        graph[2].add(4);
        graph[3].add(4);
        graph[3].add(6);
        graph[3].add(8);
        graph[4].add(7);

        dfs(1);

    }

    public static void dfs(int node) {

        System.out.print(node + " ");

        visited[node] = true;

        for (int next: graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

}
