package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main23829_인문예술탐사주간 {
    static int n, q;
    static int arr[];
    static long sum[];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String str[] = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        q = Integer.parseInt(str[1]);
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        sum = new long[n + 1];
        pro();
    }

    private static void pro() throws Exception {
        Arrays.sort(arr);
        presum(); // 누적합 구하기
        for (int i = 0; i < q; i++) {
            long p = Long.parseLong(br.readLine());
            long index = binarySearch(p); // p의 순서 구하기
            long result = p * (2 * index - n) - 2 * sum[(int) index] + sum[n];
            System.out.println(result);
        }
    }

    private static void presum() {
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + arr[i];
        }
    }

    private static int binarySearch(long number) {
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] == number) {
                return m;
            } else if (arr[m] < number) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
