package programmers;

import java.util.*;

public class Solution_단어변환 {
    public int solution(String begin, String target, String[] words) {
        Map<String, Boolean> visit = new HashMap();
        Map<String, Integer> dist = new HashMap();
        Queue<String> que = new LinkedList<>();

        //시작점 초기화
        visit.put(begin, true);
        que.offer(begin);

        while (!que.isEmpty()) {
            String current = que.poll();
            for (String word : words) {
                if (compare(current, word) != 1) {
                    continue;
                }
                if (visit.getOrDefault(word, false)) {
                    continue;
                }
                que.add(word);
                visit.put(word, true);
                dist.put(word, dist.getOrDefault(current, 0) + 1);
            }
        }
        return dist.getOrDefault(target, 0);
    }

    private int compare(String current, String word) {
        int[] arr = {};
        int min = Arrays.stream(arr).min().getAsInt();
        int count = 0;
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != word.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
