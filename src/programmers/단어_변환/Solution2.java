package programmers.단어_변환;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 오답 원인: 전역 distance 사용. 거리 정보를 각 큐에 각각 저장 해야함 Solution.java 참고

public class Solution2 {
    public static void main(String[] args) {
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        String begin = "hit";
        String target = "cog";

        Solution2 solution = new Solution2();
        System.out.println(solution.solution(begin,target,words));
    }

    public int solution(String begin, String target, String[] words) {

        if (Arrays.stream(words).noneMatch(w -> w.equals(target))) {
            return 0;
        }

        boolean[] visited = new boolean[words.length];

        return this.bfs(begin, target, words, visited, 0);
    }

    public int bfs(String begin, String target, String[] words, boolean[] visited, int distance) {

        Queue<String> queue = new LinkedList<>();

        queue.offer(begin);

        while(!queue.isEmpty()) {

            String cur = queue.poll();

            if (cur.equals(target)) {
                return distance;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && this.calDiffCount(words[i], cur) == 1) {
                    distance = distance+1;
                    queue.offer(words[i]);
                    visited[i] = true;
                }
            }
        }

        return 0;
    }

    public int calDiffCount (String word1, String word2) {

        int diffCount = 0;

        for (int i = 0; i < word1.length(); i++) {
            if(word1.charAt(i) != word2.charAt(i)) {
             diffCount++;
            }
        }

        return diffCount;
    }
}
