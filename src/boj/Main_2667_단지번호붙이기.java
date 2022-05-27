package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2667_단지번호붙이기 {
    static int N, A[][];
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static List<Integer> answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];
        answer = new ArrayList<Integer>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                A[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] == 1) bfs(i, j);
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for (int i = 0; i < answer.size(); i++) System.out.println(answer.get(i));
    }

    private static void bfs(int i, int j) {
        int count = 0;
        Queue<Pair> que = new LinkedList<Pair>();
        que.add(new Pair(i, j));
        A[i][j] = 0;
        while (!que.isEmpty()) {
            Pair p = que.poll();
            count++;
            for (int d = 0; d < 4; d++) {
                int ny = p.y + dy[d];
                int nx = p.x + dx[d];
                if (ny < 0 || ny >= N || nx < 0 || nx >= N || A[ny][nx] == 0) continue;
                A[ny][nx] = 0;
                que.add(new Pair(ny, nx));
            }
        }
        answer.add(count);
    }

    static class Pair {
        int y, x;

        public Pair(int x, int y) {
            this.y = x;
            this.x = y;
        }
    }
}
