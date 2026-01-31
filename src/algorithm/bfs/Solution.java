package algorithm.bfs;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        // 그래프 구성
        // 0 - 1 - 3
        // |   |
        // 2   4

        int n = 5;  // 노드 개수
        ArrayList<Integer>[] graph = new ArrayList[n];

        // 초기화
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 추가 (양방향)
        graph[0].add(1);
        graph[0].add(2);
        graph[1].add(0);
        graph[1].add(3);
        graph[1].add(4);
        graph[2].add(0);
        graph[3].add(1);
        graph[4].add(1);

        // BFS 실행
        System.out.println("BFS 탐색 결과:");
        bfs(graph, 0, n);
    }

    public static void bfs(ArrayList<Integer>[] graph, int start, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        // 1. 시작점 세팅
        queue.offer(start);
        visited[start] = true;

        // 2. BFS 시작
        while (!queue.isEmpty()) {
            // 3. 큐에서 꺼내기
            int cur = queue.poll();
            System.out.print(cur + " ");

            // 4. 인접 노드 탐색
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        System.out.println();
    }
}