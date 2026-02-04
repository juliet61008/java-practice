package programmers.아이템_줍기;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    public int[][] maps;
    public static final int[] DY = {-1, 1, 0, 0}; // 상, 하
    public static final int[] DX = {0, 0, -1, 1}; // 좌, 우

    static class Node {
        int x, y, distance;

        private Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;

        Solution2 solution = new Solution2();
        solution.solution(rectangle,characterX,characterY,itemX,itemY);
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        this.maps = new int[101][101];

        drawMap(rectangle);

        answer = this.bfs(maps,characterX*2,characterY*2,itemX*2,itemY*2) / 2;

        System.out.println(answer);

        return answer;
    }

    public int bfs(int[][] maps, int characterX, int characterY, int itemX, int itemY) {

        boolean[][] visited = new boolean[101][101];

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(characterX, characterY, 0));
        visited[characterY][characterX] = true;


        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.x == itemX && cur.y == itemY) {
                return cur.distance;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + DY[i];
                int nx = cur.x + DX[i];

                // 바깥 체크, 방문 체크, 테두리체크
                if (ny >= 0 && ny < 101 && nx >= 0 && nx < 101 && !visited[ny][nx] && maps[ny][nx] == 1) {

                    // 방문처리
                    visited[ny][nx] = true;
                    queue.offer(new Node(nx, ny, cur.distance+1));

                }
            }
        }

        return -1;
    }

    public void drawMap(int[][] rectangle) {
        for (int[] rec : rectangle) {
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;

            for (int x = x1; x < x2 + 1; x++) {
                for (int y = y1; y < y2 + 1; y++) {
                    this.maps[y][x] = 1;
                }
            }
        }

        for (int[] rec : rectangle) {
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;

            // 내부 비우기
            for (int x = x1+1; x < x2; x++) {
                for (int y = y1+1; y < y2; y++) {
                    this.maps[y][x] = 0;
                }
            }

        }

    }

    public void print(int[][] maps) {

        int[][] newMaps = new int[101][101];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                newMaps[maps.length-1-i][j] = maps[i][j];
            }
        }

        for (int[] map : newMaps) {
            for (int m: map) {
                System.out.print(m + " ");
            }
            System.out.println();
        }
    }


}
