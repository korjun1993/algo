package programmers;

import java.util.*;

public class Solution_메뉴리뉴얼 {
    static int max;
    static Map<String, Integer> map = new HashMap<String, Integer>();

    public static void main(String[] args) {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};
        String answer[] = solution(orders, course);
    }

    private static String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < course.length; i++) {
            for (int j = 0; j < orders.length; j++) {
                comb(orders[j], "", 0, 0, course[i]);
            }
            if (max < 2) continue;
            map.forEach((k, v) -> {
                if (v == max) list.add(k);
            });
            map.clear();
            max = 0;
        }

        String[] answer = list.toArray(new String[0]);
        Arrays.sort(answer);
        return answer;
    }

    /**
     * 총 m개를 뽑는 함수
     *
     * @param order:  주문 예) "ABCD"
     * @param str:    현재까지 선택한 조합
     * @param start:  선택을 시작할 인덱스
     * @param curNum: 현재 선택해야할 단계
     * @param maxNum: 골라야할 갯수
     */
    private static void comb(String order, String str, int start, int curNum, int maxNum) {
        if (curNum == maxNum) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            map.put(s, map.getOrDefault(s, 0) + 1);
            max = Math.max(max, map.get(s));
            return;
        }

        for (int cand = start; cand < order.length(); cand++) {
            str += order.charAt(cand);
            comb(order, str, cand + 1, curNum + 1, maxNum);
            str = str.substring(0, curNum);
        }
    }
}
