package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2531_회전초밥 {
    static int n; // 접시개수
    static int d; // 초밥 가짓수
    static int k; // 연속해서 먹는 접시수
    static int c; // 쿠폰 번호
    static int[] arr; // 초밥

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }

    private static void pro() {
        int ans = 0;
        int kind = 1;
        int[] count = new int[3001];
        count[c]++;

        int r = 0;
        for (int l = 0; l < n; l++) {
            while (k > 0) {
                count[arr[r]]++;
                if (count[arr[r]] == 1) {
                    kind++;
                }
                r++;
                r %= n; // 회전처리
                k--;
            }
            ans = Math.max(ans, kind);
            count[arr[l]]--;
            k++;
            if (count[arr[l]] == 0) {
                kind--;
            }
        }
        System.out.println(ans);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        d = Integer.parseInt(str[1]);
        k = Integer.parseInt(str[2]);
        c = Integer.parseInt(str[3]);
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }
}
