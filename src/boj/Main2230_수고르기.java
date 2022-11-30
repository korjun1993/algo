package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2230_수고르기 {
    static int n, m;
    static int[] numbers;

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }

    private static void pro() {
        int ans = 2000000000;
        Arrays.sort(numbers);
        int l = 0;
        int r = 0;
        for (l = 0; l < numbers.length; l++) {
            while (r < numbers.length) {
                if (numbers[r] - numbers[l] >= m) {
                    ans = Math.min(ans, numbers[r] - numbers[l]);
                    break;
                }
                r++;
            }
        }
        System.out.println(ans);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
    }
}
