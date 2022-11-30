package programmers;

import java.util.*;

public class Solution_귤고르기 {
    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
        List<Integer> counts = new LinkedList<>();
        int count = 1;
        for (int i = 0; i < tangerine.length - 1; i++) {
            if (tangerine[i] != tangerine[i + 1]) {
                counts.add(count);
                count = 1;
            } else {
                count++;
            }
        }
        counts.add(count);
        counts.sort(Comparator.reverseOrder());
        for (int cnt : counts) {
            if (k > 0) {
                k -= cnt;
                answer++;
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        solution(4, new int[]{1, 1, 1, 2, 2, 3, 3});
    }
}
