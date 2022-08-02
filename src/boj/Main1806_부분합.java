package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1806_부분합 {
    static int N, S, L, R;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        S = Integer.parseInt(str[1]);
        A = Arrays.stream(br.readLine().split(" ")).mapToInt((x) -> Integer.parseInt(x)).toArray();

        int sum = A[0];
        int answer = N + 1;

        while (L <= R && R < N) {
            if (sum < S) {
                R++;
                if (R < N) sum += A[R];
            } else {
                answer = Math.min(answer, R - L + 1);
                sum -= A[L++];
            }
        }

        if (answer > N) answer = 0;
        System.out.println(answer);
    }
}
