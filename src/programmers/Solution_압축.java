package programmers;

import java.util.*;

public class Solution_압축 {
    public int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();
        String[] alphabets = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        for (int index = 0; index < 26; index++) {
            dict.put(alphabets[index], index + 1);
        }

        LinkedList<Integer> output = new LinkedList<>();
        int i = 0;
        while (i < msg.length()) {
            int max = find(i, msg, dict);
            String current = msg.substring(i, max);
            output.add(dict.get(current));
            i = max;
            if (i + 1 < msg.length()) {
                String next = Character.toString(msg.charAt(i));
                if (!dict.containsKey(current + next)) {
                    dict.put(current + next, dict.size() + 1);
                }
            }
        }
        return output.stream().mapToInt(x -> x).toArray();
    }

    private int find(int start, String msg, Map<String, Integer> dict) {
        int result = start + 1;
        for (int i = start + 1; i <= msg.length(); i++) {
            String str = msg.substring(start, i);
            if (dict.containsKey(str)) {
                result = i;
            }
        }
        return result;
    }
}
