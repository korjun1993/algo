package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main15651_N과M3 {
    static int m;                                           // 총 M개를 고를 수 있다.
    static int n;                                           // 주어진 숫자집합은 1~n이다.
    static int[] cand;                                      // 정답 후보
    static StringBuilder sb;

    static void solve(int depth) {                          // depth번째부터 M번째 원소를 조건에 맞게 고르는 모든 방법을 시도한다.
        if (depth == m + 1) {                               // 재귀가 종료되는 시점에서 수행하는 내용
            printcand();                                    // cand에 기록된 숫자를 출력한다
            return;
        }

        for (int number = 1; number <= n; number++) {       // 재귀가 진행되는 동안 수행하는 내용
            cand[depth] = number;                           // number를 depth번째 숫자로 정한다.
            solve(depth + 1);                         // depth+1번째부터 M번째 원소를 고르는 방법을 시도하여라.
            cand[depth] = 0;                                // depth번째 숫자가 number일때 모든 탐색이 끝났다.
        }
    }

    static void printcand() {                               // cand의 수를 모두 출력한다.
        for (int i = 1; i <= m; i++) {
            sb.append(cand[i] + " ");
        }
        sb.append("\n");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        sb = new StringBuilder();
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        cand = new int[m + 1];
        solve(1);
        System.out.println(sb.toString());
    }
}