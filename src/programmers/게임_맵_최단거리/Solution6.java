package programmers.게임_맵_최단거리;

import java.util.LinkedList;
import java.util.Queue;

public class Solution6 {

    private static final int[] DR = {-1, 1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};

    public static void main(String[] args) {
        Solution6 solution = new Solution6();
        solution.solution();
    }

    public int solution() {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

        int result = bfs(maps);

        System.out.println(result);

        return result;
    }

    public int bfs (int[][] maps) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});

        boolean[][] visited = new boolean[maps.length][maps[0].length];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == maps.length - 1 && cur[1] == maps[0].length - 1) {
                return cur[2];
            }

            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + DR[i];
                int nc = cur[1] + DC[i];

                if (nr >= 0 && nr < maps.length && nc >= 0 && nc < maps[0].length && maps[nr][nc] == 1 && !visited[nr][nc]) {
                    queue.offer(new int[]{nr,nc,cur[2] + 1});
                    visited[nr][nc] = true;
                }
            }
        }

        return -1;
    }

}
