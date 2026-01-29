package algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 주석하면서 dfs
 */

public class Solution3 {

    // 방문
    static boolean[] visited;
    // 노드 그래프
    static List<Integer>[] graph;

    public static void main(String[] args) {
        // 노드 개수
        int n = 8;
        // 방문 초기화
        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];

        // 각 배열 ArrayList 초기화
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 설정
        graph[1].add(2);
        graph[1].add(3);
        graph[2].add(5);
        graph[2].add(4);
        graph[3].add(4);
        graph[3].add(6);
        graph[3].add(8);
        graph[4].add(7);

        // 실행
        dfs(1);

    }

    // dfs 메서드
    public static void dfs(int node) {

        System.out.print(node + " ");

        // 방문처리
        visited[node] = true;

        // 노드의 간선리스트 순회
        for (int next : graph[node]) {
            // 방문하지 않은 경우 재귀
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

}
