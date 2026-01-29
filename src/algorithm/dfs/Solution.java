package algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) {
        int n = 5; // 노드 개수
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        // 그래프 초기화
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 추가
        graph[1].add(2);
        graph[1].add(3);
        graph[2].add(4);
        graph[3].add(5);

        dfs(1); // 1번 노드부터 시작
    }
}
