package algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {

    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) {

        int n = 10;

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[1].add(2);
        graph[1].add(5);
        graph[1].add(7);
        graph[2].add(3);
        graph[2].add(4);
        graph[5].add(4);
        graph[5].add(6);
        graph[6].add(8);
        graph[7].add(6);
        graph[8].add(9);
        graph[8].add(10);

        dfs(1);
        System.out.println();
        visited = new boolean[n + 1];
        dfs2(1);
    }

    public static void dfs(int n) {
        visited[n] = true;

        System.out.print(n + " ");

        for (int next : graph[n]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void dfs2(int n) {

        if (visited[n]) return;
        System.out.print(n + " ");
        visited[n] = true;

        for (int next : graph[n]) {
            dfs(next);
        }
    }
}
