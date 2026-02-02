package programmers.게임_맵_최단거리;

// bfs 풀이 오답

import java.util.LinkedList;
import java.util.Queue;

public class Solution5 {

    private static final int[] DR = {-1, 1, 0 ,0};
    private static final int[] DC = {0, 0, -1, 1};

    public static void main(String[] args) {
        Solution5 solution = new Solution5();
        solution.solution();
    }

    public int solution () {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        boolean[][] visited = new boolean[maps.length][maps[0].length];

        int n = 0;
        int m = 0;
        System.out.println(bfs(maps, visited, n, m));
        return bfs(maps, visited, n, m) == 0 ? -1 : bfs(maps, visited, n, m);
    }

    public int bfs (int[][] maps, boolean[][] visited, int n, int m) {

        int result = 0;

        Queue<int[]> queue = new LinkedList<>();

        int[] geo = {n, m};

        queue.offer(geo);
        visited[n][m] = true;

        while(!queue.isEmpty()) {

            boolean isCount = false;

            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {

                int nr = cur[0] + DR[i];
                int nc = cur[1] + DC[i];

                // 맵초과체크 && 방문체크 && 벽체크
                if (nr >= 0 && nr < maps.length && nc >= 0 && nc < maps[0].length && !visited[nr][nc] && maps[nr][nc] != 0) {
                    visited[nr][nc] = true;
                    isCount = true;

                    if (nr == maps.length-1 && nc == maps[0].length-1) {
                        return result++;
                    }

                    int[] newGeo = {nr, nc};
                    queue.offer(newGeo);
                }
            }

            if (isCount) {
                result++;
            }
        }

        return result;

    }

}
