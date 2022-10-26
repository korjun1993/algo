package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main1068_트리 {
    static int N;
    static int root, erased;
    static int[] leaf;
    static List<Integer>[] child;

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            N = Integer.parseInt(br.readLine());
            leaf = new int[N];
            child = new List[N];
            for (int i = 0; i < N; i++) {
                child[i] = new LinkedList();
            }
            String[] str = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                int p = Integer.parseInt(str[i]);
                if (p == -1) root = i;
                else child[p].add(i);
            }
            erased = Integer.parseInt(br.readLine());
        } catch (Exception e) {
        }
    }

    private static void pro() {
        // erased와 그의 부모 사이의 연결을 끊어주기
        for (int i = 0; i < N; i++) {
            if (child[i].contains(erased)) {
                child[i].remove(child[i].indexOf(erased));
                break;
            }
        }

        // erased가 root인 예외 처리하기
        if (root != erased) {
            dfs(root);
        }

        // 정답 출력하기
        System.out.println(leaf[root]);
    }

    // dfs(x, par) := 정점 x의 부모가 par였고, Subtree(x)의 leaf 개수를 세주는 함수
    private static void dfs(int x) {
        if (child[x].isEmpty()) {
            leaf[x] = 1;
            return;
        }

        for (int i : child[x]) {
            dfs(i);
            leaf[x] += leaf[i];
        }
    }
}
