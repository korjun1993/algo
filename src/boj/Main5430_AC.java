package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main5430_AC {
    static int T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            int[] arr = input(br.readLine(), n);
            pro(arr, n, p);
        }
    }

    private static int[] input(String string, int n) {
        if (n == 0) return new int[0];
        string = string.replace("[", "").replace("]", "");
        return Arrays.stream(string.split(","))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static void pro(int[] arr, int n, String p) {
        int head = 0;
        int tail = n - 1;
        int size = tail - head + 1;
        int dir = 1; // dir: 방향 (1:정방향, -1:거꾸로)
        for (char ch : p.toCharArray()) {
            if (ch == 'R') {
                int temp = head;
                head = tail;
                tail = temp;
                dir *= -1;
            } else if (ch == 'D') {
                if (size == 0) {
                    System.out.println("error");
                    return;
                }
                head += dir;
                size--;
            }
        }
        System.out.println(getResult(arr, head, size, dir));
    }

    private static String getResult(int[] arr, int head, int size, int dir) {
        List<Integer> result = new LinkedList<>();
        while(size-- > 0) {
            result.add(arr[head]);
            head += dir;
        }
        return result.toString().replace(" ", "");
    }
}
