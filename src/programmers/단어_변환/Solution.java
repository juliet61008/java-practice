package programmers.단어_변환;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public class Node {
        String word;
        Integer distance;

        public Node(String word, Integer distance) {
            this.word = word;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        String begin = "hit";
        String target = "cog";

        Solution solution = new Solution();
        solution.solution(begin,target,words);
    }

    public int solution(String begin, String target, String[] words) {

        if (Arrays.stream(words).noneMatch(s -> s.equals(target))) {
            return 0;
        }

        int answer = this.bfs(begin, target, words);

        System.out.println(answer);

        return answer;
    }

    public int bfs(String begin, String target, String[] words) {

        Queue<Node> queue = new LinkedList<>();

        boolean[] visited = new boolean[words.length];

        queue.offer(new Node(begin, 0));

        while(!queue.isEmpty()) {

            Node cur = queue.poll();

            if (cur.word.equals(target)) return cur.distance;

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && this.getDiffCount(words[i], cur.word) == 1) {
                    visited[i] = true;
                    queue.offer(new Node(words[i], cur.distance+1));
                }
            }
        }

        return 0;
    }

    public int getDiffCount(String word1, String word2) {

        int diffCount = 0;

        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }
        }

        return diffCount;
    }
}
