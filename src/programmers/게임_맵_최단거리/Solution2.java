package programmers.게임_맵_최단거리;

class Solution2 {
    private static final int[] DY = {-1, 1, 0, 0};
    private static final int[] DX = {0, 0, -1, 1};
    private int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

        Solution2 solution = new Solution2();

        solution.solution(maps);
    }

    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];

        // 시작점 방문 처리
        visited[0][0] = true;

        // 0-based 인덱스로 시작
        dfs(maps, visited, 0, 0, 1);
        System.out.println(minValue);
        return minValue == Integer.MAX_VALUE ? -1 : minValue;
    }

    private void dfs(int[][] maps, boolean[][] visited, int r, int c, int distance) {
        // 도착 지점
        if (r == maps.length - 1 && c == maps[0].length - 1) {
            minValue = Math.min(minValue, distance);
            return;
        }

        // 가지치기
        if (distance >= minValue) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + DY[i];
            int nc = c + DX[i];

            // 범위 체크 (0-based)
            if (nr < 0 || nr >= maps.length || nc < 0 || nc >= maps[0].length) {
                continue;
            }

            // 벽이거나 방문한 곳
            if (maps[nr][nc] == 0 || visited[nr][nc]) {
                continue;
            }

            visited[nr][nc] = true;
            dfs(maps, visited, nr, nc, distance + 1);
            visited[nr][nc] = false;  // 백트래킹
        }
    }
}