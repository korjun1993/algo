package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main2251_물통 {
    static int[] water;
    static boolean vis[][][];
    static List<Integer> ans;

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        solve(new int[]{0, 0, water[2]});
        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        for (Integer an : ans) {
            sb.append(an).append(' ');
        }
        System.out.println(sb.toString());
    }

    // x에 있는 물을 다른 물병으로 옮기는 함수
    private static void solve(int[] state) {
        vis[state[0]][state[1]][state[2]] = true;

        if (state[0] == 0) {
            ans.add(state[2]);
        }
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (y == x) continue;
                if (state[x] == 0) continue;
                int[] temp = Arrays.copyOf(state, 3);
                int add = state[x];
                if (state[x] > water[y] - state[y]) {
                    add = water[y] - state[y];
                }
                temp[x] -= add;
                temp[y] += add;
                if (vis[temp[0]][temp[1]][temp[2]]) continue;
                solve(temp);
            }
        }
    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            water = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            vis = new boolean[water[0] + 1][water[1] + 1][water[2] + 1];
            ans = new LinkedList();
        } catch (Exception e) {

        }
    }
}
