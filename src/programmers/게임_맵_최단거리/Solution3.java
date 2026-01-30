package programmers.게임_맵_최단거리;

public class Solution3 {
    private int[][] maps;
    private boolean[][] visited;
    private int n, m;
    private int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

        Solution3 solution = new Solution3();

        solution.solution(maps);
    }

    // 상하좌우 이동
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        this.maps = maps;
        this.n = maps.length;
        this.m = maps[0].length;
        this.visited = new boolean[n][m];

        visited[0][0] = true;
        dfs(0, 0, 1);

        System.out.println(minDistance);

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private void dfs(int x, int y, int distance) {
        // 도착 지점에 도달한 경우
        if (x == n - 1 && y == m - 1) {
            minDistance = Math.min(minDistance, distance);
            return;
        }

        // 현재 거리가 이미 찾은 최단거리보다 크면 중단
        if (distance >= minDistance) {
            return;
        }

        // 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 맵 범위 내에 있고, 벽이 아니며, 방문하지 않은 곳
            if (nx >= 0 && nx < n && ny >= 0 && ny < m
                    && maps[nx][ny] == 1 && !visited[nx][ny]) {

                visited[nx][ny] = true;
                dfs(nx, ny, distance + 1);
                visited[nx][ny] = false; // 백트래킹
            }
        }
    }
}
