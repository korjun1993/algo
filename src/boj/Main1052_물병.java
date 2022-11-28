package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1052_물병 {
    static int n, k;

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }

    private static void pro() {
        int answer = -1;
        int minBottle = 10000000;
        for (int cand = 23; cand >= 0; cand--) {
            int bottleSize = (int) Math.pow(2, cand);
            if (n >= bottleSize && k > 0) {
                minBottle = bottleSize;
                n -= bottleSize;
                k--;
            }
        }

        if (n > 0) {
            answer = minBottle - n;
        } else if (n == 0) {
            answer = 0;
        }
        System.out.println(answer);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        k = Integer.parseInt(str[1]);
    }
}
