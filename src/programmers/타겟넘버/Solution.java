package programmers.타겟넘버;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    static int answer;

    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;

        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, 0, 0, target);

        return answer;

    }

    public static void dfs(int[] numbers, int depth, int sum, int target) {
        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
            }

            return;
        }

        int plus = sum + numbers[depth];
        int minus = sum - numbers[depth];

        dfs(numbers, depth + 1, plus, target);
        dfs(numbers, depth + 1, minus, target);

    }
}
