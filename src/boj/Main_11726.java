package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11726 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dy[] = new int[1000 + 1];
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= n; i++) {
            dy[i] = (dy[i - 2] + dy[i - 1]) % 10007;
        };
    }
}
