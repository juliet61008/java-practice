package programmers.네트워크;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43162
 */

public class Solution {

    public boolean[] visited;

    public static void main(String[] args) {

        int n = 5;
        int[][] computers = {{1, 1, 0, 0, 0}, {1, 1, 1, 0, 0}, {0, 1, 1, 0, 0}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}};

        Solution solution = new Solution();
        solution.solution(n, computers);
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;

        this.visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!this.visited[i]) {
                dfs(i, computers);
                answer++;
            }
        }

        System.out.println(answer);

        return answer;
    }

    public void dfs(int node, int[][] computers) {
        this.visited[node] = true;

        for (int i = 0; i < computers.length; i++) {
            if (!this.visited[i] && computers[node][i] == 1) {
                dfs(i, computers);
            }
        }
    }


}
