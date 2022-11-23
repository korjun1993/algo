package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1300_K번째수 {
    static long n, k;

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        long l = 1;
        long r = n * n;
        while (l <= r) {
            long m = (l + r) / 2;
            long lower = lowerbound(m); // 숫자 m이 제일 처음 등장하는 순서가 뭔지?
            long upper = upperbound(m); // 숫자 m이 제일 늦게 등장하는 순서가 뭔지?
            if (lower <= k && k <= upper) { // k가 lower, upper 사이이라면 종료
                System.out.println(m);
                break;
            } else if (k < lower) {
                r = m - 1;
            } else if (k > upper) {
                l = m + 1;
            }
        }
    }

    private static long upperbound(long number) {
        long count = 0;
        for (long i = 1; i <= n; i++) {
            long l = 1;
            long r = n;
            while (l <= r) {
                long m = (l + r) / 2;
                long value = m * i; // 가운데 위치의 값
                if (value <= number) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            count += r;
        }
        return count;
    }

    private static long lowerbound(long number) {
        long count = 0;
        for (long i = 1; i <= n; i++) {
            long l = 1;
            long r = n;
            while (l <= r) {
                long m = (l + r) / 2;
                long value = m * i; // 가운데 위치의 값
                if (value < number) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            count += r;
        }
        return count + 1;
    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            n = Integer.parseInt(br.readLine());
            k = Integer.parseInt(br.readLine());
        } catch (Exception ignored) {
        }
    }
}
