package programmers.네트워크;

// bfs

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {

    public static void main(String[] args) {

        int n = 5;
        int[][] computers = {{1, 1, 0, 0, 0}, {1, 1, 1, 0, 0}, {0, 1, 1, 0, 0}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}};

        Solution3 solution = new Solution3();
        solution.solution(n, computers);
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer+=bfs(i, computers, answer, visited);
            }
        }

        System.out.println(answer);

        return answer;
    }

    public int bfs(int start, int[][] computers, int answer, boolean[] visited) {

        if (visited[start]) {
            return 0;
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next = 0; next < computers.length; next++) {
                if (computers[cur][next] == 1 && !visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        return 1;

    }

}
