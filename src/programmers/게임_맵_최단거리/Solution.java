package programmers.게임_맵_최단거리;

import java.util.Arrays;

/**
 * 틀림
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844
 */

public class Solution {

    static final int[] DY = {-1, 1, 0, 0};
    static final int[] DX = {0, 0, -1, 1};
    static boolean[][] visited;
    static int MIN_VALUE = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

        Solution solution = new Solution();

        solution.solution(maps);
    }

    public int solution(int[][] maps) {

        visited = new boolean[maps.length][maps[0].length];

        // 첫번째 방문처리
        visited[0][0] = true;

        // 위치
        // 행
        int n = 1;
        // 열
        int m = 1;

        dfs(maps, visited, n, m, 1);
        System.out.println(MIN_VALUE);
        return MIN_VALUE;
    }

    public static void dfs(int[][] maps, boolean[][] visited, int n, int m, int distance) {
        for (int i = 0; i < 4; i++) {
            int ny = n + DY[i];
            int nx = m + DX[i];

//            System.out.println("ny : " + ny + ", nx : " + nx);
            if (ny < 1 || ny > maps.length || nx < 1 || nx > maps[0].length || maps[ny-1][nx-1] == 0 || visited[ny-1][nx-1]) {
                continue;
            }

            // 방문처리
            visited[ny-1][nx-1] = true;
            distance++;

            // 탈출조건
            if (ny == maps.length && nx == maps[0].length) {

                if (distance < MIN_VALUE) {
                    MIN_VALUE = distance;
                }

                return;
            }

            dfs(maps, visited, ny, nx, distance);
            // 백트래킹
            visited[ny-1][nx-1] = false;
        }
    }


}
