package algorithm.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution3 {

    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) {
        int n = 5;
        graph = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(1);
        graph[0].add(2);
        graph[1].add(0);
        graph[1].add(3);
        graph[1].add(4);
        graph[2].add(0);
        graph[3].add(1);
        graph[4].add(1);

        bfs(0);
    }

    public static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);

        visited[n] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            System.out.print(cur + " ");

            for (int i : graph[cur]) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}
