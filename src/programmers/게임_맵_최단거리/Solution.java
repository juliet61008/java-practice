package programmers.게임_맵_최단거리;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844
 */

public class Solution {
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

        Solution solution = new Solution();

        solution.solution(maps);
    }

    public int solution(int[][] maps) {

        // 행
        int[] dy = {-1, 1, 0, 0};
        // 열
        int[] dx = {0, 0, -1, 1};

        int answer = 0;

        // 위치
        // 행
        int n = 1;
        // 열
        int m = 1;

        // 행 사이즈
        int sizeN = maps.length;
        // 열 사이즈
        int sizeM = maps[0].length;

        return answer;
    }


}
