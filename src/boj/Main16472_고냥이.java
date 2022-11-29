package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main16472_고냥이 {
    static int n, ans;
    static String s;
    static int[] cnt;

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }

    private static void pro() {
        int r = 0;
        for (int l = 0; l < s.length(); l++) {
            while (r < s.length()) {    // r 값을 증가시키면서 포함 가능한 문자 후보를 찾는다.
                int rightChar = s.charAt(r) - 'a';
                if (cnt[rightChar] == 0) {  // 처음으로 등장하는 알파벳이고
                    if (n == 0) break;      // 현재까지 찾은 알파벳의 종류가 이미 N개의 알파벳이면, 더 이상 포함시킬 수 없으므로 중지
                    n--;                    // N개 이하라면 포함시킨다.
                }
                cnt[rightChar]++;
                r++;
                ans = Math.max(ans, r - l);
            }
            int leftChar = s.charAt(l) - 'a';
            cnt[leftChar]--;
            if (cnt[leftChar] == 0) {
                n++;
            }
        }
        System.out.println(ans);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = br.readLine();
        cnt = new int[26];
    }
}
