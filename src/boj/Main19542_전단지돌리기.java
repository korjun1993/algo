package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main19542_전단지돌리기 {
    static int n, s, d;
    static int ans;
    static int[] leaf;
    static List<Integer>[] tree;


    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        dfs(s, -1);
        System.out.println(ans * 2);
    }

    private static int dfs(int x, int pre) {
        for (int y : tree[x]) {
            if (y == pre) continue;
            leaf[x] = Math.max(leaf[x], dfs(y, x) + 1);
        }
        if (x != s && leaf[x] >= d) ans++;
        return leaf[x];
    }


    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {

            String[] str = br.readLine().split(" ");
            n = Integer.parseInt(str[0]);
            s = Integer.parseInt(str[1]);
            d = Integer.parseInt(str[2]);
            tree = new List[n + 1];
            leaf = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                tree[i] = new LinkedList();
            }
            for (int i = 0; i < n - 1; i++) {
                str = br.readLine().split(" ");
                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);
                tree[x].add(y);
                tree[y].add(x);
            }
        } catch (Exception e) {

        }
    }
}
