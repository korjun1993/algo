package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main14888_연산자끼워넣기 {
    static int N, min, max; // 수열의 갯수, 최솟값, 최댓값
    static int[] A, B, selected; // 수열, 연산자 갯수, 연산자

    public static void main(String[] args) throws Exception {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[];
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        str = br.readLine().split(" ");
        for(int i = 0; i < N; i++) A[i] = Integer.parseInt(str[i]);
        B = new int[5];
        selected = new int[N];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        str = br.readLine().split(" ");
        for(int i = 1; i <= 4; i++) B[i] = Integer.parseInt(str[i-1]);

        // process
        prcoess(0);
        System.out.println(max);
        System.out.println(min);
    }

    private static void prcoess(int k) {
        if (k == N - 1) {
            int result = A[0];
            for (int i = 1; i < N; i++) {
                result = calc(result, A[i], selected[i-1]);
            }
            min = Math.min(result, min);
            max = Math.max(result, max);
        } else {
            for (int op = 1; op <= 4; op++) {
                if(B[op] == 0) continue;
                selected[k] = op;
                B[op]--;
                prcoess(k + 1);
                selected[k] = 0;
                B[op]++;
            }
        }
    }

    private static int calc(int num1, int num2, int oper) {
        if(oper == 1) {
            return num1 + num2;
        }
        else if(oper == 2) {
            return num1 - num2;
        }
        else if(oper == 3) {
            return num1 * num2;
        }
        else {
            return num1 / num2;
        }
    }
}
