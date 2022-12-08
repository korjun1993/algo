package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main10870_피보나치수5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] fibo = new int[21];
        fibo[1] = 1;
        for (int i = 2; i <= 20; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        System.out.println(fibo[n]);
    }
}
