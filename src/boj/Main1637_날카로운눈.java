package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1637_날카로운눈 {
    static long ans = -1;
    static int n;
    static long l = Long.MAX_VALUE;
    static long r = 0;
    static long[][] numbers;

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }

    private static void pro() {
        while (l <= r) {
            long m = (l + r) / 2;
            if (determine(m)) { // m 이하의 수가 나온 개수를 구했을 때 홀수개인가?
                r = m - 1;
                ans = m;
            } else {
                l = m + 1;
            }
        }
        if (ans < 0) {
            System.out.println("NOTHING");
            return;
        }

        long count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (ans >= numbers[i][0] && ans <= numbers[i][1] && (ans - numbers[i][0]) % numbers[i][2] == 0) {
                count++;
            }
        }
        System.out.println(ans + " " + count);
    }

    private static boolean determine(long number) {
        long sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += getCount(i, number);
        }
        return sum % 2 == 1;
    }

    // number 이하의 수가 등장하는 횟수를 반환
    private static long getCount(int i, long number) {
        if (number < numbers[i][0]) return 0;
        long end = number;
        if (end > numbers[i][1]) {
            end = numbers[i][1];
        }
        return (end - numbers[i][0]) / numbers[i][2] + 1;
    }


    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = new long[n][3];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            numbers[i][0] = Long.parseLong(str[0]);
            numbers[i][1] = Long.parseLong(str[1]);
            numbers[i][2] = Long.parseLong(str[2]);
            l = Math.min(l, numbers[i][0]);
            r = Math.max(r, numbers[i][1]);
        }
    }
}
