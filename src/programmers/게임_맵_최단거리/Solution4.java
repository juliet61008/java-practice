package programmers.게임_맵_최단거리;

public class Solution4 {

    private static final int[] DR = {-1,1,0,0};
    private static final int[] DC = {0,0,-1,1};
    private boolean[][] visited;
    private int maxDistance = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

        Solution4 solution = new Solution4();

        solution.solution(maps);
    }

    public int solution(int[][] maps) {
        int answer = 0;

        visited = new boolean[maps.length][maps[0].length];

        visited[0][0] = true;

        dfs(maps, 0, 0, 1, visited);

        System.out.println(maxDistance);

        return answer;
    }

    public void dfs(int[][] maps, int r, int c, int distance, boolean[][] visited) {
        if (r == maps.length-1 && c == maps[0].length-1) {
            if (distance < maxDistance) {
                maxDistance = distance;
            }

            return;
        }

        if (distance >= maxDistance) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + DR[i];
            int nc = c + DC[i];

            // 바깥, 벽 체크
            if (nr >= 0 && nr < maps.length && nc >= 0 && nc < maps[0].length && maps[nr][nc] == 1 && !visited[nr][nc]) {

                // 방문처리
                visited[nr][nc] = true;


                dfs(maps, nr, nc, distance+1, visited);
                visited[nr][nc] = false;
            }
        }
    }
}
