package programmers.아이템_줍기;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/87694
// 오답 - 2배 로직 필요

public class Solution {

    public static final int[] DY = {-1, 1, 0, 0};
    public static final int[] DX = {0, 0, -1, 1};

    class Node {
        int curX;
        int curY;
        int distance;

        Node(int curX, int curY, int distance) {
            this.curX = curX;
            this.curY = curY;
            this.distance = distance;
        }
    }

    // result 17
    public static void main(String[] args) {
        int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;

        Solution solution = new Solution();
        solution.solution(rectangle,characterX,characterY,itemX,itemY);
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        int[][] maps = new int[51][51];

        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0];
            int y1 = rectangle[i][1];
            int x2 = rectangle[i][2];
            int y2 = rectangle[i][3];

            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    maps[y][x] = 1;
                }
            }
        }

        int[][] newArray = new int[51][51];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                newArray[maps.length-1-i][j] = maps[i][j];
            }
        }

        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < newArray[i].length; j++) {
                System.out.print(newArray[i][j] + " ");
            }
            System.out.println();
        }

        answer = this.bfs(maps,characterX,characterY,itemX,itemY);
        System.out.println(answer);

        return answer;
    }

    public int bfs(int[][] maps, int characterX, int characterY, int itemX, int itemY) {
        boolean[][] visited = new boolean[51][51];

        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(characterX, characterY, 0));
        visited[characterX][characterY] = true;

        while(!queue.isEmpty()) {

            Node cur = queue.poll();

            if (itemX == cur.curX && itemY == cur.curY) {
                return cur.distance;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.curX + DX[i];
                int ny = cur.curY + DY[i];

                // 바깥 X && 방문 X && fill
                if (ny >= 0 && ny < maps.length && nx >= 0 && nx < maps[0].length && !visited[ny][nx]
                && maps[ny][nx] == 1) {
                    for (int j = 0; j < 4; j++) {
                        int nnx = nx + DX[j];
                        int nny = ny + DY[j];
                        // 바깥 X && 테두리
                        if (nny >= 0 && nny < maps.length && nnx >= 0 && nnx < maps[0].length && maps[nny][nnx] == 0) {
                            visited[ny][nx] = true;
                            queue.offer(new Node(nx, ny, cur.distance + 1));
                            break;
                        }
                    }
                }
            }

//            for (int i = 0; i < maps.length; i++) {
//                for (int j = 0; j < maps[i].length; j++) {
//                    if (!visited[i][j]) {
//                        for (int k = 0; k < 4; k++) {
//                            int nr = i + DR[k];
//                            int nc = j + DC[k];
//
//                            if (maps[nr][nc] == 0) {
//
//                                visited[nr][nc] = true;
//                                queue.offer(new Node())
//
//                            }
//                        }
//                    }
//                }
//            }
        }

        return 0;
    }

    public int bfs2(int[][] map, int startX, int startY, int endX, int endY) {
        boolean[][] visited = new boolean[101][101];
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(startX, startY, 0));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            // 목적지 도착
            if (cur.curX == endX && cur.curY == endY) {
                return cur.distance;
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cur.curX + DX[i];
                int ny = cur.curY + DY[i];

                // 범위 체크 && 방문 체크 && 테두리인지 체크
                if (nx >= 0 && nx < 101 && ny >= 0 && ny < 101
                        && !visited[nx][ny] && map[nx][ny] == 1) {

                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny, cur.distance + 1));
                }
            }
        }

        return 0;
    }

}
