package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main17299_오등큰수 {
    static int[] cnt = new int[1000001];
    static int[] a;
    static int n;


    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        for (int i = 0; i < n; i++) {
            cnt[a[i]]++;
        }
        Stack<Integer> rs = new Stack();
        Stack<Integer> st = new Stack();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty()) { // a[i] 오른쪽 수 중, a[i]보다 작거나 같은 수는 의미 X
                int top = st.peek();
                if (cnt[top] <= cnt[a[i]]) {
                    st.pop();
                } else break;
            }
            rs.push(st.empty() ? -1 : st.peek()); // 오른쪽 수 중 남은게 없다면 -1
            st.push(a[i]);
        }
        StringBuilder sb = new StringBuilder();
        while (!rs.empty()) {
            sb.append(rs.pop()).append(' ');
        }
        System.out.println(sb.toString());
    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            n = Integer.parseInt(br.readLine());
            a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        } catch (Exception e) {

        }
    }
}
