package programmers.게임_맵_최단거리;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844
 */

public class Solution {
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

        int n = maps[0].length;
        int m = maps.length;



        Solution solution = new Solution();

        solution.solution(maps);
    }

    public int solution(int[][] maps) {
        int answer = 0;
        return answer;
    }

}
