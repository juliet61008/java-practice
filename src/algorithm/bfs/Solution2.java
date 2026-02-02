package algorithm.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public static void main(String[] args) {

        Solution2 solution = new Solution2();

        solution.solution();

    }

    public void solution () {

        ArrayList<Integer>[] graph = new ArrayList[11];

        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        this.generateLine(graph, 1, 2);
        this.generateLine(graph, 1, 5);
        this.generateLine(graph, 1, 7);
        this.generateLine(graph, 2, 3);
        this.generateLine(graph, 2, 4);
        this.generateLine(graph, 4, 5);
        this.generateLine(graph, 5, 6);
        this.generateLine(graph, 6, 7);
        this.generateLine(graph, 6, 8);
        this.generateLine(graph, 8, 9);
        this.generateLine(graph, 8, 10);

        this.bfs(graph, 1);

    }

    public void bfs (ArrayList<Integer>[] graph, int start) {
        Queue<Integer> queue = new LinkedList<>();

        boolean[] visited = new boolean[graph.length];

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");


            for (int next : graph[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

    }

    public void generateLine(ArrayList<Integer>[] graph, int n, int m) {
        graph[n].add(m);
        graph[m].add(n);
    }
}
