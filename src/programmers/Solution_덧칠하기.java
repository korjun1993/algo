package programmers;

public class Solution_덧칠하기 {
    public int solution(int n, int m, int[] section) {
        int count = 0;
        int right = 0;
        for (int leftIdx = 0; leftIdx < section.length; leftIdx++) {
            if (right <= section[leftIdx]) continue;
            right = section[leftIdx] + m - 1;
            count++;
        }
        return count;
    }
}
