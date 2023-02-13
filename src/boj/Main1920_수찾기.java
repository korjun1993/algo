package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1920_수찾기 {

    static int m, n;
    static int[] numbers;
    static int[] target;

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }

    private static void pro() {
        Arrays.sort(numbers);
        for (int i = 0; i < m; i++) {
            int result = binarySearch(target[i]);
            System.out.println(result);
        }
    }

    private static int binarySearch(int target) {
        int l = 0;
        int r = n - 1;
        while(l <= r) {
            int m = l + (r - l) / 2;
            if (numbers[m] == target) {
                return 1;
            } else if (numbers[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return 0;
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        m = Integer.parseInt(br.readLine());
        target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
