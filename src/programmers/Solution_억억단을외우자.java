package programmers;

public class Solution_억억단을외우자 {
    public static int[] solution(int e, int[] starts) {
        int[] count = new int[e + 1];
        int[] number = new int[e + 1];

        // 1x1, 1x2, 1x3, 1x4, ... 1x5000000
        // 2x1, 2x2, 2x3, 2x4, ... 2x2500000
        // ...
        // 2500000x1, 2500000x2
        // 5000000x1
        // 시간복잡도? e/1 + e/2 + e/3 + ... e/e => 조화급수 (elne)
        for (int i = 1; i <= e; i++) {
            for (int j = 1; j <= e / i; j++) {
                count[i * j]++;
            }
        }

        number[e] = e;

        for (int i = e - 1; i > 0; i--) {
            if (count[i] >= count[i + 1]) {
                number[i] = i;
            } else {
                number[i] = number[i + 1];
                count[i] = count[i + 1];
            }
        }

        int[] answer = new int[starts.length];
        for (int i = 0; i < starts.length; i++) {
            answer[i] = number[starts[i]];
        }
        return answer;
    }

    public static void main(String[] args) {
        solution(8, new int[]{1, 3, 7});
    }
}
