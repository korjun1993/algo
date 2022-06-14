package programmers;

import java.util.Arrays;
import java.util.HashMap;

public class Solution_보석쇼핑 {
    public static void main(String[] args) {
        String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        int[] answer = solution(gems);
        System.out.println(Arrays.toString(answer));
    }

    private static int[] solution(String[] gems) {
        int[] answer = new int[2];
        HashMap<String, Integer> visit = new HashMap<String, Integer>();
        for (String key : gems) visit.put(key, 0);
        int l = 0, r = 0; // two pointer
        int cnt = 0; // 획득한 보석 종류
        int n = gems.length; // 보석 수
        int size = visit.size(); // 보석 종류
        int len = 100001; // 구간 길이

        for (l = 0; l < n; l++) {
            if (l > 0) {
                String gem = gems[l - 1];
                int visittime = visit.get(gem) - 1;
                if (visittime == 0) cnt--;
                visit.put(gem, visittime);
            }
            while (r < n && cnt < size) {
                String gem = gems[r++];
                int visittime = visit.get(gem) + 1;
                if (visittime == 1) cnt++;
                visit.put(gem, visittime);
            }

            // 조건을 만족하는 구간 길이 -> 정답으로 갱신
            if (cnt == size && len > r - l) {
                len = r - l;
                answer[0] = l + 1;
                answer[1] = r;
            }
        }

        return answer;

    }
}
