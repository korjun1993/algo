package programmers;

import java.util.*;

public class Solution_순위검색 {
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        int[] answer = solution(info, query);
    }

    private static int[] solution(String[] info, String[] query) {
        Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        int[] answer = new int[query.length];

        // 문자열[lang + job + career + favorite]을 key로 삼아 리스트에 점수 추가
        for (String s : info) {
            String[] str = s.split(" ");

            for (int i = 0; i < 16; i++) {
                String key = "";
                for (int j = 0; j < 4; j++) {
                    key += (i & (1 << j)) > 0 ? str[j] : "-";
                }
                map.putIfAbsent(key, new ArrayList<Integer>());
                map.get(key).add(Integer.parseInt(str[4]));
            }
        }

        // 점수에 따라 정렬
        for (ArrayList<Integer> l : map.values()) {
            Collections.sort(l);
        }

        for (int i = 0; i < query.length; i++) {
            String[] q = query[i].replace("and", "").replace("  ", " ").split(" ");
            String key = q[0] + q[1] + q[2] + q[3];
            int score = Integer.parseInt(q[4]);
            if (!map.containsKey(key)) continue;
            answer[i] = lower_bound(map.get(key), score);
        }
        return answer;
    }

    static int lower_bound(ArrayList<Integer> list, int score) {
        int result = -2;
        int L = 0, R = list.size() - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (list.get(mid) < score) {
                L = mid + 1;
                result = mid;
            } else R = mid - 1;
        }

        return result < -1 ? 0 : list.size() - result - 1;
    }
}
